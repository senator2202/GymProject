<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- Client Schedule Section Begin -->
<section class="trainer-schedule class-timetable spad">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header card-header-primary">
						<h4 class="card-title "><fmt:message key="schedule_trainer.tableTitle"/></h4>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table">
								<thead class=" text-primary">
								<th>
									<fmt:message key="schedule_trainer.client"/>
								</th>
								<th>
									<fmt:message key="schedule_trainer.date"/>
								</th>
								<th>
									<fmt:message key="schedule_trainer.description"/>
								</th>
								</thead>
								<tbody>
								<c:forEach items="${trainings}" var="training">
									<tr>
										<td>
												${training.clientFirstName}  ${training.clientLastName}
										</td>
										<td>
												${training.date}
										</td>
										<td>

										</td>
									</tr>
								</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>