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

    <fmt:message bundle="${locale}" key="course.MyCourses" var="study"/>
    <fmt:message bundle="${locale}" key="course.NotCourses" var="notCourses"/>
    <fmt:message bundle="${locale}" key="course.LeaveCourse" var="leaveCourse"/>
    <fmt:message bundle="${locale}" key="course.ErrorLeaveCourse" var="cancelCourseError"/>
    <fmt:message bundle="${locale}" key="course.Cancel" var="cancelCourse"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>
    <fmt:message bundle="${locale}" key="course.Title" var="title"/>
    <fmt:message bundle="${locale}" key="course.Start" var="start"/>
    <fmt:message bundle="${locale}" key="course.End" var="end"/>
    <fmt:message bundle="${locale}" key="course.Status" var="status"/>
    <fmt:message bundle="${locale}" key="result.Mark" var="mark"/>
    <fmt:message bundle="${locale}" key="result.Comment" var="comment"/>
    <fmt:message bundle="${locale}" key="result.StatusStudent" var="statusStudent"/>
    <fmt:message bundle="${locale}" key="user.StatusCancelCourse" var="cancel"/>
    <fmt:message bundle="${locale}" key="user.StatusFinished" var="finished"/>

    <title>${study}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="container">
    <c:if test="${errorCancelCourse ==true}">
        <div class="alert alert-warning" role="alert">
                ${cancelCourseError}</div>
    </c:if>

    <c:if test="${courseCancel == true}">
        <div class="alert alert-success" role="alert">
                ${cancelCourse}</div>
    </c:if>

    <c:if test="${listCoursesIsEmpty == true}">
        <div class="alert alert-primary" role="alert">${notCourses}</div>
    </c:if>
    <c:if test="${listCoursesIsEmpty == false}">
        <br/>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">${title}</th>
                <th scope="col">${start}</th>
                <th scope="col">${end}</th>
                <th scope="col">${status}</th>
                <th scope="col">${mark}</th>
                <th scope="col">${comment}</th>
                <th scope="col">${statusStudent}</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="result" items="${courseList}">
                <tr>
                    <td><c:out value="${result.key.title}"/></td>
                    <td><c:out value="${result.key.startDate}"/></td>
                    <td><c:out value="${result.key.endDate}"/></td>
                    <td><c:out value="${result.key.status}"/></td>
                    <td>
                        <c:if test="${result.value.mark == 0}">
                            -
                        </c:if>
                        <c:if test="${result.value.mark != 0}">
                            <c:out value="${result.value.mark}"/>
                        </c:if>
                    </td>
                    <td><c:out value="${result.value.comment}"/></td>
                    <td><c:out value="${result.value.status}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${result.value.status == 'DENIED'}">
                                ${cancel}
                            </c:when>
                            <c:when test="${result.value.status == 'FINISHED'|| result.key.status =='FINISHED'}">
                                ${finished}
                            </c:when>
                            <c:otherwise>
                                <form class="form-inline my-2 my-lg-0" method="post"
                                      action="${request.getContextPath()}/final_task_war_exploded/controller">
                                    <input class="btn btn-outline-secondary" type="submit" value="${leaveCourse}">
                                    <input type="hidden" name="command" value="viewcoursesuser"/>
                                    <input type="hidden" name="courseId" value="${result.key.id}"/>
                                </form>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input type="hidden" name="command" value="INITPROFILECOMMAND"/>
        <input class="btn btn-outline-secondary" type="submit" value="${back}">
    </form>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
