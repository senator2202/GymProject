<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- PopUp Add Training Start -->
<form action="/mainController" class="col-lg-10" method="post" name="descriptionForm">
    <input type="hidden" name="command" value="update_training_description"/>
    <input type="hidden" name="trainingId" id="trainingId"/>
    <a href="#x" class="overlay" id="popupDescription"></a>
    <div class="popup">
        <div class="col-lg-6">
            <textarea class="form-control" rows="5" id="trainingDescription"></textarea>
        </div>
        <div class="row">
            <button class="primary-btn" type="submit">
                update
            </button>
        </div>
        <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
    </div>
</form>
<!-- PopUp Add Training End -->