<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalBuyTrainings" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center">
                    Buy Trainings
                </h5>
            </div>
            <div class="modal-body">
                <div class="card" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="card-body">
                        <div class="text-center">
                            <div id="carousel" class="carousel slide" data-ride="carousel" data-interval="false">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img class="card-img-top mb-3 w-auto" src="/assets/img/five.png"  alt="Buy" >
                                        <p/>
                                        <form action="/mainController" method="post">
                                            <input type="hidden" name="command" value="buy_trainings"/>
                                            <input type="hidden" name="number" value="5"/>
                                            <button class="btn btn-outline-primary btn-round">
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
                                            <button class="btn btn-outline-primary btn-round" type="submit">
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
                                            <button class="btn btn-outline-primary btn-round">
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
