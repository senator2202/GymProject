<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalEditTraining" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
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
                            <input type="hidden" name="command" value="update_training">
                            <input type="hidden" name="trainingId" id="editTrainingId">
                            <div class="form-group">
                                <div class="select">
                                    <select name="trainer" id="slct" disabled>
                                        <option selected disabled id="editTrainerName"></option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="date" name="trainingDate" id="editTrainingDate"/>
                            </div>
                            <div class="form-group">
                                <input type="time" name="trainingTime" id="editTrainingTime"/>
                            </div>
                            <div class="form-group">
								<textarea class="form-control" rows="4" id="editTrainingDescription"
                                          name="trainingDescription">
								</textarea>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2"><fmt:message
                                    key="edit_training.edit"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>