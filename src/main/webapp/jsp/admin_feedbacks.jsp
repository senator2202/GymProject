<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>

<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" href="../assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>
		<fmt:message key="admin.title"/>
	</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<!--     Fonts and icons     -->
	<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<!-- CSS Files -->
	<link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />

	<script src="<c:url value="/assets/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/assets/js/plugins/jquery.dataTables.min.js"/>"></script>

</head>

<body>
<div class="wrapper ">
	<jsp:include page="/jsp/admin_sidebar.jsp"/>

	<div class="main-panel">
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header card-header-primary">
								<h4 class="card-title "><fmt:message key="admin_feedbacks.tableTitle"/></h4>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table id="feedTable" class="table">
										<thead class=" text-primary">
										<th>
											<fmt:message key="admin_feedbacks.feedbackId"/>
										</th>
										<th>
											<fmt:message key="admin_feedbacks.feedbackDate"/>
										</th>
										<th>
											<fmt:message key="admin_feedbacks.senderName"/>
										</th>
										<th>
											<fmt:message key="admin_feedbacks.senderEmail"/>
										</th>
										<th>
											<fmt:message key="admin_feedbacks.feedbackSubject"/>
										</th>
										<th>
											<fmt:message key="admin_feedbacks.feedbackMessage"/>
										</th>
										<th>

										</th>
										</thead>
										<tbody>
										<c:forEach items="${feedbacks}" var="feedback">
											<tr>
												<td>
														${feedback.id}
												</td>
												<td>
														${feedback.date}
												</td>
												<td>
														${feedback.senderName}
												</td>
												<td>
														${feedback.senderEmail}
												</td>
												<td>
														${feedback.subject}
												</td>
												<td>
														${feedback.message}
												</td>
												<td class="td-actions text-right">
													<button type="button" class="btn btn-info btn-round"
													        data-toggle="modal" data-target="#">
														<i class="material-icons">person</i>
													</button>
												</td>
											</tr>
										</c:forEach>
										</tbody>
										<ctg:pagination tableId="feedTable"/>
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
</body>

</html>