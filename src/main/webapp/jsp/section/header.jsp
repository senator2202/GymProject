<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<header class="header-section">
    <div class="container">
        <div class="logo">
            <a href="/index.jsp">
                <img src="/assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="nav-menu">
            <nav class="mainmenu mobile-menu">
                <ul>
                    <li class="active">
                        <a href="/mainController?command=open_home">
                            <fmt:message key="header.home"/>
                        </a>
                    </li>
                    <li>
                        <a href="/mainController?command=open_schedule" id="scheduleRef">
                            <fmt:message key="header.schedule"/>
                        </a>
                    </li>
                    <li>
                        <a href="/mainController?command=open_contacts">
                            <fmt:message key="header.contacts"/>
                        </a>
                    </li>
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                            <li>
                                <a href="/mainController?command=open_personal_data">
                                    <fmt:message key="header.profile"/>
                                </a>
                                <ul class="dropdown">
                                    <li>
                                        <a href="/mainController?command=logout">
                                            <fmt:message key="header.logout"/>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <button type="button" class="btn btn-outline-light" data-toggle="modal"
                                        data-target="#modalLogin">
                                    <fmt:message key="header.login"/>
                                </button>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>
            <div class="nav-right search-switch">
                <i class="ti-search"></i>
            </div>
        </div>
        <div id="mobile-menu-wrap"></div>
    </div>
</header>
