<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:setLocale value="${language}" scope="session"/>
    <fmt:setBundle basename="localization.pagecontent" var="locale"/>
    <fmt:message bundle="${locale}" key="label.Welcome" var="welcomeStr"/>
    <fmt:message bundle="${locale}" key="button.ForwardPageCourses" var="forwardPageCourses"/>
    <fmt:message bundle="${locale}" key="label.RegistrationOk" var="registration_ok"/>
    <fmt:message bundle="${locale}" key="registration.Result" var="registrationResult"/>

    <title>${welcomeStr}</title>

</head>
<body>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<br/>
<br/>
<div class="container">
    <div class="row">
        <div class="col-lg-5"></div>
        <div class="col-lg-3">
            <h6 class="font-italic" class="text-info">${welcomeStr},
                <c:choose>
                    <c:when test="${first_name == null}">
                        <c:out value="${email}"/>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${first_name}"/>
                    </c:otherwise>
                </c:choose>!
            </h6>
            <br/>
            <c:if test="${param.get('registrationOk')}">
                <div class="alert alert-success" role="alert">
                        ${registration_ok}
                </div>
            </c:if>

            <c:choose>
                <c:when test="${role=='STUDENT' ||role== null}">
                    <form class="form-inline my-2 my-lg-0" method="post"
                          action="${request.getContextPath()}/final_task_war/controller">
                        <input type="hidden" name="command" value="courseruncommand"/>
                        <input class="btn btn-outline-secondary" type="submit" value="${forwardPageCourses}"/>
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="form-inline my-2 my-lg-0" method="post"
                          action="${request.getContextPath()}/final_task_war/controller">
                        <input type="hidden" name="command" value="coursespage"/>
                        <input class="btn btn-outline-secondary" type="submit" value="${forwardPageCourses}"/>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-lg-4"></div>
    </div>
</div>
</body>
<br/><br/><br/><br/><br/><br/><br/><br/>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
