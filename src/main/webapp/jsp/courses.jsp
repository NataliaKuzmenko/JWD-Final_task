<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>
    <fmt:message bundle="${locale}" key="label.Courses" var="courses"/>
    <fmt:message bundle="${locale}" key="course.Programs" var="programs"/>
    <fmt:message bundle="${locale}" key="course.Details" var="details"/>

    <title>${courses}</title>
</head>
<c:import url="/jsp/common/header.jsp"/>
<body>
<br/>
${programs}
<br/>
<c:choose>
    <c:when test="${role == null}">
        <c:forEach var="course" items="${courseList}">
            <c:out value="${ course.title }"/>
            <br/>
            <a href="controller?command=detailsCourse&courseId=${course.id}">${details}<br/></a>
        </c:forEach>
    </c:when>

    <c:when test="${role == 'STUDENT'}">
        <c:forEach var="num" items="${courseList}">
            ${num}
            <br/>

            <br/>
        </c:forEach>
    </c:when>
    <c:when test="${role == 'LECTURER'}">
        <c:forEach var="num" items="${courseList}">
            ${num}
            <br/>
            Teacher
            <br/>
        </c:forEach>
    </c:when>
    <c:when test="${role == 'ADMIN'}">
        <c:forEach var="num" items="${courseList}">
            ${num}
            <br/>
            Admin
            <br/>
        </c:forEach>
    </c:when>

    <c:otherwise>
    </c:otherwise>
</c:choose>

<br/>
</body>
<fmt:message bundle="${locale}" key="button.previous" var="previous_button"/>
<fmt:message bundle="${locale}" key="button.next" var="next_button"/>

<c:set value="${param.get('page')}" var="currentPage"/>

<c:if test="${coursesCount > 4}">
<div class="row align-text-bottom justify-content-center">
    <c:if test="${currentPage > 0}">
        <a class="pr-3 text-info"
           href="${pageContext.request.contextPath}/controller?command=courseruncommand&page=${currentPage - 1}">${previous_button}</a>
    </c:if>

    <c:set var="pageCounter" value="${0}"/>
    <c:forEach var="num" begin="0" end="${coursesCount - 1}" step="5">
        <c:choose>
            <c:when test="${currentPage == pageCounter || (currentPage == null && pageCounter == 0)}">
                <a class="mx-1 h5 text-secondary"
                   href="${pageContext.request.contextPath}/controller?command=courseruncommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
            </c:when>
            <c:otherwise>
                <a class="mx-1 text-info"
                   href="${pageContext.request.contextPath}/controller?command=courseruncommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${currentPage != pageCounter - 1}">
        <a class="pl-3 text-info"
           href="${pageContext.request.contextPath}/controller?command=courseruncommand&page=${currentPage + 1}">${next_button}</a>
    </c:if>
</div>
</c:if>
<c:import url="/jsp/common/footer.jsp"/>
