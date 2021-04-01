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
    <fmt:message bundle="${locale}" key="course.RegisterError" var="registrationOnCourseError"/>

    <title>${courses}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<br/>
<c:out value="${course.title}"/>
<br/><br/>
<c:out value="${course.descripton}"/><br/>
<br/>${startCourse}:<br/>
<c:out value="${course.startDate}"/><br/>
<br/>${endCourse}:<br/>
<c:out value="${course.endDate}"/><br/>
<br/>${formatCourse}:<br/>
<c:out value="${course.format}"/><br/>
<br/>${courseStatus}:<br/>
<c:out value="${course.status}"/>
<c:if test="${role == 'LECTURER' || role == 'ADMIN'}">
    <div class="dropdown show">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Изменить статус курса
        </a>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="${request.getContextPath()}/final_task_war_exploded/controller?command=updatestatuscourse&courseId=${course.id}&statusCourse=NOT_STARTED">Идет набор</a>
            <a class="dropdown-item" href="${request.getContextPath()}/final_task_war_exploded/controller?command=updatestatuscourse&courseId=${course.id}&statusCourse=IN_PROGRESS">Курс стартовал</a>
            <a class="dropdown-item" href="${request.getContextPath()}/final_task_war_exploded/controller?command=updatestatuscourse&courseId=${course.id}&statusCourse=FINISHED">Курс завершен</a>
        </div>
    </div>

    <form class="form-inline my-2 my-lg-0" method="post" action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input class="btn btn-outline-secondary" type="submit" value="Изменить статус курса">
        <input type="hidden" name="command" value="updatestatuscourse"/>
        <input type="hidden" name="courseId" value="${course.id}">
    </form>
</c:if>
<br/>
<br/>${lecturer}:<br/>
<c:out value="${user.firstName}"/> <c:out value=" ${user.lastName}"/>
<br/><br/>

<c:if test="${registerMessageError == true}">
    ${registrationOnCourseError}
</c:if>
<br/>
<c:choose>
    <c:when test="${role == 'STUDENT'}">
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="registeroncourse"/>
            <input class="btn btn-outline-secondary" type="submit" value="${register}">
        </form>
    </c:when>
    <c:when test="${role == 'LECTURER' || role == 'ADMIN'}">
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="inittableusersoncourse"/>
            <input type="hidden" name="courseId" value="${course.id}">
            <input class="btn btn-outline-secondary" type="submit"
                   value="${usersOnCourse}"/>
        </form>
        <br/>
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="forward"/>
            <input type="hidden" name="page" value="/jsp/courses/edit_course.jsp"/>
            <input class="btn btn-outline-secondary" type="submit" value="${editCourse}">
        </form>
    </c:when>
    <c:otherwise>
        Войдите в систему,чтобы продолжить
    </c:otherwise>
</c:choose>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
