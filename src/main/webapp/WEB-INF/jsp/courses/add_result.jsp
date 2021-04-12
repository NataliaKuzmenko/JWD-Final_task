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
    <fmt:message bundle="${locale}" key="message.ErrorMarkOrComment" var="errorMarkOrComment"/>
    <fmt:message bundle="${locale}" key="message.ResultAdd" var="addResult"/>
    <fmt:message bundle="${locale}" key="result.Mark" var="mark"/>
    <fmt:message bundle="${locale}" key="result.Comment" var="comment"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>

    <title>${editCourse}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-7">
            <p></p>
            <c:if test="${param.get('resultAdd')}">
                <div class="alert alert-success" role="alert">
                        ${addResult}
                </div>
            </c:if>
            <br/>
            <form method="post"
                  action="${request.getContextPath()}/final_task_war_exploded/controller">
                <input type="hidden" name="command" value="setcourseresult"/>
                <p class="text-dark">${mark}:
                    <br/><input type="text" name="mark" value=""/></p>
                <p class="text-dark">${comment}:
                    <br/><input type="text" name="comment" value=""/></p>

                <c:if test="${incorrectMarkOrComment == true}">
                    <div class="alert alert-warning" role="alert">
                            ${errorMarkOrComment}
                    </div>
                </c:if>
                <br/>
                <input class="btn btn-outline-secondary" type="submit" value="${save}">
            </form>
            <br/>
            <form class="form-inline my-2 my-lg-0" method="post"
                  action="${request.getContextPath()}/final_task_war_exploded/controller">
                <input type="hidden" name="command" value="inittableusersoncourse"/>
                <input class="btn btn-outline-secondary" type="submit" value="${back}">
            </form>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
