<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">

</head>
<body>
<div class="welcome">
    <div class="container-sm">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h3>Welcome</h3>
                <c:out value="Login successful!"/>
                <hr/>
                ${user}, hello!
                <hr/>
                <a href="controller?command=logout">Logout</a>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </div>
</div>
</body>
</html>
