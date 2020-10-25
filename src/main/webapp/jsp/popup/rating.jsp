<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalRating" role="dialog">
	<div class="modal-dialog modal-dialog-centered">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title w-100 text-center">
					Оцените тренировку
				</h5>
			</div>
			<form action="/mainController" method="post">
				<input type="hidden" name="command" value="rate_training">
				<input type="hidden" name="trainingId" id="trainingId">
				<input type="hidden" name="trainerId" id="trainerId">
				<div class="modal-body" >
					<div class="container">
						<input class="rating" name="trainingRating" style="align-content: center">
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary mr-auto">Оценить</button>
				</div>
			</form>
		</div>
	</div>
</div>