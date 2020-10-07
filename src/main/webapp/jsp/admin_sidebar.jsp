<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<div class="sidebar" data-color="purple" data-background-color="white">
    <div class="logo"><a href="http://www.creative-tim.com" class="simple-text logo-normal">
        Admin
    </a></div>
    <div class="sidebar-wrapper">
        <ul class="nav">
            <li class="nav-item  ">
                <a class="nav-link" href="#">
                    <p>Nearby Trainings</p>
                </a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/mainController?command=open_admin_registrations">
                    <p>Recent Registrations</p>
                </a>
            </li>
            <li class="nav-item active ">
                <a class="nav-link" href="/mainController?command=open_admin_main">
                    <p>Trainer Applications</p>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/mainController?command=logout">
                    <p>Log Out</p>
                </a>
            </li>
        </ul>
    </div>
</div>