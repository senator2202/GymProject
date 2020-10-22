<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<link rel="stylesheet" href="/assets/css/font-awesome.min.css">
<link rel="stylesheet" href="/assets/css/user_profile.css">

<a href="#x" class="overlay" id="userProfile"></a>
<div class="popup">
	<div class="card">
		<img src="img.jpg" alt="John" style="width:100%">
		<h1>HTML CSS</h1>
		<p class="title">CEO & Founder, Example</p>
		<p>Harvard University</p>
		<a href="#"><i class="fa fa-dribbble"></i></a>
		<a href="#"><i class="fa fa-twitter"></i></a>
		<a href="#"><i class="fa fa-linkedin"></i></a>
		<a href="#"><i class="fa fa-facebook"></i></a>
		<p><button>Contact</button></p>
	</div>
	<a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>