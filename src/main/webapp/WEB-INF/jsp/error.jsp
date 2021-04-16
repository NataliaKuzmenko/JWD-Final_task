<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:message bundle="${locale}" key="errorPage.Message" var="error"/>
    <fmt:message bundle="${locale}" key="error.ContactAdmin" var="contactAdmin"/>
    <fmt:message bundle="${locale}" key="message.ErrorMarkOrComment" var="errorMarkOrComment"/>

    <title>${error}</title></head>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

<br/>
<div class="alert alert-warning" role="alert">
    ${error}
</div>
<br/>
<c:if test="${incorrectMarkOrComment ==true}">
    <div class="alert alert-warning" role="alert">
            ${errorMarkOrComment}
    </div>
</c:if>
<c:if test="${viewUsersError == true}">
    <div class="alert alert-warning" role="alert">
            ${contactAdmin}
    </div>
</c:if>

<br/>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
