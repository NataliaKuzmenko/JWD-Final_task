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

    <title>${contacts}</title>
</head>
<c:import url="/jsp/common/header.jsp"/>
<body>
<br/>
пр. Независимости, 95
<br/>
1ый этаж, пом.7
<br/>
г. Минск
<br/>
Время работы:
<br/>
пн-пт: 9.00-19.00
<br/>
сб-вс: 10.00-17.00
<br/>
</body>
<c:import url="/jsp/common/footer.jsp"/>
