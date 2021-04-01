<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="registration.ErrorPasswords" var="errorPassword"/>
    <fmt:message bundle="${locale}" key="registration.Error" var="registration_error"/>
    <fmt:message bundle="${locale}" key="registration.ErrorSymbols" var="errorSymbols"/>
    <fmt:message bundle="${locale}" key="label.EnterEmail" var="enterEmail"/>
    <fmt:message bundle="${locale}" key="label.EnterPassword" var="enterPassword"/>
    <fmt:message bundle="${locale}" key="label.Registration" var="registration"/>
    <fmt:message bundle="${locale}" key="label.RepeatPassword" var="repeatPassword"/>
    <fmt:message bundle="${locale}" key="label.CreateAnAccount" var="createAnAccount"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>

    <title>${registration}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<c:if test="${registrationErrorPasswords == true}">
    ${errorPassword}
</c:if>

<c:if test="${registrationErrorSymbols == true}">
    ${errorSymbols}
</c:if>

<c:if test="${registrationError == true}">
    ${registration_error}
</c:if>
<br/>

<form action="${request.getContextPath()}/final_task_war_exploded/controller" method="post">
    <input type="hidden" name="command" value="registration"/>

    ${enterEmail}:<br/>
    <input type="email" name="email" value=""/><br/>

    ${enterPassword}:<br/>
    <input type="password" name="password" value=""/><br/>

    ${repeatPassword}:<br/>
    <input type="password" name="repeat password" value=""/><br/>

    <br/>
    ${error}

    <input type="submit" value="${createAnAccount}"/><br/>
</form>

<div class="col-sm-4"></div>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
