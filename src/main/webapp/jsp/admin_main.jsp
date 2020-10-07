<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Admin PoniGym
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="../assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
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
                  <h4 class="card-title ">New Trainer Applications</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>
                          ID
                        </th>
                        <th>
                          First Name
                        </th>
                        <th>
                          Last Name
                        </th>
                        <th>
                          Institution
                        </th>
                        <th>
                          Graduation year
                        </th>
                        <th>
                          Instagram Profile
                        </th>
                        <th>
                          Application Date
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
                          <td>
                            <form action="/mainController">
                              <input type="hidden" name="command" value="approve_trainer_application"/>
                              <input type="hidden" name="appId" value="${application.id}"/>
                              <input type="hidden" name="appInstitution" value="${application.institution}"/>
                              <input type="hidden" name="appGraduation" value="${application.graduationYear}"/>
                              <input type="hidden" name="appInstagram" value="${application.instagramLink}"/>
                              <button type="submit">
                                Approve
                              </button>
                            </form>
                          </td>
                          <td>
                            <form action="/mainController">
                              <input type="hidden" name="command" value="refuse_trainer_application"/>
                              <input type="hidden" name="appId" value="${application.id}"/>
                              <button type="submit">
                                Refuse
                              </button>
                            </form>
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