/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.controller;

import Project.controller.exceptions.NonexistentEntityException;
import Project.controller.exceptions.PreexistingEntityException;
import Project.controller.exceptions.RollbackFailureException;
import Project.model.ProductOrder;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Project.model.ProductOrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Joeseph-PC
 */
public class ProductOrderJpaController implements Serializable {

    public ProductOrderJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductOrder productOrder) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (productOrder.getProductOrderItemList() == null) {
            productOrder.setProductOrderItemList(new ArrayList<ProductOrderItem>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<ProductOrderItem> attachedProductOrderItemList = new ArrayList<ProductOrderItem>();
            for (ProductOrderItem productOrderItemListProductOrderItemToAttach : productOrder.getProductOrderItemList()) {
                productOrderItemListProductOrderItemToAttach = em.getReference(productOrderItemListProductOrderItemToAttach.getClass(), productOrderItemListProductOrderItemToAttach.getId());
                attachedProductOrderItemList.add(productOrderItemListProductOrderItemToAttach);
            }
            productOrder.setProductOrderItemList(attachedProductOrderItemList);
            em.persist(productOrder);
            for (ProductOrderItem productOrderItemListProductOrderItem : productOrder.getProductOrderItemList()) {
                ProductOrder oldOrderIdOfProductOrderItemListProductOrderItem = productOrderItemListProductOrderItem.getOrderId();
                productOrderItemListProductOrderItem.setOrderId(productOrder);
                productOrderItemListProductOrderItem = em.merge(productOrderItemListProductOrderItem);
                if (oldOrderIdOfProductOrderItemListProductOrderItem != null) {
                    oldOrderIdOfProductOrderItemListProductOrderItem.getProductOrderItemList().remove(productOrderItemListProductOrderItem);
                    oldOrderIdOfProductOrderItemListProductOrderItem = em.merge(oldOrderIdOfProductOrderItemListProductOrderItem);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProductOrder(productOrder.getId()) != null) {
                throw new PreexistingEntityException("ProductOrder " + productOrder + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductOrder productOrder) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ProductOrder persistentProductOrder = em.find(ProductOrder.class, productOrder.getId());
            List<ProductOrderItem> productOrderItemListOld = persistentProductOrder.getProductOrderItemList();
            List<ProductOrderItem> productOrderItemListNew = productOrder.getProductOrderItemList();
            List<ProductOrderItem> attachedProductOrderItemListNew = new ArrayList<ProductOrderItem>();
            for (ProductOrderItem productOrderItemListNewProductOrderItemToAttach : productOrderItemListNew) {
                productOrderItemListNewProductOrderItemToAttach = em.getReference(productOrderItemListNewProductOrderItemToAttach.getClass(), productOrderItemListNewProductOrderItemToAttach.getId());
                attachedProductOrderItemListNew.add(productOrderItemListNewProductOrderItemToAttach);
            }
            productOrderItemListNew = attachedProductOrderItemListNew;
            productOrder.setProductOrderItemList(productOrderItemListNew);
            productOrder = em.merge(productOrder);
            for (ProductOrderItem productOrderItemListOldProductOrderItem : productOrderItemListOld) {
                if (!productOrderItemListNew.contains(productOrderItemListOldProductOrderItem)) {
                    productOrderItemListOldProductOrderItem.setOrderId(null);
                    productOrderItemListOldProductOrderItem = em.merge(productOrderItemListOldProductOrderItem);
                }
            }
            for (ProductOrderItem productOrderItemListNewProductOrderItem : productOrderItemListNew) {
                if (!productOrderItemListOld.contains(productOrderItemListNewProductOrderItem)) {
                    ProductOrder oldOrderIdOfProductOrderItemListNewProductOrderItem = productOrderItemListNewProductOrderItem.getOrderId();
                    productOrderItemListNewProductOrderItem.setOrderId(productOrder);
                    productOrderItemListNewProductOrderItem = em.merge(productOrderItemListNewProductOrderItem);
                    if (oldOrderIdOfProductOrderItemListNewProductOrderItem != null && !oldOrderIdOfProductOrderItemListNewProductOrderItem.equals(productOrder)) {
                        oldOrderIdOfProductOrderItemListNewProductOrderItem.getProductOrderItemList().remove(productOrderItemListNewProductOrderItem);
                        oldOrderIdOfProductOrderItemListNewProductOrderItem = em.merge(oldOrderIdOfProductOrderItemListNewProductOrderItem);
                    }
                }
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
                Integer id = productOrder.getId();
                if (findProductOrder(id) == null) {
                    throw new NonexistentEntityException("The productOrder with id " + id + " no longer exists.");
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
            ProductOrder productOrder;
            try {
                productOrder = em.getReference(ProductOrder.class, id);
                productOrder.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productOrder with id " + id + " no longer exists.", enfe);
            }
            List<ProductOrderItem> productOrderItemList = productOrder.getProductOrderItemList();
            for (ProductOrderItem productOrderItemListProductOrderItem : productOrderItemList) {
                productOrderItemListProductOrderItem.setOrderId(null);
                productOrderItemListProductOrderItem = em.merge(productOrderItemListProductOrderItem);
            }
            em.remove(productOrder);
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

    public List<ProductOrder> findProductOrderEntities() {
        return findProductOrderEntities(true, -1, -1);
    }

    public List<ProductOrder> findProductOrderEntities(int maxResults, int firstResult) {
        return findProductOrderEntities(false, maxResults, firstResult);
    }

    private List<ProductOrder> findProductOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductOrder.class));
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

    public ProductOrder findProductOrder(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductOrder> rt = cq.from(ProductOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
