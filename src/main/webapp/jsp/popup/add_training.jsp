<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

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