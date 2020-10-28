<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<jsp:include page="/jsp/popup/buy_trainings.jsp"/>
<jsp:include page="/jsp/popup/add_training.jsp"/>
<jsp:include page="/jsp/popup/edit_training.jsp"/>
<jsp:include page="/jsp/popup/rating.jsp"/>
<jsp:include page="/jsp/popup/low_balance.jsp"/>

<ctg:message/>

<!-- Client Schedule Section Begin -->
<section class="trainer-schedule class-timetable spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <button type="button" class="btn btn-outline-primary btn-round"
                            data-toggle="modal" data-target="#modalBuyTrainings">
                        <fmt:message key="schedule_client.buyTrainings"/>
                    </button>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule_client.yourBalance"/> ${user.moneyBalance} <fmt:message
                        key="schedule_client.br"/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule_client.youHave"/> ${user.boughtTrainings} <fmt:message
                        key="schedule_client.boughtTrainings"/>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header card-header-primary">
                        <h4 class="card-title text-center"><fmt:message key="schedule_client.tableTitle"/></h4>
                        <ul class="nav nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#plannedTab"><fmt:message
                                        key="schedule_client.planned"/></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#previousTab"><fmt:message
                                        key="schedule_client.previous"/></a>
                            </li>
                        </ul>
                    </div>

                    <div class="card-body">
                        <div class="tab-content">
                            <div class="tab-pane active" id="plannedTab">
                                <div class="table-responsive">
                                    <table class="table" id="clientTrainings">
                                        <thead class=" text-primary">
                                        <th>
                                            <fmt:message key="schedule_client.trainer"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.date"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.time"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.description"/>
                                        </th>
                                        <th width="50">

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${plannedTrainings}" var="training">
                                            <tr>
                                                <td>
                                                        ${training.trainerFirstName} ${training.trainerLastName}
                                                </td>
                                                <td>
                                                        ${training.date}
                                                </td>
                                                <td>
                                                        ${training.time}
                                                </td>
                                                <td>
                                                    <textarea class="form-control" style="background-color: white"
                                                              placeholder="<fmt:message key="schedule_client.notReady"/>"
                                                              rows="2" readonly>${training.description}</textarea>
                                                </td>
                                                <td class="td-actions justify-content-between align-middle">
                                                    <button type="submit" rel="tooltip"
                                                            class="btn btn-outline-primary btn-round"
                                                            data-toggle="modal" data-target="#modalEditTraining"
                                                            title="<fmt:message key='schedule_client.tooltipEdit'/>"
                                                            data-trainingid="${training.trainingId}"
                                                            data-trainername="${training.trainerFirstName} ${training.trainerLastName}"
                                                            data-trainingdate="${training.date}"
                                                            data-trainingtime="${training.time}"
                                                            data-trainingdescription="${training.description}">
                                                        <i class="material-icons">edit</i>
                                                    </button>
                                                    <fmt:message key="schedule_client.tooltipCancel" var="cancel"/>
                                                    <ctg:cancel-button trainingId="${training.trainingId}"
                                                                       tooltip="${cancel}"/>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        <ctg:table-utility tableId="clientTrainings" order="1" direction="asc"/>
                                    </table>
                                    <button type="button" id="addButton" class="btn btn-outline-primary btn-round"
                                            data-toggle="modal"
                                            data-target="${user.boughtTrainings>0 ? '#modalAddTraining' : '#modalAddError'}">
                                        <fmt:message key="schedule_client.add"/>
                                    </button>
                                </div>
                            </div>
                            <div class="tab-pane" id="previousTab">
                                <div class="table-responsive">
                                    <table class="table" id="clientPreviousTrainings">
                                        <thead class=" text-primary">
                                        <th>
                                            <fmt:message key="schedule_client.trainer"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.date"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.time"/>
                                        </th>
                                        <th>
                                            <fmt:message key="schedule_client.description"/>
                                        </th>
                                        <th>

                                        </th>
                                        <th>

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${previousTrainings}" var="training">
                                            <tr>
                                                <td>
                                                        ${training.trainerFirstName} ${training.trainerLastName}
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
                                                <td>
                                                    <div class="ratingView" data-score="${training.rating}"></div>
                                                </td>
                                                <td class="td-actions text-right">
                                                    <button type="submit" rel="tooltip"
                                                            class="btn btn-outline-primary btn-round"
                                                            data-toggle="modal" data-target="#modalRating" title="rate"
                                                            .
                                                            data-trainingid="${training.trainingId}"
                                                            data-trainerid="${training.trainerId}">
                                                        <i class="material-icons">star_rate</i>
                                                    </button>
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