<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.language" var="changeLanguage"/>
    <title>Index</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<h3>Profile</h3>
${user_id}
<br/>
${email}
<br/>
${first_name}
<br/>
${last_name}
<br/>
${photo_path}
<br/>
<form action="controller" method="post">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Logout"/>

</form>
<br/>
<form method="post" action="controller">
    <input type="hidden" name="command" value="language"/>
    <input type="submit" value="${changeLanguage}">
</form>
</body>
</html>
