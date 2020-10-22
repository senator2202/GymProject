<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- Header Section Begin -->
<header class="header-section header-normal">
    <div class="nav-menu">
        <nav class="mainmenu mobile-menu">
            <ul>
                <li class="active"><a href="/mainController?command=open_home">Home</a></li>
                <li><a href="/mainController?command=open_about">About</a></li>
                <li><a href="/mainController?command=open_schedule">Schedule</a></li>
                <li><a href="/mainController?command=open_portfolio">Portfolio</a></li>
                <li><a href="/mainController?command=open_contacts">Contacts</a></li>
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <li>
                            <a href="/mainController?command=open_personal_data">Personal profile</a>
                            <ul class="dropdown">
                                <li><a href="/mainController?command=logout">Log Out</a>
                                </li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <button type="button" class="primary-btn" data-toggle="modal" data-target="#popupLogin">Login</button>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
        <div class="nav-right search-switch">
            <i class="ti-search"></i>
        </div>
    </div>
</header>
<!-- Header End -->