<script src="assets/js/jquery-3.3.1.slim.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('.fav-btn').hover(function() {
            $(this).find('i').removeClass('far').addClass('fa')
        }, function() {
            $(this).find('i').removeClass('fa').addClass('far')
        })
    })
</script>