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

    <fmt:message bundle="${locale}" key="label.Profile" var="profile"/>
    <fmt:message bundle="${locale}" key="user.Name" var="firstName"/>
    <fmt:message bundle="${locale}" key="user.Surname" var="lastName"/>
    <fmt:message bundle="${locale}" key="user.Email" var="email"/>
    <fmt:message bundle="${locale}" key="button.Save" var="save"/>
    <fmt:message bundle="${locale}" key="error.UploadPhoto" var="errorUploadPhoto"/>
    <fmt:message bundle="${locale}" key="message.UploadPhoto" var="uploadPhoto"/>

    <title>${profile}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<br/>
<form name="loginForm" method="POST" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="editProfileCommand"/>

    <br/> ${firstName}:<br/>
    <input type="text" name="first_name" value=""/>
    <br/>${lastName}:<br/>
    <input type="password" name="last_name" value=""/>
    <br/>${email}:<br/>
    <input type="password" name="email" value=""/>

    <br/>
    <c:if test="${errorLoginPassMessage == true}">
        ${errorLogin}
    </c:if>
    <br/>
    <input type="submit" value="${save}"/>
</form>
<br/>
<div class="upload text-info">
    select file
    <br/>
    <form action="${pageContext.request.contextPath}/upload?avatar=user"
          enctype="multipart/form-data" method="post">
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="content" id="validatedCustomFile"
                   required>
            <label class="custom-file-label" for="validatedCustomFile">choose photo</label>
        </div>
        <br/>
        <c:if test="${uploadResult == false}">
            ${errorUploadPhoto}
        </c:if>
        <br/>
        <c:if test="${uploadResult == true}">
            ${uploadPhoto}
        </c:if>
        <br/>
        ${error}
        <div class="button-save">
            <button class="btn btn-outline-primary " type="submit">${save}</button>
        </div>
    </form>
</div>
</body>
</html>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
