<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
                    <li class="active"><a href="/index.jsp">Home</a></li>
                    <li><a href="/jsp/about-us.jsp">About</a></li>
                    <li><a href="/jsp/schedule.jsp">Schedule</a></li>
                    <li><a href="/jsp/gallery.jsp">Portfolio</a></li>
                    <li><a href="/jsp/blog.jsp">Blog</a>
                        <ul class="dropdown">
                            <li><a href="/jsp/blog-details.jsp">Blog Details</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="/jsp/contact.jsp">Contacts</a></li>
                    <li><a href="/mainController?command=open_admin_main">Admin</a></li>
                    <li>
                        <a href="${(sessionScope.user!=null) ? '/mainController?command=logout"' : '/mainController?command=open_page&page=login"'}"
                           class="primary-btn">
                            ${(sessionScope.user!=null) ? 'Log Out' : 'Log In'}
                        </a>
                    </li>
                </ul>
            </nav>
            <div class="nav-right search-switch">
                <i class="ti-search"></i>
            </div>
        </div>
        <div id="mobile-menu-wrap"></div>
    </div>
</header>