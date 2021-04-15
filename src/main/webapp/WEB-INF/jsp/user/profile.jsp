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

    <fmt:message bundle="${locale}" key="label.Logout" var="logout"/>
    <fmt:message bundle="${locale}" key="label.Profile" var="profile"/>
    <fmt:message bundle="${locale}" key="course.MyCourses" var="study"/>
    <fmt:message bundle="${locale}" key="profile.EditProfile" var="editProfile"/>
    <fmt:message bundle="${locale}" key="user.Name" var="name"/>
    <fmt:message bundle="${locale}" key="user.Surname" var="surname"/>
    <fmt:message bundle="${locale}" key="user.Email" var="Email"/>
    <fmt:message bundle="${locale}" key="user.User" var="user"/>
    <fmt:message bundle="${locale}" key="course.LecturerCourses" var="myCourses"/>

    <title>${profile}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="container"><br/>
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-1">
            <h4 class="text-info">${profile}</h4>
        </div>
        <div class="col-lg-6"></div>
    </div>
    <br/><br/>
    <div class="row">
        <div class="col-lg-4">
            <img src="images/picturesForAvatar/${photo_path}"
                 alt="" width="200"/>
        </div>
        <div class="col-lg-6">

            <table class="table">
                <tbody>
                <tr>
                    <th scope="row">${name} ${surname}</th>
                    <td><c:out value="${first_name}"/>
                        <c:out value="${last_name}"/>
                    </td>
                </tr>
                <tr>
                    <th scope="row">${Email}</th>
                    <td><c:out value="${email}"/></td>
                </tr>
                <tr>
                    <th scope="row">${user}</th>
                    <td><c:out value="${role}"/></td>
                </tr>
                </tbody>
            </table>
            <br/></div>

        <div class="col-lg-2">
            <br/>
            <form class="form-inline my-2 my-lg-0" method="post"
                  action="${request.getContextPath()}/final_task_war/controller">
                <input class="btn btn-outline-secondary" type="submit" value="${editProfile}">
                <input type="hidden" name="command" value="forward"/>
                <input type="hidden" name="page" value="/WEB-INF/jsp/user/edit_profile.jsp"/>
            </form>
            <br/><br/>
            <c:if test="${role == 'STUDENT'}">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="${request.getContextPath()}/final_task_war/controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${study}">
                    <input type="hidden" name="command" value="viewcoursesuser"/>
                </form>
            </c:if>
            <c:if test="${role == 'LECTURER'}">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="${request.getContextPath()}/final_task_war/controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${myCourses}">
                    <input type="hidden" name="command" value="courseslecturer"/>
                </form>
            </c:if>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
