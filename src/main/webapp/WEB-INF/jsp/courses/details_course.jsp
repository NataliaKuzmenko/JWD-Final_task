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
    <fmt:message bundle="${locale}" key="button.ChangeDate" var="changeDate"/>
    <fmt:message bundle="${locale}" key="button.ChangeTitle" var="changeTitle"/>
    <fmt:message bundle="${locale}" key="button.ChangeDescripton" var="changeDescription"/>
    <fmt:message bundle="${locale}" key="course.GroupRecruitment" var="groupRecruitment"/>
    <fmt:message bundle="${locale}" key="course.CourseStart" var="courseStart"/>
    <fmt:message bundle="${locale}" key="course.CourseFinished" var="courseFinished"/>

    <title>${courses}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
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
<div class="container">
    <div class="row">
        <div class="col-lg-7">
            <h4 class="text-primary"><c:out value="${course.title}"/></h4>
            <c:if test="${user_id == course.lecturerId}">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="${request.getContextPath()}/final_task_war_exploded/controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${changeTitle}">
                    <input type="hidden" name="command" value="forwardtoeditcourse"/>
                    <input type="hidden" name="courseId" value="${course.id}"/>
                    <input type="hidden" name="parameter" value="title">
                </form>
            </c:if>
            <br/><br/>
            <p class="font-weight-normal">
                <c:out value="${course.description}"/></p>
            <c:if test="${user_id == course.lecturerId}">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="${request.getContextPath()}/final_task_war_exploded/controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${changeDescription}">
                    <input type="hidden" name="command" value="forwardtoeditcourse"/>
                    <input type="hidden" name="courseId" value="${course.id}"/>
                    <input type="hidden" name="parameter" value="description">
                </form>
            </c:if>
        </div>
        <div class="col-lg-5">
            <br/><br/><br/><br/>
            <c:if test="${changeStatusCourse == true}">
                <div class="alert alert-success" role="alert">
                        ${statusCourseChangeMessage}
                </div>
            </c:if>
            <c:if test="${changeFormatCourse==true}">
                <div class="alert alert-success" role="alert">
                        ${formatCourseChangeMessage}
                </div>
            </c:if>
            <br/>
            <table class="table">
                <tbody>
                <tr>
                    <td><p class="font-weight-normal">${startCourse}:</p></td>
                    <td><p class="font-italic"><c:out value="${course.startDate}"/></p></td>
                </tr>
                <tr>
                    <td><p class="font-weight-normal">${endCourse}:</p></td>
                    <td><p class="font-italic"><c:out value="${course.endDate}"/></p></td>
                    <td>
                        <c:if test="${user_id == course.lecturerId}">
                            <form class="form-inline my-2 my-lg-0" method="post"
                                  action="${request.getContextPath()}/final_task_war_exploded/controller">
                                <input class="btn btn-outline-secondary" type="submit" value="${changeDate}">
                                <input type="hidden" name="command" value="forwardtoeditcourse"/>
                                <input type="hidden" name="courseId" value="${course.id}"/>
                                <input type="hidden" name="parameter" value="start">
                            </form>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td><p class="font-weight-normal">${formatCourse}:</p></td>
                    <td><p class="font-italic"><c:out value="${course.format}"/></p></td>
                    <td><c:if test="${user_id == course.lecturerId}">
                        <div class="dropdown show">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenu"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                    ${formatCourseChange}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item"
                                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&format=ONLINE">
                                    Online</a>
                                <a class="dropdown-item"
                                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&format=OFFLINE">
                                    Offline</a>
                            </div>
                        </div>
                    </c:if>
                    </td>
                </tr>
                <tr>
                    <td><p class="font-weight-normal">${courseStatus}:</p></td>
                    <td><p class="font-italic"><c:out value="${course.status}"/></p></td>
                    <td><c:if test="${user_id == course.lecturerId}">
                        <div class="dropdown show">
                            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                               data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                    ${statusCourseChange}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                <a class="dropdown-item"
                                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=NOT_STARTED">
                                        ${groupRecruitment}</a>
                                <a class="dropdown-item"
                                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=IN_PROGRESS">
                                        ${courseStart}</a>
                                <a class="dropdown-item"
                                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=detailscourse&statusCourse=FINISHED">
                                        ${courseFinished}</a>
                            </div>
                        </div>
                    </c:if>
                    </td>
                <tr>
                    <td><p class="font-weight-normal">${lecturer}:</p></td>
                    <td><p class="font-italic"><c:out value="${user.firstName}"/> <c:out value=" ${user.lastName}"/></p>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-3">
            <br/>
            <c:choose>
                <c:when test="${role == 'STUDENT'}">
                    <br/>
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
                    <h6 class="text-info">${LoginMessage}</h6>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
