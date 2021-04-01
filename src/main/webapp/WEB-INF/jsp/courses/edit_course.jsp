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

    <fmt:message bundle="${locale}" key="course.EditCourse" var="editCourse"/>
    <fmt:message bundle="${locale}" key="course.editCourseResult" var="resultEditCourse"/>
    <fmt:message bundle="${locale}" key="button.Save" var="save"/>

    <title>${editCourse}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
Страница редактирования курсов
<br/>
<form class="form-inline my-2 my-lg-0" method="post" action="${request.getContextPath()}/final_task_war_exploded/controller">
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
             <input type="hidden" name="command" value="editcourse"/>
       <input class="btn btn-outline-secondary" type="submit" value="${save}">
</form>
    <br/>
    <c:if test="${editCourseResult == true}">
        ${resultEditCourse}
    </c:if>
<body>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
