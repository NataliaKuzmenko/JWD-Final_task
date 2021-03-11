<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
    <style>
        <%@include file="/css/style.css" %>
    </style>
</head>
<body>
<div class="registration">
    <div class="container-sm">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                ${nullData}

                ${registrationErrorPasswords}
                ${registrationErrorSymbols}
                ${registrationError}
                <br/>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="registration"/>

                    Enter email:<br/>
                    <input type="email" name="email" value=""/><br/>

                    Enter password:<br/>
                    <input type="text" name="password" value=""/><br/>

                    Enter repeat password:<br/>
                    <input type="text" name="repeat password" value=""/><br/>


                    <br/>
                    ${error}

                    <input type="submit" value="Create an account"/><br/>
                </form>
                <br/>
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="gotoindexpage"/>

                    <input type="submit" value="Back"/>
                </form>
            </div>
            <div class="col-sm-4"></div>
        </div>
    </div>
</div>
</body>
</html>
