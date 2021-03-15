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

    <fmt:message bundle="${locale}" key="label.Index" var="namePage"/>
    <fmt:message bundle="${locale}" key="label.Login" var="login"/>
    <fmt:message bundle="${locale}" key="label.CreateAnAccount" var="CreateAnAccount"/>

    <title>${namePage} </title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<hr/>
<br/>
Курсы английского языка.
<br/>
Современные методики изучения.
<br/>
Комплексное и интенсивное изучение языков, бизнес-курсы, курсы выходного дня,
<br/>
подготовка к международным экзаменам,
<br/>
поддержание высокого уровня владения иностранным языком.
<br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="forward"/>
    <input type="hidden" name="page" value="/WEB-INF/jsp/login.jsp"/>
    <input type="submit" value="${login}"/><br/>
</form>
<hr/>
<form method="post" action="controller">
    <input type="hidden" name="command" value="forward"/>
    <input type="hidden" name="page" value="/WEB-INF/jsp/registration.jsp"/>
    <input type="submit" value="${CreateAnAccount}"/>
</form>
<br/>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
