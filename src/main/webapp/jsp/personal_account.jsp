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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<!-- CSS Files -->
	<link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/assets/css/slicknav.min.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/assets/css/select-list.css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/assets/css/img-upload.css" rel="stylesheet"/>

	<script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
	<
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<jsp:include page="${pageContext.request.contextPath}/jsp/section/header_black.jsp"/>

<div class="wrapper">
	<jsp:include page="${pageContext.request.contextPath}/jsp/personal_sidebar.jsp"/>

	<form action="/mainController" method="post">
		<input type="hidden" name="command" value="update_account_data">
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header card-header-primary">
									<h4 class="card-title "><fmt:message key="personal_profile.accountData"/></h4>
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
													<fmt:message key="personal_profile.login"/>
												</td>
												<td>
													<input type="text" id="login" name="login" readonly
													       class="form-control"
													       value="${sessionScope.user.account.name}"/>
												</td>
											</tr>
											<tr>
												<td>
													<fmt:message key="personal_profile.email"/>
												</td>
												<td>
													<input type="email" id="phone" name="email" required
													       class="form-control"
													       value="${sessionScope.user.account.email}"/>
												</td>
											</tr>
											<tr>
												<td>
													<fmt:message key="personal_profile.language"/>
												</td>
												<td>
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
												</td>
											</tr>
											<tr>
												<td>
													<button type="submit" class="btn btn-primary">
														<fmt:message key="personal_profile.save"/>
													</button>
												</td>
												<td>
													<c:if test="${incorrectEmailFormat==true}">
														<label style="color: red; font-size: medium"><fmt:message
																key="personal_profile.incorrectEmailFormat"/></label>
													</c:if>
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

<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/core/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/img-upload.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/modal-data.js"></script>

</body>

</html>