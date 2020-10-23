<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}" scope="session"/>
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
    <link href="../assets/css/img-upload.css" rel="stylesheet" />

    <script src="/assets/js/jquery-3.3.1.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/plugins/jquery.dataTables.min.js"></script>
    <script src="/assets/js/img-upload.js"></script>
</head>
<body>
<jsp:include page="popup/user_profile.jsp"/>

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
                                    <table class="table" id="regTable">
                                        <thead class=" text-primary">
                                        <th>
                                            <fmt:message key="admin_registrations.id"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.login"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.firstName"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.lastName"/>
                                        </th>
                                        <th data-visible="false">

                                        </th>
                                        <th data-visible="false">
                                            <fmt:message key="admin_registrations.email"/>
                                        </th>
                                        <th data-visible="false">
                                            <fmt:message key="admin_registrations.phone"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.registrationDate"/>
                                        </th>
                                        <th>
                                            <fmt:message key="admin_registrations.status"/>
                                        </th>
                                        <th>

                                        </th>
                                        <th>

                                        </th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${recentUsers}" var="user">
                                            <tr>
                                                <td>
                                                        ${user.account.id}
                                                </td>
                                                <td>
                                                        ${user.account.name}
                                                </td>
                                                <td>
                                                        ${user.firstName}
                                                </td>
                                                <td>
                                                        ${user.lastName}
                                                </td>
                                                <td>
                                                        ${user.account.role}
                                                </td>
                                                <td>
                                                        ${user.account.email}
                                                </td>
                                                <td>
                                                        ${user.phoneNumber}
                                                </td>
                                                <td>
                                                        ${user.account.registrationDate}
                                                </td>
                                                <td>
                                                    <c:if test="${user.account.isActive==true}">
                                                        <fmt:message key="admin_registrations.active"/>
                                                    </c:if>
                                                    <c:if test="${user.account.isActive==false}">
                                                        <fmt:message key="admin_registrations.blocked"/>
                                                    </c:if>
                                                </td>
                                                <td class="td-actions text-right">
                                                    <button type="button" class="btn btn-info btn-round" data-toggle="modal" data-target="#popupUserProfile"
                                                            data-lastname="${user.lastName}"
                                                            data-firstname="${user.firstName}"
                                                            data-imagename="${user.imageName}"
                                                            data-email="${user.account.email}"
                                                            data-phone="${user.phoneNumber}"
                                                            data-role="${user.account.role}">
                                                        <i class="material-icons">person</i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <c:if test="${user.account.isActive==true}">
                                                        <form action="/mainController" method="post">
                                                            <input type="hidden" name="command" value="block_user"/>
                                                            <input type="hidden" name="userId" value="${user.account.id}"/>
                                                            <button type="submit" rel="tooltip" class="btn btn-danger btn-round">
                                                                <i class="material-icons">delete</i>
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                    <c:if test="${user.account.isActive==false}">
                                                        <form action="/mainController" method="post">
                                                            <input type="hidden" name="command" value="unblock_user"/>
                                                            <input type="hidden" name="userId" value="${user.account.id}"/>
                                                            <button type="submit" rel="tooltip" class="btn btn-success btn-round">
                                                                <i class="material-icons">add</i>
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ctg:pagination tableId="regTable"/>
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