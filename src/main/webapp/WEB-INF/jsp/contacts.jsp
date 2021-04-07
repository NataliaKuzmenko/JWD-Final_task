<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:message bundle="${locale}" key="label.contacts" var="contacts"/>
    <fmt:message bundle="${locale}" key="contacts.1.adress" var="adress_1"/>
    <fmt:message bundle="${locale}" key="contacts.2.adress" var="adress_2"/>
    <fmt:message bundle="${locale}" key="contacts.1.time" var="time_1"/>
    <fmt:message bundle="${locale}" key="contacts.2.time" var="time_2"/>
    <fmt:message bundle="${locale}" key="contacts.3.time" var="time_3"/>
    <fmt:message bundle="${locale}" key="contacts.Address" var="address"/>

    <title>${contacts}</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<br/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-3">
            <h3 class="font-weight-normal" class="text-dark">${address}</h3>
            <p class="font-italic" class="text-dark">${adress_1}</p>
            <p class="font-italic" class="text-dark">${adress_2}</p>
            <p class="font-italic" class="text-dark">${time_1}</p>
            <p class="font-italic" class="text-dark">${time_2}</p>
            <p class="font-italic" class="text-dark">${time_3}</p>
        </div>
        <div class="col-lg-4"></div>
    </div>
            <c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</div>
</body>

