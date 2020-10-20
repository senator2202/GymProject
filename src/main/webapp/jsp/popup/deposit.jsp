<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<a href="#x" class="overlay" id="popupDeposit"></a>
<div class="popup ">


    <form class="credit-card" action="/mainController" method="post">
        <input type="hidden" name="command" value="make_deposit">
        <div class="form-header">
            <h4 class="title">Credit card detail</h4>
        </div>

        <div class="form-body">
            <!-- Card Number -->
            <input type="text" class="card-number" placeholder="Card Number" required pattern="\d{16}">

            <!-- Date Field -->
            <div class="date-field">
                <div class="month">
                    <select name="Month">
                        <option value="january">January</option>
                        <option value="february">February</option>
                        <option value="march">March</option>
                        <option value="april">April</option>
                        <option value="may">May</option>
                        <option value="june">June</option>
                        <option value="july">July</option>
                        <option value="august">August</option>
                        <option value="september">September</option>
                        <option value="october">October</option>
                        <option value="november">November</option>
                        <option value="december">December</option>
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

            <!-- Card Verification Field -->
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

            <p><button type="submit" class="proceed-btn"><a href="#">Proceed</a></button></p>
        </div>
    </form>


    <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>