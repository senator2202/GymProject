<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

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

  <script src="<c:url value="/assets/js/jquery-3.3.1.min.js"/>"></script>
  <script src="/assets/js/plugins/jquery.dataTables.min.js"></script>

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
                  <h4 class="card-title "><fmt:message key="admin_main.newTrainerApplications"/></h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table id="appTable" class="table">
                      <thead class=" text-primary">
                        <th>
                         <fmt:message key="admin_main.id"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.firstName"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.lastName"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.institution"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.graduationYear"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.instagram"/>
                        </th>
                        <th>
                          <fmt:message key="admin_main.applicationDate"/>
                        </th>
                        <th>

                        </th>
                        <th>

                        </th>
                        <th>

                        </th>
                      </thead>
                      <tbody>
                      <c:forEach items="${applications}" var="application">
                        <tr>
                          <td>
                              ${application.id}
                          </td>
                          <td>
                              ${application.firstName}
                          </td>
                          <td>
                              ${application.lastName}
                          </td>
                          <td>
                              ${application.institution}
                          </td>
                          <td>
                              ${application.graduationYear}
                          </td>
                          <td>
                              ${application.instagramLink}
                          </td>
                          <td>
                              ${application.applicationDate}
                          </td>
                          <td class="td-actions text-right">
                            <a href="#" style="alignment: center;">
                              <button type="button" rel="tooltip" class="btn btn-info btn-round" data-toggle="tooltip" title="ABRACADABRA">
                                <i class="material-icons">person</i>
                              </button>
                            </a>
                          </td>
                          <td class="td-actions text-right">
                          <form action="/mainController" method="post">
                              <input type="hidden" name="command" value="approve_trainer_application"/>
                              <input type="hidden" name="appId" value="${application.id}"/>
                              <input type="hidden" name="appInstitution" value="${application.institution}"/>
                              <input type="hidden" name="appGraduation" value="${application.graduationYear}"/>
                              <input type="hidden" name="appInstagram" value="${application.instagramLink}"/>
                              <button type="submit" rel="tooltip" class="btn btn-success btn-round">
                                <i class="material-icons">done</i>
                              </button>
                            </form>
                          </td>
                          <td class="td-actions text-right">
                          <form action="/mainController" method="post">
                              <input type="hidden" name="command" value="refuse_trainer_application"/>
                              <input type="hidden" name="appId" value="${application.id}"/>
                              <button type="submit" rel="tooltip" class="btn btn-danger btn-round">
                                <i class="material-icons">close</i>
                              </button>
                            </form>
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>

                      <ctg:pagination tableId="appTable"/>
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