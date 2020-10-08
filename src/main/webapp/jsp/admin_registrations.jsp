<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.adminLocale}" scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        <fmt:message key="admin.title"/>
    </title>
    <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
    <link rel="stylesheet" href="/assets/css/select-list.css"/>

</head>
<body>
<div class="wrapper ">
    <jsp:include page="/jsp/admin_sidebar.jsp"/>

    <div class="main-panel">
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-primary">
                                <h4 class="card-title "><fmt:message key="admin_registrations"/></h4>
                                <div class="select">
                                    <select name="locale" id="slct" onchange="location=this.value" >
                                        <option selected disabled>
                                            <fmt:message key="admin_registrations.last"/>
                                            ${days}
                                            <c:choose>
                                                <c:when test="${days==1}">
                                                    <fmt:message key="admin_registrations.day"/>
                                                </c:when>
                                                <c:otherwise>
                                                    <fmt:message key="admin_registrations.days"/>
                                                </c:otherwise>
                                            </c:choose>
                                        </option>
                                        <option value="/mainController?command=open_admin_registrations&days=1">
                                            <fmt:message key="admin_registrations.day1"/>
                                        </option>
                                        <option value="/mainController?command=open_admin_registrations&days=7">
                                            <fmt:message key="admin_registrations.day7"/>
                                        </option>
                                        <option value="/mainController?command=open_admin_registrations&days=30">
                                            <fmt:message key="admin_registrations.day30"/>
                                        </option>
                                        <option value="/mainController?command=open_admin_registrations&days=180">
                                            <fmt:message key="admin_registrations.day180"/>
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead class=" text-primary">
                                        <th>
                                            <fmt:message key="admin_registrations.id"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.firstName"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.lastName"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.email"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.registrationDate"/>
                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${recentUsers}" var="user">
                                            <tr>
                                                <td>
                                                        ${user.account.id}
                                                </td>
                                                <td>
                                                        ${user.firstName}
                                                </td>
                                                <td>
                                                        ${user.lastName}
                                                </td>
                                                <td>
                                                        ${user.account.email}
                                                </td>
                                                <td>
                                                        ${user.account.registrationDate}
                                                </td>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>