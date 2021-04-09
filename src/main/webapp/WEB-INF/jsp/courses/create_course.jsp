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
    <fmt:message bundle="${locale}" key="message.EditProfileError" var="checkData"/>

    <title>${createCourse}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<p></p>
<div class="container">
    <div class="row">
        <c:if test="${param.get('createMessage')}">
            <div class="alert alert-success" role="alert">
                    ${courseCreateMesssage}
            </div>
        </c:if>
        <c:if test="${errorData == true}">
            <div class="alert alert-warning" role="alert">
                    ${checkData}
            </div>
        </c:if>
    </div>
    <p>
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-6">
            <jsp:useBean id="currentDate" class="java.util.Date"/>
            <form action="${request.getContextPath()}/final_task_war_exploded/controller" method="post">
                <input type="hidden" name="command" value="createCourse"/>

                <p class="text-info"> ${courseTitle}:
                    <input type="text" name="title" value=""/><br/></p>
                <p class="text-info">${courseDescription}:
                    <input type="text" name="description" value=""/><br/></p>
        </div>
        <div class="col-lg-4">
            <p class="text-info">${courseStart}:
                <input type="date" class="form-control form-control-sm"
                       id="startDate" name="start" required value=""
                       min="<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd"/>"
                       max="2099-12-31"/></p>
            <p class="text-info">${courseEnd}:
                <input type="date" class="form-control form-control-sm"
                       id="endDate" name="end"
                       value=""
                       required max="2099-12-31"
                       min="<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd"/>"/></p>
            <p class="text-info">${courseFormat}:
                <select name="format">
                    <option>ONLINE</option>
                    <option>OFFLINE</option>
                </select></p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-4">
            <input class="btn btn-outline-secondary" type="submit" value="${createCourse}"/></div>
    </div>
    </form>

</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
