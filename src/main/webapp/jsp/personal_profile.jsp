<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
    <title>Untitled</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="assets/css/login.css"/>
    <link rel="stylesheet" href="assets/css/magnific-popup.css"/>
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="assets/css/slicknav.min.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>
    <link rel="stylesheet" href="assets/css/themify-icons.css"/>

    <c:set var="currentFirstName" value="${sessionScope.user.firstName}"/>
    <c:set var="currentLastName" value="${sessionScope.user.lastName}"/>
    <c:set var="currentPhone" value="${sessionScope.user.phoneNumber}"/>
</head>

<body>
<header class="header-section">
    <div class="container">
        <div class="logo"><a href="index.jsp"><img src="assets/img/logo.png"
                                                   alt/></a></div>
        <div class="nav-menu">
            <nav class="mainmenu mobile-menu">
                <ul>
                    <li class="active"><a href="index.jsp">Home</a></li>
                    <li><a href="about-us.jsp">About</a></li>
                    <li><a href="schedule.jsp">Schedule</a></li>
                    <li><a href="gallery.jsp">Portfolio</a></li>
                    <li><a href="blog.jsp">Blog</a>
                        <ul class="dropdown">
                            <li><a href="blog-details.jsp">Blog Details</a></li>
                        </ul>
                    </li>
                    <li><a href="contact.jsp">Contacts</a></li>
                </ul>
            </nav>
            <div class="nav-right search-switch"><i class="ti-search"></i></div>
        </div>
        <div id="mobile-menu-wrap"></div>
    </div>
</header>

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
                        <div class="col-lg-6"><input type="text" name="firstName" value="${currentFirstName}"
                                                     placeholder="First Name"/>
                        </div>
                        <div class="col-lg-6"><input type="text" name="lastName" value="${currentLastName}"
                                                     placeholder="Last Name"/>
                        </div>
                        <div class="col-lg-12"><input type="text" name="phone" value="${currentPhone}"
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