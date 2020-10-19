<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<jsp:include page="popup/training_description.jsp"/>

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
								<table class="table" id="trainerTrainings">
								<thead class=" text-primary">
								<th>
									<fmt:message key="schedule_trainer.client"/>
								</th>
								<th>
									<fmt:message key="schedule_trainer.date"/>
								<th>
									<fmt:message key="schedule_trainer.time"/>
								</th>
								</th>
								<th>
									<fmt:message key="schedule_trainer.description"/>
								</th>
								<th>

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
												${training.time}
										</td>
										<td>
											<textarea class="form-control" readonly rows="2" placeholder="<fmt:message key="schedule_trainer.addDescription"/>">${training.description}</textarea>
										</td>
										<td>
											<fmt:message key="schedule_trainer.tooltipEdite" var="editTraining"/>
											<a href="#popupDescription">
												<button type="submit" rel="tooltip" class="btn btn-danger btn-round" data-toggle="tooltip" title="${editTraining}" onclick="updateDescriptionOnClick('${training.description}', '${training.trainingId}')">
													<i class="material-icons">edit</i>
												</button>
											</a>
										</td>
									</tr>
								</c:forEach>
								</tbody>
								<ctg:pagination tableId="trainerTrainings"/>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<script>
    function updateDescriptionOnClick(descr, trId) {
        document.getElementById('trainingDescription').innerText = descr;
        document.getElementById('trainingId').setAttribute('value', trId);
    }
</script>
