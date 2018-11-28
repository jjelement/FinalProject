<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/toastr.min.js"></script>
<script src="assets/js/bootstrap-slider.min.js"></script>

<script>
    $(document).ready(function() {
        $('.fav-btn').hover(function() {
            $(this).find('i').removeClass('far').addClass('fa')
        }, function() {
            $(this).find('i').removeClass('fa').addClass('far')
        })
        <c:if test="${error != null}">
            toastr.error("${error}!");
        </c:if>
        <c:if test="${success != null}">
            toastr.success("${success}!");
        </c:if>
    })
</script>