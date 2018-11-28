/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.controller;

import Project.controller.exceptions.NonexistentEntityException;
import Project.controller.exceptions.PreexistingEntityException;
import Project.controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Project.model.ProductOrder;
import Project.model.ProductOrderItem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joeseph-PC
 */
public class ProductOrderItemJpaController implements Serializable {

    public ProductOrderItemJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductOrderItem productOrderItem) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ProductOrder orderId = productOrderItem.getOrderId();
            if (orderId != null) {
                orderId = em.getReference(orderId.getClass(), orderId.getId());
                productOrderItem.setOrderId(orderId);
            }
            em.persist(productOrderItem);
            if (orderId != null) {
                orderId.getProductOrderItemList().add(productOrderItem);
                orderId = em.merge(orderId);
            }
            utx.commit();
        } catch (Exception ex) {
            System.out.println(ex);
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProductOrderItem(productOrderItem.getId()) != null) {
                throw new PreexistingEntityException("ProductOrderItem " + productOrderItem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductOrderItem productOrderItem) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ProductOrderItem persistentProductOrderItem = em.find(ProductOrderItem.class, productOrderItem.getId());
            ProductOrder orderIdOld = persistentProductOrderItem.getOrderId();
            ProductOrder orderIdNew = productOrderItem.getOrderId();
            if (orderIdNew != null) {
                orderIdNew = em.getReference(orderIdNew.getClass(), orderIdNew.getId());
                productOrderItem.setOrderId(orderIdNew);
            }
            productOrderItem = em.merge(productOrderItem);
            if (orderIdOld != null && !orderIdOld.equals(orderIdNew)) {
                orderIdOld.getProductOrderItemList().remove(productOrderItem);
                orderIdOld = em.merge(orderIdOld);
            }
            if (orderIdNew != null && !orderIdNew.equals(orderIdOld)) {
                orderIdNew.getProductOrderItemList().add(productOrderItem);
                orderIdNew = em.merge(orderIdNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productOrderItem.getId();
                if (findProductOrderItem(id) == null) {
                    throw new NonexistentEntityException("The productOrderItem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ProductOrderItem productOrderItem;
            try {
                productOrderItem = em.getReference(ProductOrderItem.class, id);
                productOrderItem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productOrderItem with id " + id + " no longer exists.", enfe);
            }
            ProductOrder orderId = productOrderItem.getOrderId();
            if (orderId != null) {
                orderId.getProductOrderItemList().remove(productOrderItem);
                orderId = em.merge(orderId);
            }
            em.remove(productOrderItem);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductOrderItem> findProductOrderItemEntities() {
        return findProductOrderItemEntities(true, -1, -1);
    }

    public List<ProductOrderItem> findProductOrderItemEntities(int maxResults, int firstResult) {
        return findProductOrderItemEntities(false, maxResults, firstResult);
    }

    private List<ProductOrderItem> findProductOrderItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductOrderItem.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ProductOrderItem findProductOrderItem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductOrderItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductOrderItemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductOrderItem> rt = cq.from(ProductOrderItem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
