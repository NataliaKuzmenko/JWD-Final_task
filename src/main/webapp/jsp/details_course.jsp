<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:message bundle="${locale}" key="label.Courses" var="courses"/>
    <fmt:message bundle="${locale}" key="course.Programs" var="programs"/>

    <title>${courses}</title>
</head>
<c:import url="/jsp/common/header.jsp"/>
<body>

${courseTitle}
${description}

</body>
</html>
