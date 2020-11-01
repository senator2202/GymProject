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

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" type="text/css"
	      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css">
	<!-- CSS Files -->
	<link href="/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet"/>
	<link href="/assets/css/style.css" rel="stylesheet"/>
	<link href="/assets/css/slicknav.min.css" rel="stylesheet"/>
	<link href="/assets/css/img-upload.css" rel="stylesheet"/>

	<script src="/assets/js/jquery-3.3.1.min.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
</head>

<body>

<jsp:include page="/jsp/part/header_black_no_logo.jsp"/>

<div class="wrapper">
	<jsp:include page="/jsp/personal_sidebar.jsp"/>

	<form action="/mainController" method="post">
		<input type="hidden" name="command" value="update_personal_data">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title "><fmt:message key="personal_profile.personalData"/></h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table id="feedTable" class="table">
											<thead class=" text-primary">
											<th>

											</th>
											<th>

											</th>
											</thead>
											<tbody>
											<tr>
												<td>
												</td>
											</tr>
											<tr>
												<td>
													<fmt:message key="personal_profile.firstNameHint"/>
												</td>
												<td>
													<input type="text" id="firstName" name="firstName"
													       class="form-control" value="${sessionScope.user.firstName}"
													       pattern="\p{L}{1,30}"/>
												</td>
											</tr>
											<tr>
												<td>
													<fmt:message key="personal_profile.lastNameHint"/>
												</td>
												<td>
													<input type="text" id="lastName" name="lastName"
													       class="form-control" value="${sessionScope.user.lastName}"
													       pattern="\p{L}{1,30}"/>
												</td>
											</tr>
											<tr>
												<td>
													<fmt:message key="personal_profile.phoneHint"/>
												</td>
												<td>
													<input type="text" id="phone" name="phone"
													       class="form-control" value="${sessionScope.user.phoneNumber}"
													       pattern="^((80\d{2})|(\+375\d{2}))[1-9]\d{6}$"/>
												</td>
											</tr>
											<c:if test="${sessionScope.user.account.role=='TRAINER'}">
												<tr>
													<td>
														Institution
													</td>
													<td>
														<input type="text" id="institution" name="institution" readonly
														       class="form-control"
														       value="${sessionScope.user.institution}"/>
													</td>
												</tr>
												<tr>
													<td>
														Graduation year
													</td>
													<td>
														<input type="text" id="graduationYear" name="graduationYear"
														       readonly
														       class="form-control"
														       value="${sessionScope.user.graduationYear}"/>
													</td>
												</tr>
												<tr>
													<td>
														Instagram Link
													</td>
													<td>
														<input type="text" id="instagramLink" name="instagramLink"
														       class="form-control"
														       value="${sessionScope.user.instagramLink}"/>
													</td>
												</tr>
											</c:if>
											<tr>
												<td>
													<button type="submit" class="btn btn-primary">
														<fmt:message key="personal_profile.save"/>
													</button>
												</td>
											</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<script src="/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/assets/js/jquery.slicknav.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/main.js"></script>
<script src="/assets/js/core/popper.min.js"></script>
<script src="/assets/js/img-upload.js"></script>

</body>

</html>
