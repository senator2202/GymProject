<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!--popup window start-->
<form action="/mainController">
    <input type="hidden" name="command" value="send_trainer_application"/>
    <a href="#x" class="overlay" id="popupApplication"></a>
    <div class="popup">
        <div class="col-lg-6">
            <label for="institution">
                <fmt:message key="trainer_popup.institution"/>
            </label>
            <input type="text" id="institution" name="institution"/>
        </div>
        <div class="col-lg-6">
            <label for="graduationYear">
                <fmt:message key="trainer_popup.year"/>
            </label>
            <input type="text" id="graduationYear" name="graduationYear"/>
        </div>
        <div class="col-lg-6">
            <label for="instagramLink">
                <fmt:message key="trainer_popup.instagram"/>
            </label>
            <input type="text" id="instagramLink" name="instagramLink"/>
        </div>
        <button type="submit">
            <fmt:message key="trainer_popup.send"/>
            <i class="ti-angle-double-right"></i>
        </button>
        <a class="close" title=<fmt:message key="trainer_popup.close"/> href="#close"></a>
    </div>
</form>
<!--popup window end-->