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


    <title>${study}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<c:if test="${errorCancelCourse ==true}">
    ${cancelCourseError}
</c:if>
<c:if test="${courseCancel == true}">
    ${cancelCourse}
</c:if>

<c:if test="${listCoursesIsEmpty ==true}">
    ${notCourses}
</c:if>
<c:if test="${listCoursesIsEmpty ==false}">
    <br/>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Название курса</th>
            <th scope="col">Начало курса</th>
            <th scope="col">Завершение курса</th>
            <th scope="col">Статус курса</th>
            <th scope="col">Оценка студента</th>
            <th scope="col">Отзыв студента</th>
            <th scope="col">Статус студента</th>
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
                           Курс отменен
                        </c:when>
                        <c:when test="${result.value.status == 'FINISHED'}">
                            Курс завершен
                        </c:when>
                        <c:otherwise>
                            <form class="form-inline my-2 my-lg-0" method="post"
                                  action="${request.getContextPath()}/final_task_war_exploded/controller">
                                <input class="btn btn-outline-secondary" type="submit" value="${leaveCourse}">
                                <input type="hidden" name="command" value="leavecourse"/>
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

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
