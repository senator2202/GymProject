<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<link rel="stylesheet" href="/assets/css/font-awesome.min.css">

<div class="modal fade" id="popupUserProfile" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title w-100 text-center">
                    <fmt:message key="user_profile.name"/> <label id="nameText" style="color: #0b0b0b"></label>
                </h5>
            </div>
            <div class="modal-body">
                <div class="card" style="margin-top: 0px; margin-bottom: 0px;">
                    <div class="card-header-image">
                        <div class="avatar-upload">
                            <div class="avatar-preview">
                                <div id="imagePreview"></div>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <p>
                            <fmt:message key="user_profile.userType"/> <label id="roleText" style="color: #0b0b0b"></label>
                        </p>
                        <p>
                            <fmt:message key="user_profile.email"/> <label id="emailText" style="color: #0b0b0b"></label>
                        </p>
                        <p>
                            <fmt:message key="user_profile.phone"/> <label id="phoneText" style="color: #0b0b0b"></label>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $('#popupUserProfile').on('show.bs.modal', function (e) {
        var firstName = e.relatedTarget.dataset.firstname;
        var lastName = e.relatedTarget.dataset.lastname;
        var imageName = e.relatedTarget.dataset.imagename;
        var phone = e.relatedTarget.dataset.phone;
        var role = e.relatedTarget.dataset.role;
        var email = e.relatedTarget.dataset.email;
        var modal = $(this);
        modal.find('#imagePreview').css("background-image", "url('" + imageName + "')");
        modal.find('#nameText').text(firstName + ' ' + lastName);
        modal.find('#emailText').text(email);
        modal.find('#phoneText').text(phone);
        modal.find('#roleText').text(role);
    });
</script>

