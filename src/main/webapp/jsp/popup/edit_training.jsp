<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<link rel="stylesheet" href="/assets/css/font-awesome.min.css">

<div class="modal fade" id="modalEditTraining" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title w-100 text-center">
					<fmt:message key="edit_training.header"/>
				</h5>
			</div>
			<div class="modal-body">
				<div class="card" style="margin-top: 0px; margin-bottom: 0px;">
					<div class="card-body">
						<form action="/mainController" method="post">
							<input type="hidden" name="command" value="update_training_date_time">
							<input type="hidden" name="trainingId" id="trainingId">
							<div class="form-group">
								<div class="select">
									<select name="trainer" id="slct" disabled>
										<option selected disabled id="trainerName"></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<input type="date" name="trainingDate" id="trainingDate"/>
							</div>
							<div class="form-group">
								<input type="time" name="trainingTime" id="trainingTime"/>
							</div>
							<button type="submit" class="btn btn-primary mb-2"><fmt:message key="edit_training.edit"/></button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="/assets/js/modal-data.js"></script>
