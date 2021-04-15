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
    <fmt:message bundle="${locale}" key="course.NotCourses" var="not_courses"/>
    <fmt:message bundle="${locale}" key="course.LeaveCourse" var="leaveCourse"/>
    <fmt:message bundle="${locale}" key="course.ErrorLeaveCourse" var="cancelCourseError"/>
    <fmt:message bundle="${locale}" key="course.Cancel" var="cancelCourse"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>
    <fmt:message bundle="${locale}" key="course.UsersOnCourse" var="usersOnCourse"/>
    <fmt:message bundle="${locale}" key="course.Title" var="title"/>
    <fmt:message bundle="${locale}" key="course.Start" var="start"/>
    <fmt:message bundle="${locale}" key="course.End" var="end"/>
    <fmt:message bundle="${locale}" key="course.Status" var="status"/>

    <title>${study}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <c:if test="${notCourses == false}">
                <br/>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">${title}</th>
                            <th scope="col">${start}</th>
                            <th scope="col">${end}</th>
                            <th scope="col">${status}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="result" items="${courseList}">
                            <tr>
                                <td><c:out value="${result.title}"/></td>
                                <td><c:out value="${result.startDate}"/></td>
                                <td><c:out value="${result.endDate}"/></td>
                                <td><c:out value="${result.status}"/></td>
                                <td>
                                    <form class="form-inline my-2 my-lg-0" method="post"
                                          action="${request.getContextPath()}/final_task_war/controller">
                                        <input type="hidden" name="command" value="inittableusersoncourse"/>
                                        <input type="hidden" name="courseId" value="${result.id}">
                                        <input class="btn btn-outline-secondary" type="submit"
                                               value="${usersOnCourse}"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </c:if>
            <c:if test="${notCourses == true}">
                    <div class="alert alert-primary" role="alert"> ${not_courses}</div>
            </c:if>
            <br/>
            <form class="form-inline my-2 my-lg-0" method="post"
                  action="${request.getContextPath()}/final_task_war/controller">
                <input type="hidden" name="command" value="INITPROFILECOMMAND"/>
                <input class="btn btn-outline-secondary" type="submit" value="${back}">
            </form>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>