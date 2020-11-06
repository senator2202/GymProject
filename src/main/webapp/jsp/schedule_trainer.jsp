<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<jsp:include page="${pageContext.request.contextPath}/jsp/modal/edit_description.jsp"/>
<jsp:include page="${pageContext.request.contextPath}/jsp/modal/client_profile.jsp"/>

<section class="trainer-schedule class-timetable spad">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header card-header-primary">
                        <h4 class="card-title text-center"><fmt:message key="schedule_trainer.tableTitle"/></h4>
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#bookedTab"><fmt:message
                                        key="schedule_trainer.booked"/></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#doneTab"><fmt:message
                                        key="schedule_trainer.previous"/></a>
                            </li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <div class="tab-content">
                            <div class="tab-pane active" id="bookedTab">
                                <div class="table-responsive">
                                    <table class="table" id="trainerTrainings">
                                        <thead class=" text-primary" style="width: auto">
                                        <th>
                                            <fmt:message key="schedule_trainer.client"/>
                                        </th>
                                        <th>

                                        </th>
                                        <th>
                                            <fmt:message key="schedule_trainer.date"/>
                                        <th>
                                            <fmt:message key="schedule_trainer.time"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_trainer.description"/>
                                        </th>
                                        <th width="100">

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${plannedTrainings}" var="training">
                                            <tr>
                                                <td>
                                                        ${training.clientFirstName} ${training.clientLastName}
                                                </td>
                                                <td class="td-actions">
                                                    <fmt:message key="admin_feedbacks.openProfile" var="openProfile"/>
                                                    <ctg:profile-button user="${clientMap[training.clientId]}"
                                                                        tooltip="${openProfile}"/>
                                                </td>
                                                <td>
                                                        ${training.date}
                                                </td>
                                                <td>
                                                        ${training.time}
                                                </td>
                                                <td>
													<textarea class="form-control"
                                                              placeholder="<fmt:message key="schedule_trainer.addDescription"/>"
                                                              rows="2" readonly>${training.description}
                                                    </textarea>
                                                </td>
                                                <td class="td-actions justify-content-between">
                                                    <fmt:message key="schedule_trainer.tooltipEdite"
                                                                 var="editTraining"/>
                                                    <button type="submit" rel="tooltip"
                                                            class="btn btn-outline-primary btn-round"
                                                            data-toggle="modal" data-target="#modalDescription"
                                                            title="<fmt:message key='schedule_client.tooltipEdit'/>"
                                                            data-trainingid="${training.trainingId}"
                                                            data-trainingdescription="${training.description}">
                                                        <i class="material-icons">edit</i>
                                                    </button>
                                                    <form action="/mainController" method="post">
                                                        <input type="hidden" name="command" value="set_training_done"/>
                                                        <input type="hidden" name="trainingId"
                                                               value="${training.trainingId}"/>
                                                        <button type="submit" rel="tooltip" data-toggle="tooltip"
                                                                title="<fmt:message key="schedule_trainer.complete"/>"
                                                                class="btn btn-outline-success btn-round">
                                                            <i class="material-icons">done</i>
                                                        </button>
                                                    </form>
                                                    <fmt:message key="schedule_trainer.cancel" var="cancel"/>
                                                    <ctg:cancel-button trainingId="${training.trainingId}"
                                                                       tooltip="${cancel}"/>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <ctg:table-utility tableId="trainerTrainings" order="2" direction="asc"/>
                                    </table>
                                </div>
                            </div>
                            <div class="tab-pane" id="doneTab">
                                <div class="table-responsive">
                                    <table class="table" id="clientPreviousTrainings">
                                        <thead class=" text-primary">
                                        <th>
                                            <fmt:message key="schedule_trainer.client"/>
                                        </th>
                                        <th>

                                        </th>
                                        <th>
                                            <fmt:message key="schedule_trainer.date"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_trainer.time"/>
                                        </th>
                                        <th class="th-description">
                                            <fmt:message key="schedule_trainer.description"/>
                                        </th>
                                        <th>

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${previousTrainings}" var="training">
                                            <tr>
                                                <td>
                                                        ${training.clientFirstName} ${training.clientLastName}
                                                </td>
                                                <td class="td-actions">
                                                    <fmt:message key="admin_feedbacks.openProfile" var="openProfile"/>
                                                    <ctg:profile-button user="${clientMap[training.clientId]}"
                                                                        tooltip="${openProfile}"/>
                                                </td>
                                                <td>
                                                        ${training.date}
                                                </td>
                                                <td>
                                                        ${training.time}
                                                </td>
                                                <td>
                                                    <textarea class="form-control"
                                                              placeholder="<fmt:message key="schedule_client.notReady"/>"
                                                              rows="2" readonly>${training.description}</textarea>
                                                </td>
                                                <td class="td-actions" style="display: table-cell">
                                                    <div class="ratingView" data-score="${training.rating}"></div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <ctg:table-utility tableId="clientPreviousTrainings" order="1" direction="asc"/>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
