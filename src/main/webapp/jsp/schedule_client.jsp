<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- PopUp Buy Start -->
<a href="#x" class="overlay" id="popupBuy"></a>
<div class="popup">
    <div class="text-center">
        <div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="card-img-top mb-3 w-auto" src="/assets/img/five.png"  alt="Buy" >
                    <p/>
                    <form action="/mainController" method="post">
                        <input type="hidden" name="command" value="buy_trainings"/>
                        <input type="hidden" name="number" value="5"/>
                        <button class="primary-btn">
                            <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*5*20} <fmt:message key="buy_trainings.br"/>
                        </button>
                    </form>
                </div>
                <div class="carousel-item">
                    <img class="card-img-top mb-3 w-auto" src="/assets/img/ten.png"  alt="Buy" >
                    <p/>
                    <form action="/mainController" method="post">
                        <input type="hidden" name="command" value="buy_trainings"/>
                        <input type="hidden" name="number" value="10"/>
                        <button class="primary-btn" type="submit">
                            <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*10*20} <fmt:message key="buy_trainings.br"/>
                        </button>
                    </form>
                </div>
                <div class="carousel-item">
                    <img class="card-img-top mb-3 w-auto" src="/assets/img/twenty.png"  alt="Buy" >
                    <p/>
                    <form action="/mainController" method="post">
                        <input type="hidden" name="command" value="buy_trainings"/>
                        <input type="hidden" name="number" value="20"/>
                        <button class="primary-btn">
                            <fmt:message key="buy_trainings.buyFor"/> ${(100 - user.personalDiscount)/100*20*20} <fmt:message key="buy_trainings.br"/>
                        </button>
                    </form>
                </div>
            </div>
            <!-- Navigation -->
            <a class="carousel-control-prev bg-dark" href="#carousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only"><fmt:message key="buy_trainings.next"/></span>
            </a>
            <a class="carousel-control-next bg-dark" href="#carousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only"><fmt:message key="buy_trainings.previous"/></span>
            </a>
        </div>
    </div>
    <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>
<!-- PopUp Buy Start -->

<!-- PopUp Add Training Start -->
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
            <button class="primary-btn" type="submit">
                <fmt:message key="add_training.add"/>
            </button>
        </div>
        <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
    </div>
</form>
<!-- PopUp Add Training End -->

<!-- Client Schedule Section Begin -->
<section class="trainer-schedule class-timetable spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <a href="#popupBuy" style="alignment: center;">
                        <button class="primary-btn">
                            <fmt:message key="schedule.buyTrainings"/>
                        </button>
                    </a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule.yourBalance"/> ${user.moneyBalance} <fmt:message key="schedule.br"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="site-text">
                    <fmt:message key="schedule.youHave"/> ${user.boughtTrainings} <fmt:message key="schedule.boughtTrainings"/>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header card-header-primary">
                        <h4 class="card-title "><fmt:message key="schedule.tableTitle"/></h4>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead class=" text-primary">
                                <th>
                                    <fmt:message key="schedule.trainer"/>
                                </th>
                                <th>
                                    <fmt:message key="schedule.date"/>
                                </th>
                                <th>
                                    <fmt:message key="schedule.description"/>
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

                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                            <a href="#popupAdd" style="alignment: center;">
                                <button class="primary-btn">
                                    <fmt:message key="schedule.add"/>
                                </button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>