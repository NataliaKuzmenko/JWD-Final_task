<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
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
</body>
</html>
