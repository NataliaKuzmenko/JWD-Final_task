<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Index" var="namePage"/>
    <fmt:message bundle="${locale}" key="label.Title" var="title"/>
    <fmt:message bundle="${locale}" key="label.Login" var="login"/>
    <fmt:message bundle="${locale}" key="label.Registration" var="registration"/>
    <fmt:message bundle="${locale}" key="label.language" var="changeLanguage"/>

    <title>${namePage} </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="main">
    <div class="container-sm">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <div class="jumbotron">
                    <h1>${title}</h1>
                </div>
                <hr/>
                <br/>
                <div class="row">
                    <div class="col-1">
                    </div>
                    <div class="col-4">
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/WEB-INF/jsp/login.jsp"/>
                            <input type="submit" value="${login}"/><br/>
                        </form>
                        <hr/>

                        <form method="post" action="controller">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/WEB-INF/jsp/registration.jsp"/>
                            <input type="submit" value="${registration}"/>
                        </form>
                        <br/>
                        <form method="post" action="controller">
                            <input type="hidden" name="command" value="language"/>
                            <input type="submit" value="${changeLanguage}">
                        </form>
                    </div>
                    <div class="col-sm-4"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>
