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

    <fmt:message bundle="${locale}" key="label.Logout" var="logout"/>
    <fmt:message bundle="${locale}" key="label.Profile" var="profile"/>
    <title>${profile}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<h3>${profile}</h3>

<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="${logout}"/>
</form>
<br/>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
