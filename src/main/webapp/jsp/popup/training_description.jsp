
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<a href="#x" class="overlay" id="popupDescription"></a>
<div class="popup">
    <form action="/mainController" class="col-lg-10" method="post" id="descriptionForm" accept-charset="UTF-8">
        <input type="hidden" name="command" value="update_training_description"/>
        <input type="text" name="trainingId" id="trainingId" value=""/>
        <div class="row">
            <textarea class="form-control" rows="5" id="trainingDescription" name="trainingDescription"></textarea>
        </div>
        <div class="row">
            <button class="primary-btn" type="submit">
                add
            </button>
        </div>
    </form>
    <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>

