<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:message bundle="${locale}" key="course.Create" var="createCourse"/>

    <fmt:message bundle="${locale}" key="course.Title" var="courseTitle"/>
    <fmt:message bundle="${locale}" key="course.Description" var="courseDescription"/>
    <fmt:message bundle="${locale}" key="course.LimitStudents" var="courseLimitStudents"/>
    <fmt:message bundle="${locale}" key="course.Start" var="courseStart"/>
    <fmt:message bundle="${locale}" key="course.End" var="courseEnd"/>
    <fmt:message bundle="${locale}" key="course.Format" var="courseFormat"/>
    <fmt:message bundle="${locale}" key="course.CreateMessage" var="courseCreateMesssage"/>

    <title>${createCourse}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<form action="${request.getContextPath()}/final_task_war_exploded/controller" method="post">
    <input type="hidden" name="command" value="createCourse"/>
    <input type="hidden" name="lecturerId" value="user_id"/>
    <input type="hidden" name="statusCourse" value="NOT_STARTED"/>

    ${courseTitle}:<br/>
    <input type="text" name="title" value=""/><br/>
    ${courseDescription}:<br/>
    <input type="text" name="description" value=""/><br/>
    ${courseLimitStudents}:<br/>
    <input type="text" name="limitStudents" value=""/><br/>
    ${courseStart}:<br/>
    <input type="text" name="start" value=""/><br/>
    ${courseEnd}:<br/>
    <input type="text" name="end" value=""/><br/>
    ${courseFormat}:<br/>
    <input type="text" name="format" value=""/><br/>
    <input class="btn btn-outline-secondary" type="submit" value="${createCourse}"/>
</form>
<br/>
<c:if test="${createMessage == true}">
    ${courseCreateMesssage}
</c:if>


</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
