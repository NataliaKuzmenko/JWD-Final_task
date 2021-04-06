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
    <fmt:message bundle="${locale}" key="course.Register" var="register"/>

    <fmt:message bundle="${locale}" key="course.Programs" var="programs"/>
    <fmt:message bundle="${locale}" key="course.EditCourse" var="editCourse"/>
    <fmt:message bundle="${locale}" key="course.Start" var="startCourse"/>
    <fmt:message bundle="${locale}" key="course.End" var="endCourse"/>
    <fmt:message bundle="${locale}" key="course.Format" var="formatCourse"/>
    <fmt:message bundle="${locale}" key="course.Status" var="courseStatus"/>
    <fmt:message bundle="${locale}" key="course.Lecturer" var="lecturer"/>
    <fmt:message bundle="${locale}" key="course.UsersOnCourse" var="usersOnCourse"/>
    <fmt:message bundle="${locale}" key="registration.Result" var="registrationResult"/>
    <fmt:message bundle="${locale}" key="course.RegisterError" var="registrationOnCourseError"/>
    <fmt:message bundle="${locale}" key="message.Login" var="LoginMessage"/>
    <fmt:message bundle="${locale}" key="course.ChangeStatus" var="statusCourseChange"/>
    <fmt:message bundle="${locale}" key="message.ChangeStatusCourse" var="statusCourseChangeMessage"/>
    <fmt:message bundle="${locale}" key="message.ChangeFormatCourse" var="formatCourseChangeMessage"/>
    <fmt:message bundle="${locale}" key="course.ChangeFormat" var="formatCourseChange"/>

    <title>${courses}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<br/>
<c:if test="${registerMessage == true}">
    <div class="alert alert-success" role="alert">
            ${registrationResult}
    </div>
</c:if>
<c:if test="${registerMessageError == true}">
    <div class="alert alert-danger" role="alert">
            ${registrationOnCourseError}
    </div>
</c:if>

<c:if test="${changeStatusCourse == true}">
    <div class="alert alert-success" role="alert">
            ${statusCourseChangeMessage}
    </div>
</c:if>
<c:if test="${changeFormatCourse == true}">
    <div class="alert alert-success" role="alert">
            ${formatCourseChangeMessage}
    </div>
</c:if>
<br/>
<c:out value="${course.title}"/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input class="btn btn-outline-secondary" type="submit" value="Изменить название">
        <input type="hidden" name="command" value="forwardtoeditcourse"/>
        <input type="hidden" name="courseId" value="${course.id}"/>
        <input type="hidden" name="parameter" value="title">
    </form>
</c:if>
<br/><br/>
<c:out value="${course.description}"/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input class="btn btn-outline-secondary" type="submit" value="Изменить описание">
        <input type="hidden" name="command" value="forwardtoeditcourse"/>
        <input type="hidden" name="courseId" value="${course.id}"/>
        <input type="hidden" name="parameter" value="description">
    </form>
</c:if><br/>
<br/>${startCourse}:<br/>
<c:out value="${course.startDate}"/>
<br/>
<br/>${endCourse}:<br/>
<c:out value="${course.endDate}"/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input class="btn btn-outline-secondary" type="submit" value="Изменить даты проведения курса">
        <input type="hidden" name="command" value="forwardtoeditcourse"/>
        <input type="hidden" name="courseId" value="${course.id}"/>
        <input type="hidden" name="parameter" value="start">
    </form>
</c:if>
<br/>
<br/>${formatCourse}:<br/>
<c:out value="${course.format}"/><br/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <div class="dropdown show">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenu" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
                ${formatCourseChange}
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item"
               href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&format=ONLINE">ONLINE</a>
            <a class="dropdown-item"
               href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&format=OFFLINE">OFFLINE</a>
        </div>
    </div>
</c:if>
<br/>${courseStatus}:<br/>
<c:out value="${course.status}"/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <div class="dropdown show">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
                ${statusCourseChange}
        </a>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item"
               href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=NOT_STARTED">Идет
                набор</a>
            <a class="dropdown-item"
               href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=IN_PROGRESS">Курс
                стартовал</a>
            <a class="dropdown-item"
               href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=FINISHED">Курс
                завершен</a>
        </div>
    </div>
</c:if>
<br/>
<br/>${lecturer}:<br/>
<c:out value="${user.firstName}"/> <c:out value=" ${user.lastName}"/>
<br/>
<c:choose>
    <c:when test="${role == 'STUDENT'}">
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="detailscourse"/>
            <input class="btn btn-outline-secondary" type="submit" value="${register}">
            <input type="hidden" name="courseId" value="${course.id}">
            <input type="hidden" name="register" value="register">
        </form>
    </c:when>
    <c:when test="${role == 'LECTURER' || role == 'ADMIN'}">
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="inittableusersoncourse"/>
            <input type="hidden" name="courseId" value="${course.id}">
            <input class="btn btn-outline-secondary" type="submit" value="${usersOnCourse}"/>
        </form>
    </c:when>
    <c:otherwise>
        ${LoginMessage}
    </c:otherwise>
</c:choose>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
