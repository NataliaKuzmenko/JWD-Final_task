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

    <title>${profile}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
${profile}
<br/>
<c:out value="${first_name}"/>
<c:out value="${last_name}"/>
<br/>

<img src="images/picturesForAvatar/${photo_path}"
     alt="" width="200"/>

<br/>
<br/>
<c:out value="${email}"/>
<br/>
<br/>
<c:out value="${role}"/>
<br/>
<form class="form-inline my-2 my-lg-0" method="post" action="${request.getContextPath()}/final_task_war_exploded/controller">
    <input class="btn btn-outline-secondary" type="submit" value="${editProfile}">
    <input type="hidden" name="command" value="forward"/>
    <input type="hidden" name="page" value="/WEB-INF/jsp/user/edit_profile.jsp"/>
</form>
<br/>
<c:if test="${role == 'STUDENT'}">
<form class="form-inline my-2 my-lg-0" method="post" action="${request.getContextPath()}/final_task_war_exploded/controller">
    <input class="btn btn-outline-secondary" type="submit" value="${study}">
    <input type="hidden" name="command" value="viewcoursesuser"/>
</form>
</c:if>
</html>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>

