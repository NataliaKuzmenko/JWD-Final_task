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
    <fmt:message bundle="${locale}" key="label.PlaceholderPassword" var="PlaceholderPassword"/>
    <fmt:message bundle="${locale}" key="label.PlaceholderRepeatPassword" var="PlaceholderRepeatPassword"/>
    <fmt:message bundle="${locale}" key="label.PlaceholderEmail" var="PlaceholderEmail"/>

    <title>${registration}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<c:if test="${registrationErrorPasswords == true}">
    <div class="alert alert-warning" role="alert">
            ${errorPassword}</div>
</c:if>

<c:if test="${registrationErrorSymbols == true}">
    <div class="alert alert-warning" role="alert">
            ${errorSymbols}</div>
</c:if>

<c:if test="${registrationError == true}">
    <div class="alert alert-warning" role="alert">
            ${registration_error}</div>
</c:if>
<br/>
<div class="container">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="${request.getContextPath()}/final_task_war/controller" method="post">
                <input type="hidden" name="command" value="registration"/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">${enterEmail}</span>
                    </div>
                    <input type="email" name="email" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""
                           pattern="^[\w-\.]+@([\w-]+\.)+[\w]{2,4}$"
                           placeholder="${PlaceholderEmail}"
                           required/>
                </div>
                <br/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="password">${enterPassword}</span>
                    </div>
                    <input type="password" name="password" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""
                           pattern="^(?=.*[0-9])(?=.*[a-zа-я])(?=.*[A-ZА_Я]).{6,20}$"
                           placeholder="${PlaceholderPassword}" required/>
                </div>
                <br/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="repeatPassword">${repeatPassword}</span>
                    </div>
                    <input type="password" name="repeat password" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""
                           pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$"
                           placeholder="${PlaceholderRepeatPassword}"
                           required/>
                </div>
                <br/>
                <input class="btn btn-outline-primary" type="submit" value="${createAnAccount}"/><br/>
            </form>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
