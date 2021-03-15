<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Welcome" var="welcome"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>
    <fmt:message bundle="${locale}" key="label.Logout" var="logout"/>
    <fmt:message bundle="${locale}" key="label.Profile" var="profile"/>

    <title>${welcome}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<h3>${welcome}</h3>
<hr/>
${email}
<form action="controller" method="post">
    <input type="hidden" name="command" value="forward"/>
    <input type="hidden" name="page" value="/WEB-INF/jsp/profile.jsp"/>
    <input type="submit" value="${profile}"/>
</form>
<hr/>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
        <input type="submit" value="${logout}"/>
</form>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
