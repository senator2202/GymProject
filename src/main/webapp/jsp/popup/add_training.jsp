<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<link rel="stylesheet" href="/assets/css/font-awesome.min.css">

<div class="modal fade" id="modalAddTraining" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <!-- Modal content-->
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
                            <div class="form-group">
                                <div class="select">
                                    <select name="trainer" id="slct">
                                        <option selected disabled><fmt:message key="add_training.select"/></option>
                                        <c:forEach items="${trainers}" var="trainer">
                                            <option>${trainer.firstName} ${trainer.lastName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="date" name="trainingDate"/>
                            </div>
                            <div class="form-group">
                                <input type="time" name="trainingTime"/>
                            </div>
                            <button type="submit" class="btn btn-primary mb-2"><fmt:message key="add_training.add"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/assets/js/modal-data.js"></script>

<%--
<form action="/mainController" class="col-lg-10" method="post">
    <input type="hidden" name="command" value="add_training"/>
    <a href="#x" class="overlay" id="popupAdd"></a>
    <div class="popup">
        <div class="col-lg-6">
            <div class="select">
                <select name="trainer" id="slct">
                    <option selected disabled>Select trainer</option>
                    <c:forEach items="${trainers}" var="trainer">
                        <option>${trainer.firstName} ${trainer.lastName}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <p/>
        <p/>
        <div class="col-lg-6">
            <input type="date" name="trainingDate"/>
        </div>
        <p/>
        <p/>
        <div class="col-lg-6">
            <input type="time" name="trainingTime"/>
        </div>
        <p/>
        <p/>
        <div class="col-lg-6">
            <button class="primary-btn" type="submit">
                <fmt:message key="add_training.add"/>
            </button>
        </div>
        <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
    </div>
</form>--%>
