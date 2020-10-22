<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<a href="#x" class="overlay" id="popupAddError"></a>
<div class="popup">
    <label class="label" style="font-size: large"><fmt:message key="add_training_error.message"/></label>
    <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#"></a>
</div>