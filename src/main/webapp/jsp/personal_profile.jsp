<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
			   scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8"/>
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, shrink-to-fit=yes"/>
	<title><fmt:message key="personal_profile.personalProfile"/></title>


	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
	<link rel="stylesheet" href="/assets/css/login.css"/>
	<link rel="stylesheet" href="/assets/css/magnific-popup.css"/>
	<link rel="stylesheet" href="/assets/css/owl.carousel.min.css"/>
	<link rel="stylesheet" href="/assets/css/slicknav.min.css"/>
	<link rel="stylesheet" href="/assets/css/style.css"/>
	<link rel="stylesheet" href="/assets/css/themify-icons.css"/>
	<link rel="stylesheet" href="/assets/css/select-list.css"/>
	<link rel="stylesheet" href="/assets/css/popup.css"/>
</head>

<body>


<c:import url="part/header.jsp"/>

<div class="footer-form set-bg" data-setbg="assets/img/contact-form-bg.jpg">
	<div class="col-lg-10">
		<div class="section-title">
			<h2><fmt:message key="personal_profile.personalInformation"/></h2>
			<p><fmt:message key="personal_profile.suggestion"/></p>
		</div>
	</div>
	<div class="col-lg-10">
		<c:choose>
			<c:when test="${user.imageName==null}">
				<form action="/uploadController" enctype="multipart/form-data" method="post">
					<input MULTIPLE type="file" name="content" height="130"/>
					<button type="submit">
						<fmt:message key="personal_profile.addImage"/>
						<i class="ti-angle-double-right"></i>
					</button>
				</form>
			</c:when>
			<c:otherwise>
				<img src="${user.imageName}" style="max-width: 200px; max-height: 200px;"/>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="col-lg-10">
		<p/>
		<p/>
		<p/>
		<p/>
		<p/>
		<c:choose>
			<c:when test="${user.account.role=='CLIENT'}">
				<a href="#win1">
					<button class="primary-btn">
						<fmt:message key="personal_profile.becomeTrainer"/>
					</button>
				</a>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${applicationResult==true}">
				<fmt:message key="personal_profile.sentApplication"/>
			</c:when>
			<c:when test="${applicationResult==false}">
				<fmt:message key="personal_profile.failedApplication"/>
			</c:when>
			<c:when test="${alreadySent==true}">
				<fmt:message key="personal_profile.alreadySent"/>
			</c:when>
		</c:choose>

		<!--popup window start-->
		<form action="/mainController">
			<input type="hidden" name="command" value="send_trainer_application"/>
			<a href="#x" class="overlay" id="win1"></a>
			<div class="popup">
				<div class="col-lg-6">
					<label for="institution">
						<fmt:message key="trainer_popup.institution"/>
					</label>
					<input type="text" id="institution" name="institution"/>
				</div>
				<div class="col-lg-6">
					<label for="graduationYear">
						<fmt:message key="trainer_popup.year"/>
					</label>
					<input type="text" id="graduationYear" name="graduationYear"/>
				</div>
				<div class="col-lg-6">
					<label for="instagramLink">
						<fmt:message key="trainer_popup.instagram"/>
					</label>
					<input type="text" id="instagramLink" name="instagramLink"/>
				</div>
				<button type="submit">
					<fmt:message key="trainer_popup.send"/>
					<i class="ti-angle-double-right"></i>
				</button>
				<a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
			</div>
		</form>
		<!--popup window end-->
		<p/>
		<p/>
		<p/>
		<p/>
		<p/>
		<p/>
		<p/>
		<form action="/mainController" method="post">
			<input type="hidden" name="command" value="update_personal_info">
			<div class="row">
				<div class="col-lg-6">
					<label for="firstName" class="text-light">
						<fmt:message key="personal_profile.firstNameHint"/>
					</label>
					<input type="text" id="firstName" name="firstName"
						   value="${sessionScope.user.firstName}"/>
				</div>
				<div class="col-lg-6">
					<label for="lastName" class="text-light">
						<fmt:message key="personal_profile.lastNameHint"/>
					</label>
					<input type="text" id="lastName" name="lastName"
						   value="${sessionScope.user.lastName}"/>
				</div>
				<div class="col-lg-6">
					<label for="phone" class="text-light">
						<fmt:message key="personal_profile.phoneHint"/>
					</label>
					<input type="text" id="phone" name="phone"
						   value="${sessionScope.user.phoneNumber}"/>
				</div>
				<div class="col-lg-6">
					<label for="profileEmail" class="text-light">
						<fmt:message key="personal_profile.email"/>
					</label>
					<input type="text" id="profileEmail" name="email"
					       value="${sessionScope.user.account.email}"/>
				</div>
			</div>

			<c:if test="${user.account.role.toString()=='CLIENT'}">
				<div class="text-light">
					<fmt:message key="personal_profile.moneyBalance"/> ${user.moneyBalance}
				</div>
				<p/>
				<p/>
				<p/>
				<p/>
				<div class="text-light">
					<fmt:message key="personal_profile.personalDiscount"/> ${user.personalDiscount}
				</div>
				<p/>
				<p/>
				<p/>
				<p/>
			</c:if>

			<div class="select">
				<select name="locale" id="slct">
					<option selected disabled><fmt:message
							key="personal_profile.selectList"/></option>
					<option value="english"><fmt:message
							key="personal_profile.english"/></option>
					<option value="russian"><fmt:message
							key="personal_profile.russian"/></option>
				</select>
			</div>
			<p/>
			<p/>
			<p/>
			<p/>
			<p/>
			<p/>
			<p/>
			<button type="submit">
				<fmt:message key="personal_profile.save"/>
				<i class="ti-angle-double-right"></i>
			</button>
		</form>
	</div>
</div>



<!-- Js Plugins -->
<script src="/assets/js/jquery-3.3.1.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/assets/js/mixitup.min.js"></script>
<script src="/assets/js/jquery.slicknav.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/main.js"></script>
</body>

</html>