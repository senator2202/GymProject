<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<jsp:include page="popup/buy_trainings.jsp"/>
<jsp:include page="popup/add_training.jsp"/>

<!-- Client Schedule Section Begin -->
<section class="trainer-schedule class-timetable spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <a href="#popupBuy" style="alignment: center;">
                        <button class="primary-btn">
                            <fmt:message key="schedule_client.buyTrainings"/>
                        </button>
                    </a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule_client.yourBalance"/> ${user.moneyBalance} <fmt:message key="schedule_client.br"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule_client.youHave"/> ${user.boughtTrainings} <fmt:message key="schedule_client.boughtTrainings"/>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header card-header-primary">
                        <h4 class="card-title "><fmt:message key="schedule_client.tableTitle"/></h4>
                    </div>
                    <div class="card-body">
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
                                <th>

                                </th>
                                </thead>
                                <tbody>
                                <c:forEach items="${trainings}" var="training">
                                    <tr>
                                        <td>
                                                ${training.trainerFirstName}  ${training.trainerLastName}
                                        </td>
                                        <td>
                                                ${training.date}
                                        </td>
                                        <td>
                                                ${training.time}
                                        </td>
                                        <td>
                                            <textarea class="form-control" placeholder="<fmt:message key="schedule_client.notReady"/>" rows="2" readonly>${training.description}</textarea>
                                        </td>
                                        <td class="td-actions text-right">
                                            <fmt:message key="schedule_client.tooltipCancel" var="cancel"/>
                                            <form action="/mainController" method="post">
                                                <input type="hidden" name="command" value="cancel_training"/>
                                                <input type="hidden" name="trainingId" value="${training.trainingId}"/>
                                                <button type="submit" rel="tooltip" class="btn btn-danger btn-round" data-toggle="tooltip" title="${cancel}">
                                                    <i class="material-icons">close</i>
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <ctg:pagination tableId="clientTrainings"/>
                            </table>
                            <a href="#popupAdd" style="alignment: center;">
                                <button class="primary-btn">
                                    <fmt:message key="schedule_client.add"/>
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>