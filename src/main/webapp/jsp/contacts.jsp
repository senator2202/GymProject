<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="PONIGYM Template">
    <meta name="keywords" content="PONIGYM, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><fmt:message key="title"/></title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/themify-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" type="text/css">

    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<jsp:include page="${pageContext.request.contextPath}/jsp/section/header_black.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/jsp/modal/login.jsp"/>

<ctg:message/>

<!-- Map Section Begin -->
<div class="contact-map">
    <iframe src="https://maps.google.com/maps?q=minsk%20adrenalin%20loshitsa&t=&z=13&ie=UTF8&iwloc=&output=embed"
            style="border:0;" allowfullscreen=""></iframe>
</div>
<!-- Map Section End -->

<!-- Contact Section Begin -->
<section class="contact-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="contact-info">
                    <i class="ti-location-pin"></i>
                    <p><fmt:message key="contacts.address"/></p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="contact-info">
                    <i class="ti-email"></i>
                    <ul>
                        <li><span><fmt:message key="contacts.phoneLabel"/></span> <fmt:message key="contacts.phone"/>
                        </li>
                        <li><span><fmt:message key="contacts.mailLabel"/></span> <fmt:message key="contacts.mail"/></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="contact-info">
                    <i class="ti-timer"></i>
                    <ul>
                        <li><span><fmt:message key="contacts.workTimeLabel"/></span> <fmt:message
                                key="contacts.workTime"/></li>
                        <li><span><fmt:message key="contacts.sunday"/></span> <fmt:message key="contacts.close"/></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="contact-form">
            <div class="section-title">
                <h2><fmt:message key="footer.head"/></h2>
                <p><fmt:message key="footer.staff"/></p>
            </div>
            <form action="/mainController" method="post">
                <input type="hidden" name="command" value="add_feedback"/>
                <div class="row">
                    <div class="col-lg-6">
                        <input type="text" placeholder=
                                "<fmt:message key="footer.name"/>" name="senderName" id="senderName">
                    </div>
                    <div class="col-lg-6">
                        <input type="email" placeholder=
                                "<fmt:message key="footer.email"/> *" name="senderEmail" id="senderEmail" required>
                    </div>
                    <div class="col-lg-12">
                        <input type="text" name="feedbackSubject"
                               placeholder=
                                       "<fmt:message key="footer.subject"/>" id="feedbackSubject">
                        <textarea name="feedbackMessage" id="feedbackMessage" required
                                  placeholder="<fmt:message key="footer.message"/> *"></textarea>
                        <button type="submit"><fmt:message key="footer.submit"/> <i
                                class="ti-angle-double-right"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Contact Section End -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>

</html>