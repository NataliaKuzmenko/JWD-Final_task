<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>

<fmt:message bundle="${locale}" key="label.Header" var="namePage"/>
<html>
<head>
    <title>${namePage}</title>
</head>
<body>
<form method="post" action="controller">
    <input type="hidden" name="command" value="language"/>
    <input type="submit" value="${changeLanguage}">
</form>
</body>
</html>
