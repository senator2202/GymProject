<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>Personal profile</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/login.css"/>
    <link rel="stylesheet" href="assets/css/magnific-popup.css"/>
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="assets/css/slicknav.min.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>
    <link rel="stylesheet" href="assets/css/themify-icons.css"/>
</head>

<body>
<c:import url="part/header.jsp"/>

<%--<div class="col-lg-6">--%>
    <div class="footer-form set-bg" data-setbg="assets/img/contact-form-bg.jpg">
        <div class="row">
            <div class="col-lg-10">
                <div class="section-title">
                    <h2>Personal Information</h2>
                    <p>We would appreciate it if you add more information about
                        yourself.</p>
                </div>
                <form action="/mainController" method="post">
                    <input type="hidden" name="command" value="update_personal_info">
                    <div class="row">
                        <div class="col-lg-6"><input type="text" name="firstName" value="${sessionScope.user.firstName}"
                                                     placeholder="First Name"/>
                        </div>
                        <div class="col-lg-6"><input type="text" name="lastName" value="${sessionScope.user.lastName}"
                                                     placeholder="Last Name"/>
                        </div>
                        <div class="col-lg-12"><input type="text" name="phone" value="${sessionScope.user.phoneNumber}"
                                                      placeholder="Phone"/>
                            <button type="submit">Save<i
                                    class="ti-angle-double-right"></i></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
<%--</div>--%>

<!-- Js Plugins -->
<script src="assets/js/jquery-3.3.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<script src="assets/js/mixitup.min.js"></script>
<script src="assets/js/jquery.slicknav.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/main.js"></script>
</body>

</html>