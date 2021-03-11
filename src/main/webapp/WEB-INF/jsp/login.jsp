<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setLocale value="en" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Index" var="namePage"/>
    <title>Login</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">

<body>
<div class="login">
    <div class="container-sm">
        <div class="row">
            <div class="col-sm-4"></div>

    <div class = "col-sm-4">
        <br/>
        ${messageRegistration}
        ${nullPage}


<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login" />

    Login:<br/>
    <input type="text" name="email" value=""/>
    <br/>Password:<br/>
    <input type="password" name="password" value=""/>
    <br/>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>
    ${nullPage}

    <input type="submit" value="Log in"/>
</form>
        <br />
        <form action="controller" method="post">
            <input type="hidden" name="command" value="gotoindexpage" />

            <input type="submit" value="Back" />
        </form>
    </div>
            <div class="col-sm-4"></div>
</div>
    </div>
</div>
</body>
</html>
