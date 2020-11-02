<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- Footer Section Begin -->
<footer class="footer-section">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<div class="map-location">
					<iframe src="https://maps.google.com/maps?q=minsk%20adrenalin%20loshitsa&t=&z=13&ie=UTF8&iwloc=&output=embed"
					        style="border:0;" allowfullscreen=""></iframe>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="footer-form set-bg"
				     data-setbg="assets/img/contact-form-bg.jpg">
					<div class="row">
						<div class="col-lg-10">
							<div class="section-title">
								<h2>Give us feedback</h2>
								<p>Shape your body and burn fat with strength
									training. With the right equipment
									such as free weights or resistance
									machines.</p>
							</div>
							<form action="/mainController" method="post">
								<input type="hidden" name="command" value="add_feedback"/>
								<div class="row">
									<div class="col-lg-6">
										<input type="text" placeholder="Name" name="senderName" id="senderName">
									</div>
									<div class="col-lg-6">
										<input type="email" placeholder="Email" name="senderEmail" id="senderEmail" required>
									</div>
									<div class="col-lg-12">
										<input type="text" name="feedbackSubject"
										       placeholder="Subject" id="feedbackSubject">
										<textarea name="feedbackMessage" id="feedbackMessage" required
												placeholder="Message"></textarea>
										<button type="submit" onclick="clearForm()">Submit <i
												class="ti-angle-double-right"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<!-- Footer Section End -->

<script>
	function clearForm() {
		document.getElementById("senderName").innerText="";
        document.getElementById("senderEmail").innerText="";
        document.getElementById("feedbackSubject").innerText="";
        document.getElementById("feedbackMessage").innerText="";
    }
</script>