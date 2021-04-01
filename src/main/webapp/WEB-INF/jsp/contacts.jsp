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

    <title>${contacts}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<br/>${adress_1}
<br/>${adress_2}
<br/>${time_1}
<br/>${time_2}
<br/>${time_3}

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
