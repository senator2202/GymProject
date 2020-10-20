<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!-- Header Section Begin -->
<header class="header-section header-normal">
    <div class="container">
        <div class="nav-menu">
            <nav class="mainmenu mobile-menu">
                <ul>
                    <li class="active"><a href="/index.jsp">Home</a></li>
                    <li><a href="/jsp/about-us.jsp">About</a></li>
                    <li><a href="/mainController?command=open_schedule">Schedule</a></li>
                    <li><a href="/jsp/gallery.jsp">Portfolio</a></li>
                    <li><a href="/jsp/contact.jsp">Contacts</a></li>
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
                                </button>
                                <a href="#popupLogin">
                                    Log in
                                </a>
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
<!-- Header End -->