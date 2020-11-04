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
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" type="text/css"
	      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<!-- CSS Files -->
	<link href="/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet"/>
	<link href="/assets/css/style.css" rel="stylesheet"/>
	<link href="/assets/css/slicknav.min.css" rel="stylesheet"/>
	<link href="/assets/css/select-list.css" rel="stylesheet"/>
	<link href="/assets/css/deposit.css" rel="stylesheet"/>
	<link href="/assets/css/img-upload.css" rel="stylesheet"/>

	<script src="/assets/js/jquery-3.3.1.min.js"></script>
	<script src="/assets/js/bootstrap.min.js"></script>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
	<div class="loader"></div>
</div>

<jsp:include page="/jsp/part/header_black_no_logo.jsp"/>
<jsp:include page="/jsp/modal/deposit.jsp"/>

<div class="wrapper">
	<jsp:include page="/jsp/personal_sidebar.jsp"/>

	<div class="main-panel">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header card-header-primary">
								<h4 class="card-title "><fmt:message key="personal_profile.finance"/></h4>
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
												<fmt:message key="personal_profile.moneyBalance"/>
											</td>
											<td>
												<input type="text" id="moneyBalance" name="moneyBalance" readonly
												       class="form-control" value="${sessionScope.user.moneyBalance}"/>
											</td>
										</tr>
										<tr>
											<td>
												<fmt:message key="personal_profile.personalDiscount"/>
											</td>
											<td>
												<input type="text" id="personalDiscount" name="personalDiscount"
												       readonly
												       class="form-control"
												       value="${sessionScope.user.personalDiscount}"/>
											</td>
										</tr>
										<tr>
											<td>
												<button type="button" class="btn btn-primary" data-toggle="modal"
												        data-target="#popupDeposit"><fmt:message
														key="personal_profile.deposit"/></button>
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
</div>

<script src="/assets/js/jquery.magnific-popup.min.js"></script>
<script src="/assets/js/jquery.slicknav.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/main.js"></script>
<script src="/assets/js/core/popper.min.js"></script>
<script src="/assets/js/img-upload.js"></script>

</body>

</html>