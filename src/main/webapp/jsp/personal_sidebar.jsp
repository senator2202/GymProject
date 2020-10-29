<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<jsp:include page="/jsp/modal/trainer_application.jsp"/>

<div class="sidebar" data-color="purple" data-background-color="white">
    <div class="logo">
        <a class="simple-text logo-normal">
            ${user.firstName} ${user.lastName}
        </a>
    </div>
    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="nav-item">
                <form action="/uploadController" enctype="multipart/form-data" method="post" id="uploadForm">
                    <div class="container">
                        <div class="avatar-upload">
                            <div class="avatar-edit">
                                <input type='file' id="imageUpload" name="content" accept=".png, .jpg, .jpeg" onchange="document.getElementById('uploadForm').submit()" />
                                <label for="imageUpload"></label>
                            </div>
                            <div class="avatar-preview">
                                <div id="imagePreview" style="background-image: url('${user.imageName==null ? '/assets/img/img-upload.jpg' : user.imageName}');">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </li>
            <li class="nav-item">
                <form action="/mainController">
                    <input type="hidden" name="command" value="open_personal_data">
                    <button type="submit"
                            class="${activeTab=='personalDataTab' ? 'btn btn-primary btn-round' : 'btn btn-outline-primary btn-round'}"
                            style="width: 220px">
                        <fmt:message key="personal_profile.personalData"/>
                    </button>
                </form>
            </li>
            <li class="nav-item">
                <form action="/mainController">
                    <input type="hidden" name="command" value="open_personal_account">
                    <button type="submit"
                            class="${activeTab=='personalAccountTab' ? 'btn btn-primary btn-round' : 'btn btn-outline-primary btn-round'}"
                            style="width: 220px">
                        <fmt:message key="personal_profile.accountData"/>
                    </button>
                </form>
            </li>
            <c:if test="${sessionScope.user.account.role=='CLIENT'}">
                <li class="nav-item">
                    <form action="/mainController">
                        <input type="hidden" name="command" value="open_personal_finance">
                        <button type="submit"
                                class="${activeTab=='personalFinanceTab' ? 'btn btn-primary btn-round' : 'btn btn-outline-primary btn-round'}"
                                style="width: 220px">
                            <fmt:message key="personal_profile.finance"/>
                        </button>
                    </form>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-outline-primary btn-round"
                            data-toggle="modal" data-target="#modalTrainerApplication">
                           <fmt:message key="personal_profile.becomeTrainer"/>
                    </button>
                </li>
            </c:if>
        </ul>
    </div>
</div>
