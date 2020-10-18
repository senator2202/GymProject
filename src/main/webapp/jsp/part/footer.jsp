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
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d33245.297803635964!2d-73.76987401620775!3d40.704774398815005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew%20York%2C%20NY%2C%20USA!5e0!3m2!1sen!2sbd!4v1575866843291!5m2!1sen!2sbd"
					        style="border:0;" allowfullscreen=""></iframe>
					<div class="map-widget">
						<i class="fa fa-map-marker"></i>
						<div class="map-address">
							<img src="assets/img/map-location.jpg" alt="">
							<ul class="map-text">
								<li><span>Address:</span> Iris Watson, Box 283,
									NY
								</li>
								<li><span>Phone:</span> 12-456-791</li>
							</ul>
						</div>
					</div>
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
										<input type="text" placeholder="Email" name="senderEmail" id="senderEmail">
									</div>
									<div class="col-lg-12">
										<input type="text" name="feedbackSubject"
										       placeholder="Subject" id="feedbackSubject">
										<textarea name="feedbackMessage" id="feedbackMessage"
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
	<div class="register">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>document.write(new Date().getFullYear());</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart-o" aria-hidden="true"></i> by <a
							href="https://colorlib.com"
							target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
					<div class="footer-widget">
						<ul>
							<li>Privacy Policy</li>
							<li>Terms Of Service</li>
							<li>Careers</li>
						</ul>
					</div>
					<div class="footer-links">
						<a href="#"><i class="fa fa-facebook"></i></a>
						<a href="#"><i class="fa fa-twitter"></i></a>
						<a href="#"><i class="fa fa-instagram"></i></a>
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