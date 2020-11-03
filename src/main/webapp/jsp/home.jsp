<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html lang="zxx">

<head>
	<meta charset="UTF-8">
	<meta name="description" content="PONIGYM Template">
	<meta name="keywords" content="PONIGYM, unica, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>PONIGYM | Template</title>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">


	<!-- Css Styles -->

	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/themify-icons.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/magnific-popup.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/slicknav.min.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/popup.css" type="text/css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/login.css" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/rating.css"/>

	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<jsp:include page="/jsp/part/header.jsp"/>
<jsp:include page="/jsp/modal/confirm_sent.jsp"/>
<jsp:include page="/jsp/modal/confirmed.jsp"/>
<jsp:include page="/jsp/modal/access_error.jsp"/>
<jsp:include page="/jsp/modal/login.jsp"/>
<jsp:include page="/jsp/modal/feedback_sent.jsp"/>
<jsp:include page="/jsp/modal/all_trainers.jsp"/>

<ctg:message/>

<section class="hero-section">
	<div class="hero-items owl-carousel">
		<div class="single-hero-item set-bg" data-setbg="assets/img/slider-bg-1.jpg">
			<div class="container">
				<div class="hero-text">
					<h4>Elite Personal Training Services</h4>
					<h1>Make it <span>Shape</span></h1>
					<c:choose>
						<c:when test="${user==null}">
							<button type="button" class="btn primary-btn" data-toggle="modal" data-target="#modalLogin">Join Us Now</button>
						</c:when>
						<c:otherwise>
							<a href="/mainController?command=open_personal_data">
								<button type="button" class="btn primary-btn">Personal Profile</button>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="single-hero-item set-bg" data-setbg="assets/img/slider-bg-2.jpg">
			<div class="container">
				<div class="hero-text">
					<h4>Elite Personal Training Services</h4>
					<h1>Make it <span>Shape</span></h1>
					<c:choose>
						<c:when test="${user==null}">
							<button type="button" class="btn primary-btn" data-toggle="modal" data-target="#modalLogin">Join Us Now</button>
						</c:when>
						<c:otherwise>
							<a href="/mainController?command=open_personal_data">
								<button type="button" class="btn primary-btn">Personal Profile</button>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="single-hero-item set-bg" data-setbg="assets/img/slider-bg-3.jpg">
			<div class="container">
				<div class="hero-text">
					<h4>Elite Personal Training Services</h4>
					<h1>Make it <span>Shape</span></h1>
					<c:choose>
						<c:when test="${user==null}">
							<button type="button" class="btn primary-btn" data-toggle="modal" data-target="#modalLogin">Join Us Now</button>
						</c:when>
						<c:otherwise>
							<a href="/mainController?command=open_personal_data">
								<button type="button" class="btn primary-btn">Personal Profile</button>
							</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Hero Section End -->

<!-- Team Section Begin -->
<section class="team-section spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title">
					<h2>Our Trainer</h2>
					<p>Our fitness experts can help you discover new training
						techniques.</p>
				</div>
				<button type="button" class="btn primary-btn" data-toggle="modal" data-target="#modalAllTrainers">View All</button>
			</div>
		</div>
		<div class="team-members">
			<div class="row m-0">
				<div class="col-lg-4 order-lg-1 p-0">
					<div class="member-pic first">
						<img src="${trainers.get(0).imageName}" alt="">
					</div>
				</div>
				<div class="col-lg-4 order-lg-2 p-0">
					<div class="member-text">
						<h5>${trainers.get(0).firstName} ${trainers.get(0).lastName}</h5>
						<p>${trainers.get(0).shortSummary}</p>
						<p>
							<div class="ratingView" data-score="${trainers.get(0).rating}" data-half="true"></div>
						</p>
					</div>
				</div>
				<div class="col-lg-4 order-lg-3 p-0">
					<div class="member-pic second">
						<img src="${trainers.get(1).imageName}" alt="">
					</div>
				</div>
				<div class="col-lg-4 order-lg-6 p-0">
					<div class="member-text second">
						<h5>${trainers.get(1).firstName} ${trainers.get(1).lastName}</h5>
						<p>${trainers.get(1).shortSummary}</p>
						<p>
						<div class="ratingView" data-score="${trainers.get(1).rating}" data-half="true"></div>
						</p>
					</div>
				</div>
				<div class="col-lg-4 order-lg-5 p-0">
					<div class="member-pic third">
						<img src="${trainers.get(2).imageName}" alt="">
					</div>
				</div>
					<div class="member-text third">
						<h5>${trainers.get(2).firstName} ${trainers.get(2).lastName}</h5>
						<p>${trainers.get(2).shortSummary}</p>
						<p>
						<div class="ratingView" data-score="${trainers.get(2).rating}" data-half="true"></div>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Team Section End -->

<jsp:include page="part/footer.jsp"/>

<!-- Search model Begin -->
<div class="search-model">
	<div class="h-100 d-flex align-items-center justify-content-center">
		<div class="search-close-switch">+</div>
		<form class="search-model-form">
			<input type="text" id="search-input" placeholder="Search here.....">
		</form>
	</div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/rating.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</body>

</html>
