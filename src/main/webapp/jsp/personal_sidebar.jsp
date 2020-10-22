<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

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
            <li class="${activeTab == 'personalDataTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="/mainController?command=open_personal_data" >
                    <p><fmt:message key="personal_profile.personalData"/></p>
                </a>
            </li>
            <li class="nav-item">
            <li class="${activeTab == 'personalAccountTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="/mainController?command=open_personal_account">
                    <p><fmt:message key="personal_profile.accountData"/></p>
                </a>
            </li>
            <c:if test="${sessionScope.user.account.role=='CLIENT'}">
                <li class="${activeTab == 'personalFinanceTab' ? 'nav-item active' : 'nav-item'}">
                    <a class="nav-link" href="/mainController?command=open_personal_finance">
                        <p><fmt:message key="personal_profile.finance"/></p>
                    </a>
                </li>
            </c:if>
            <li class="${activeTab == 'personalPhotoGalleryTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="#">
                    <p><fmt:message key="personal_profile.photoGallery"/></p>
                </a>
            </li>
        </ul>
    </div>
</div>
