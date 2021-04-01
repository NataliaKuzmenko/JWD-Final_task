<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Login" var="namePage"/>
    <fmt:message bundle="${locale}" key="label.RegistrationOk" var="registration_message"/>
    <fmt:message bundle="${locale}" key="label.Password" var="password"/>
    <fmt:message bundle="${locale}" key="label.log_in" var="login"/>
    <fmt:message bundle="${locale}" key="error.login" var="errorLogin"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>

    <title>${namePage}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<br/>
<form name="loginForm" method="post" action="${request.getContextPath()}/final_task_war_exploded/controller">
    <input type="hidden" name="command" value="login"/>

    ${namePage}:<br/>
    <input type="email" name="email" value=""/>
    <br/>${password}:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    <c:if test="${errorLoginPassMessage == true}">
        ${errorLogin}
    </c:if>
    <br/>
     <input type="submit" value="${login}"/>
</form>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
