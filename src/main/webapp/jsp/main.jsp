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


    <title>${namePage} </title>
</head>
<c:import url="/jsp/common/header.jsp"/>
<body>
<div class="container"></div>
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

<br/>

</body>
<c:import url="/jsp/common/footer.jsp"/>
</html>
