<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.user.account.locale.postfix}"
               scope="session"/>
<fmt:setBundle basename="property/pagecontent"/>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="PONIGYM Template">
    <meta name="keywords" content="PONIGYM, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PONIGYM | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Oswald:300,400,500,600,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/assets/css/login.css"/>
    <link rel="stylesheet" href="/assets/css/magnific-popup.css"/>
    <link rel="stylesheet" href="/assets/css/owl.carousel.min.css"/>
    <link rel="stylesheet" href="/assets/css/slicknav.min.css"/>
    <link rel="stylesheet" href="/assets/css/style.css"/>
    <link rel="stylesheet" href="/assets/css/themify-icons.css"/>
    <link rel="stylesheet" href="/assets/css/select-list.css"/>
    <link rel="stylesheet" href="/assets/css/popup.css"/>
    <link href="/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">

    <script src="/assets/js/jquery-3.3.1.min.js"></script>
    <script src="/assets/js/plugins/jquery.dataTables.min.js"></script>
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <jsp:include page="/jsp/part/header_black.jsp"/>

    <c:choose>
        <c:when test="${user.account.role=='CLIENT'}">
            <jsp:include page="schedule_client.jsp"/>
        </c:when>
        <c:when test="${user.account.role=='TRAINER'}">
            <jsp:include page="schedule_trainer.jsp"/>
        </c:when>
    </c:choose>

    <jsp:include page="/jsp/part/footer.jsp"/>

    <!-- Js Plugins -->

    <%--<script>
        $(document).ready(function () {
            $('#clientTrainings').DataTable({
                "scrollX": false
            });
            $('.dataTables_length').addClass('bs-select');
        });
    </script>--%>
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/jquery.magnific-popup.min.js"></script>
    <script src="/assets/js/mixitup.min.js"></script>
    <script src="/assets/js/jquery.slicknav.js"></script>
    <script src="/assets/js/owl.carousel.min.js"></script>
    <script src="/assets/js/main.js"></script>
</body>

</html>