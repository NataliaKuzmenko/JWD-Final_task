<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <fmt:message bundle="${locale}" key="result.PlaceholderComment" var="placeholderComment"/>
    <title>${editCourse}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<c:if test="${param.get('resultAdd')}">
    <div class="alert alert-success" role="alert">
            ${addResult}
    </div>
</c:if>

<br/>
<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-7">
            <form action="${request.getContextPath()}/final_task_war_exploded/controller" method="post">
                <input type="hidden" name="command" value="setcourseresult"/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">${mark}</span>
                    </div>
                    <input type="number" name="mark" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""
                           min="0" max="10"
                           placeholder="0-10"
                           required/>
                </div>
                <br/>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="password">${comment}</span>
                    </div>
                    <input type="text" name="comment" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" value=""
                           pattern=".{3,500}" placeholder="${placeholderComment}" required/>
                </div>
                <br/>

                <br/>
                <input class="btn btn-outline-primary" type="submit" value="${save}"/><br/>
            </form>
            <br/>
            <form class="form-inline my-2 my-lg-0" method="post"
                  action="${request.getContextPath()}/final_task_war_exploded/controller">
                <input type="hidden" name="command" value="inittableusersoncourse"/>
                <input class="btn btn-outline-secondary" type="submit" value="${back}">
            </form>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
