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
    <fmt:message bundle="${locale}" key="message.UserIsNotExist" var="userNotExist"/>


    <title>${namePage}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<br/>
<div class="container">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-3">
            <form name="loginForm" method="post"
                  action="${request.getContextPath()}/final_task_war/controller">
                <input type="hidden" name="command" value="login"/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">${namePage}</span>
                    </div>
                    <input type="email" name="email" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""/>
                </div>
                <br/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="password">${password}</span>
                    </div>
                    <input type="password" name="password" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""/>
                </div>
                <br/>
                <c:if test="${errorLoginPassMessage == true}">
                    <div class="alert alert-warning" role="alert">
                            ${errorLogin}
                    </div>
                </c:if>
                <c:if test="${userIsNotExist == true}">
                    <div class="alert alert-warning" role="alert">
                            ${userNotExist}
                    </div>
                </c:if>
                <br/>
                <input class="btn btn-outline-primary" type="submit" value="${login}"/>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>
</div>
</body>
<br/><br/><br/>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
