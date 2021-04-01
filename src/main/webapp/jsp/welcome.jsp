<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>

    <fmt:message bundle="${locale}" key="label.Welcome" var="welcomeStr"/>
    <fmt:message bundle="${locale}" key="registration.Result" var="registrationResult"/>
    <fmt:message bundle="${locale}" key="button.ForwardPageCourses" var="forwardPageCourses"/>
    <fmt:message bundle="${locale}" key="course.Cancel" var="cancelCourse"/>
    <fmt:message bundle="${locale}" key="error.ContactAdmin" var="contactAdmin"/>
    <fmt:message bundle="${locale}" key="user.RoleChanged" var="roleChanged"/>
    <fmt:message bundle="${locale}" key="label.RegistrationOk" var="registrationOk"/>
    <fmt:message bundle="${locale}" key="user.RoleChangedError" var="roleChangeError"/>

    <title>${welcomeStr}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:if test="${welcome == true}">
<h3>${welcomeStr}</h3><br/>
    <c:choose>
        <c:when test="${first_name == null}">
            <c:out value="${email}"/>
        </c:when>
        <c:otherwise>
            <c:out value="${first_name}"/>
        </c:otherwise>
    </c:choose>
</c:if>
<br/>
<c:if test="${registrationOk == true}">
    ${registrationResult}
</c:if>
<c:if test="${changeRoleError == true}">
   ${roleChangeError}
</c:if>

<c:if test="${changeRole == true}">
    ${roleChanged}
</c:if>

<c:if test="${courseCancel == true}">
    ${cancelCourse}
</c:if>

<c:if test="${registerMessage == true}">
    ${registrationOk}
</c:if>

<c:if test="${viewUsersError == true}">
    ${contactAdmin}
</c:if>
<br/>

<br/>
<br/>
<c:choose>
    <c:when test="${role=='STUDENT' ||role== null}">
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="courseruncommand"/>
            <input class="btn btn-outline-secondary" type="submit" value="${forwardPageCourses}"/>
        </form>
    </c:when>
    <c:otherwise>
        <form class="form-inline my-2 my-lg-0" method="post"
              action="${request.getContextPath()}/final_task_war_exploded/controller">
            <input type="hidden" name="command" value="coursespage"/>
            <input class="btn btn-outline-secondary" type="submit" value="${forwardPageCourses}"/>
        </form>
    </c:otherwise>
</c:choose>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
