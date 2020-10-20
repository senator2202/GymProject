<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<div class="sidebar" data-color="purple" data-background-color="white">
    <div class="logo">
        <a class="simple-text logo-normal">
            <fmt:message key="personal_profile.personalProfile"/>
        </a>
    </div>
    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="${activeTab == 'personalDataTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="/mainController?command=open_personal_data" >
                    <p><fmt:message key="personal_profile.personalData"/></p>
                </a>
            </li>
            <li class="nav-item">
            <li class="${activeTab == 'personalAccountTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="/mainController?command=open_account_data">
                    <p><fmt:message key="personal_profile.accountData"/></p>
                </a>
            </li>
            <li class="${activeTab == 'personalFinanceTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="/mainController?command=open_personal_finance">
                    <p><fmt:message key="personal_profile.finance"/></p>
                </a>
            </li>
            <li class="${activeTab == 'personalPhotoGalleryTab' ? 'nav-item active' : 'nav-item'}">
                <a class="nav-link" href="#">
                    <p><fmt:message key="personal_profile.photoGallery"/></p>
                </a>
            </li>
        </ul>
    </div>
</div>