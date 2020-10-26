<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="modal fade" id="modalTrainerApplication" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center">
                    Fill trainer application
                </h5>
            </div>
            <div class="modal-body">
                <div class="card" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="card-body">
                        <form action="/mainController" method="post">
                            <input type="hidden" name="command" value="send_trainer_application">
                            <div class="form-group">
                                <label for="institution"><fmt:message key="trainer_popup.institution"/></label>
                                <input type="text" class="form-control" id="institution" name="institution"  style="background-color: #fff;">
                            </div>
                            <div class="form-group">
                                <label for="graduationYear"><fmt:message key="trainer_popup.year"/></label>
                                <input type="text" class="form-control" id="graduationYear" name="graduationYear"  style="background-color: #fff;">
                            </div>
                            <div class="form-group">
                                <label for="instagramLink"><fmt:message key="trainer_popup.instagram"/></label>
                                <input type="text" class="form-control" id="instagramLink" name="instagramLink"  style="background-color: #fff;">
                            </div>
                            <button type="submit" class="btn btn-primary mb-2"><fmt:message key="trainer_popup.send"/></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<form action="/mainController">
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
</form>--%>
