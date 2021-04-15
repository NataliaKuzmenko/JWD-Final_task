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
    <fmt:message bundle="${locale}" key="course.Start" var="courseStart"/>
    <fmt:message bundle="${locale}" key="course.End" var="courseEnd"/>
    <fmt:message bundle="${locale}" key="label.back" var="back"/>
    <fmt:message bundle="${locale}" key="message.EnterData" var="enterData"/>
    <fmt:message bundle="${locale}" key="message.CheckData" var="checkData"/>
    <fmt:message bundle="${locale}" key="course.Title" var="title"/>
    <fmt:message bundle="${locale}" key="course.Description" var="description"/>


    <title>${editCourse}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<jsp:useBean id="currentDate" class="java.util.Date"/>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-8">
            <br/>
            <c:if test="${param.get('editCourseResult')}">
                <div class="alert alert-success" role="alert">
                        ${resultEditCourse}
                </div>
            </c:if>
            <br/>
            <c:if test="${errorData == true}">
                <div class="alert alert-warning" role="alert">
                        ${enterData}</div>
            </c:if><br/>
            <c:if test="${error == true}">
                <div class="alert alert-warning" role="alert">
                        ${checkData}</div>
            </c:if><br/>
            <c:choose>
                <c:when test="${parameter == 'title'}">
                    <form class="form-inline my-2 my-lg-0" method="post"
                          action="${request.getContextPath()}/final_task_war/controller">
                        <input type="hidden" name="command" value="editcourse"/>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">${title}</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="inputGroup-sizing-default"
                                   name="title" value="" minlength="3" maxlength="100">
                            <input class="btn btn-outline-secondary" type="submit" value="${save}">
                        </div>
                    </form>
                </c:when>
                <c:when test="${parameter == 'description'}">
                    <form class="form-inline my-2 my-lg-0" method="post"
                          action="${request.getContextPath()}/final_task_war/controller">
                        <input type="hidden" name="command" value="editcourse"/>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text">${description}</span>
                            </div>
                            <input type="text" class="form-control" aria-label="Default"
                                   aria-describedby="inputGroup-sizing-default"
                                   name="description" value="" minlength="3" maxlength="1500">
                            <input class="btn btn-outline-secondary" type="submit" value="${save}">
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="form-inline my-2 my-lg-0" method="post"
                          action="${request.getContextPath()}/final_task_war/controller">
                        <input type="hidden" name="command" value="editcourse"/>
                        <table class="table">
                            <tbody>
                            <tr>
                                <td><p class="font-weight-normal">${courseStart}:</p></td>
                                <td><input type="date" class="form-control form-control-sm"
                                           id="startDate" name="start" required value=""
                                           min="<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd"/>"
                                           max="2099-12-31"/>
                                </td>
                            </tr>
                            <tr>
                                <td><p class="font-weight-normal">${courseEnd}:</p></td>
                                <td><input type="date" class="form-control form-control-sm"
                                           id="endDate" name="end"
                                           value=""
                                           required max="2099-12-31"
                                           min="<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd"/>"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn btn-outline-secondary" type="submit" value="${save}"></td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </c:otherwise>
            </c:choose>
            <p>
            <form class="form-inline my-2 my-lg-0" method="post"
                  action="${request.getContextPath()}/final_task_war/controller">
                <input type="hidden" name="command" value="detailscourse"/>
                <input class="btn btn-outline-secondary" type="submit" value="${back}">
            </form>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
