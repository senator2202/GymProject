<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalAddTraining" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center">
                    <fmt:message key="add_training.header"/>
                </h5>
            </div>
            <div class="modal-body">
                <div class="card" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="card-body">
                        <form action="/mainController" method="post">
                            <input type="hidden" name="command" value="add_training">
                            <input type="hidden" name="trainerId" id="addTrainerId">
                            <div class="form-group">
                                <div class="select">
                                    <select name="selectedTrainerId" required>
                                        <option selected disabled value=""><fmt:message
                                                key="add_training.select"/></option>
                                        <c:forEach items="${trainers}" var="trainer">
                                            <option value="${trainer.account.id}">
                                                    ${trainer.firstName} ${trainer.lastName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="date" name="trainingDate" id="addTrainingDate" required/>
                            </div>
                            <div class="form-group">
                                <input type="time" name="trainingTime" id="addTrainingTime" required/>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2"><fmt:message
                                    key="add_training.add"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


