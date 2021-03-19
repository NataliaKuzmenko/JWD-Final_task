<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Main" var="namePage"/>
    <fmt:message bundle="${locale}" key="main.1.Description" var="main_1_Description"/>
    <fmt:message bundle="${locale}" key="main.2.Description" var="main_2_Description"/>
    <fmt:message bundle="${locale}" key="main.3.Description" var="main_3_Description"/>
    <fmt:message bundle="${locale}" key="main.4.Description" var="main_4_Description"/>
    <fmt:message bundle="${locale}" key="main.5.Description" var="main_5_Description"/>


    <title>${namePage} </title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<c:import url="/jsp/common/header.jsp"/>
<body>
<div class="main">
<div class="container">
<hr/>
<br/>
    <c:out value="${main_1_Description}"/>
    <br/>
    <c:out value="${main_2_Description}"/>
    <br/>
    <c:out value="${main_3_Description}"/>
    <br/>
    <c:out value="${main_4_Description}"/>
    <br/>
    <c:out value="${main_5_Description}"/>


<br/>
</div>
</div>
</body>
<c:import url="/jsp/common/footer.jsp"/>

</html>
