<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"/>
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
                <h2><fmt:message key="personal_profile.personalInformation"/></h2>
                <p><fmt:message key="personal_profile.suggestion"/></p>
            </div>
            <form action="/mainController" method="post">
                <input type="hidden" name="command" value="update_personal_info">
                <div class="row">
                    <div class="col-lg-6">
                        <fmt:message key="personal_profile.firstNameHint" var="first_hint"/>
                        <input type="text" name="firstName" value="${sessionScope.user.firstName}" placeholder="${first_hint}"/>
                    </div>
                    <div class="col-lg-6">
                        <fmt:message key="personal_profile.lastNameHint" var="last_hint"/>
                        <input type="text" name="lastName" value="${sessionScope.user.lastName}" placeholder="${last_hint}"/>
                    </div>
                    <div class="col-lg-12">
                        <fmt:message key="personal_profile.phoneHint" var="phone_hint"/>
                        <input type="text" name="phone" value="${sessionScope.user.phoneNumber}" placeholder="${phone_hint}"/>
                    </div>
                    <div class="col-lg-6">
                        <select name="locale" >
                            <option>English</option>
                            <option>Russian</option>
                        </select>
                    </div>
                    <button type="submit">
                        <fmt:message key="personal_profile.save"/>
                        <i class="ti-angle-double-right"></i>
                    </button>
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