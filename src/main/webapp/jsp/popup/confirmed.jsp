<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<a href="#x" class="overlay" id="popupConfirmed"></a>
<div class="popup">
	<label class="label" style="font-size: large">${confirmedAccount}: <fmt:message key="confirmed.message"/></label>
	<a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
</div>