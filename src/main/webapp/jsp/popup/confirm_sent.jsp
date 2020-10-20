<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<a href="#x" class="overlay" id="popupConfirmSent"></a>
<div class="popup ">
	<label class="label" style="font-size: large"><fmt:message key="confirm_sent.message"/> ${user.account.email}</label>
	<a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>