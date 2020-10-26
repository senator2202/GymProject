<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalClientProfile" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title w-100 text-center">
					<fmt:message key="client_profile.name"/> <label id="nameText" style="color: #0b0b0b"></label>
				</h5>
			</div>
			<div class="modal-body">
				<div class="card" style="margin-top: 0px; margin-bottom: 0px;">
					<div class="card-header-image">
						<div class="avatar-upload">
							<div class="avatar-preview">
								<div id="imagePreview"></div>
							</div>
						</div>
					</div>
					<div class="card-body">
						<div class="container">
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.userType"/>
								</div>
								<div class="col-lg-6">
									<label id="roleText" style="color: #0b0b0b"></label>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.email"/>
								</div>
								<div class="col-lg-6">
									<label id="emailText" style="color: #0b0b0b"></label>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.phone"/>
								</div>
								<div class="col-lg-6">
									<label id="phoneText" style="color: #0b0b0b"></label>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.balance"/> Br
								</div>
								<div class="col-lg-6">
									<label id="moneyText" style="color: #0b0b0b"></label>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.discount"/>
								</div>
								<div class="col-lg-6">
									<label id="discountText" style="color: #0b0b0b"></label> %
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6">
									<fmt:message key="client_profile.trainings"/>
								</div>
								<div class="col-lg-6">
									<label id="boughtText" style="color: #0b0b0b"></label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
