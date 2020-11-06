<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="popupDeposit" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-body">
                <form class="credit-card" action="/mainController" method="post">
                    <input type="hidden" name="command" value="make_deposit">
                    <div class="form-header">
                        <h4 class="title"><fmt:message key="deposit.title"/></h4>
                    </div>
                    <div class="form-body">
                        <input type="text" class="card-number" placeholder="Card Number" required pattern="\d{16}">
                        <div class="date-field">
                            <div class="month">
                                <select name="Month">
                                    <option value="january"><fmt:message key="deposit.january"/></option>
                                    <option value="february"><fmt:message key="deposit.february"/></option>
                                    <option value="march"><fmt:message key="deposit.march"/></option>
                                    <option value="april"><fmt:message key="deposit.april"/></option>
                                    <option value="may"><fmt:message key="deposit.may"/></option>
                                    <option value="june"><fmt:message key="deposit.june"/></option>
                                    <option value="july"><fmt:message key="deposit.july"/></option>
                                    <option value="august"><fmt:message key="deposit.august"/></option>
                                    <option value="september"><fmt:message key="deposit.september"/></option>
                                    <option value="october"><fmt:message key="deposit.october"/></option>
                                    <option value="november"><fmt:message key="deposit.november"/></option>
                                    <option value="december"><fmt:message key="deposit.december"/></option>
                                </select>
                            </div>
                            <div class="year">
                                <select name="Year">
                                    <option value="2020">2020</option>
                                    <option value="2021">2021</option>
                                    <option value="2022">2022</option>
                                    <option value="2023">2023</option>
                                    <option value="2024">2024</option>
                                </select>
                            </div>
                        </div>
                        <div class="card-verification">
                            <div class="cvv-input">
                                <input type="text" placeholder="CVV" required pattern="\d{3}">
                            </div>
                        </div>
                        <div class="card-verification">
                            <div class="cvv-input">
                                <input type="text" name="amount" placeholder="Br" required pattern="\d+">
                            </div>
                        </div>
                        <p>
                            <button type="submit" class="proceed-btn"><fmt:message key="deposit.procceed"/></button>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
