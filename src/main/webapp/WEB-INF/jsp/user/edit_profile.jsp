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
    <fmt:message bundle="${locale}" key="user.ChangePhoto" var="changePhoto"/>
    <fmt:message bundle="${locale}" key="user.ChoosePhoto" var="choosePhoto"/>
    <fmt:message bundle="${locale}" key="message.EditProfile" var="editProfile"/>
    <fmt:message bundle="${locale}" key="message.EditProfileError" var="checkData"/>
    <fmt:message bundle="${locale}" key="message.EmailExist" var="emailExist"/>


    <title>${profile}</title>
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<c:if test="${errorData == true}">
    <div class="alert alert-warning" role="alert">
            ${checkData}
    </div>
</c:if>
<c:if test="${userExist == true}">
    <div class="alert alert-warning" role="alert">
            ${emailExist}
    </div>
</c:if>

<c:if test="${editProfileResult == true}">
    <div class="alert alert-success" role="alert">
            ${editProfile}
    </div>
</c:if>
<br/>
<form method="POST" action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="editProfileCommand"/>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text" id="">${firstName} ${lastName}</span>
        </div>
        <input type="text" class="form-control" name="first_name">
        <input type="text" class="form-control" name="last_name">
    </div>
    <br/>
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="inputGroup-sizing-default">${email}</span>
        </div>
        <input type="email" name="email" class="form-control" aria-label="Default"
               aria-describedby="inputGroup-sizing-default">
    </div>
    <br/>
    <input class="btn btn-outline-primary " type="submit" value="${save}"/>
</form>
<br/>
<div class="upload text-info">
    ${changePhoto}
    <br/>
    <form action="${pageContext.request.contextPath}/upload?avatar=user"
          enctype="multipart/form-data" method="post">
        <div class="custom-file">
            <input type="file" class="custom-file-input" name="content" id="validatedCustomFile"
                   required>
            <label class="custom-file-label" for="validatedCustomFile">${choosePhoto}</label>
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
