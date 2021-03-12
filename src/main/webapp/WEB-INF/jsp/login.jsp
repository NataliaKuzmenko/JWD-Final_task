<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Login" var="namePage"/>
    <fmt:message bundle="${locale}" key="label.RegistrationOk" var="registration_message"/>
    <fmt:message bundle="${locale}" key="label.Password" var="password"/>
    <fmt:message bundle="${locale}" key="label.log_in" var="login"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>
    <fmt:message bundle="${locale}" key="label.language" var="changeLanguage"/>

    <title>${namePage}</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
      integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">

<body>
<div class="login">
    <div class="container-sm">
        <div class="row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <br/>
                <c:if test="${param.get('RegistrationOk')}">
                    ${registration_message}
                </c:if>

                <form name="loginForm" method="POST" action="controller">
                    <input type="hidden" name="command" value="login"/>

                    ${namePage}:<br/>
                    <input type="text" name="email" value=""/>
                    <br/>${password}:<br/>
                    <input type="password" name="password" value=""/>
                   <br/>
                    ${errorLoginPassMessage}
                    <br/>
                    <input type="submit" value="${login}"/>
                </form>
                <br/>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="forward"/>
                    <input type="hidden" name="page" value="/WEB-INF/jsp/main.jsp"/>
                    <input type="submit" value="${back}"/>

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
</body>
</html>
