<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<head>

    <c:import url="/WEB-INF/jsp/common/header.jsp"/>

    <fmt:message bundle="${locale}" key="label.Courses" var="courses"/>
    <fmt:message bundle="${locale}" key="course.Programs" var="programs"/>
    <fmt:message bundle="${locale}" key="course.Details" var="details"/>
    <fmt:message bundle="${locale}" key="course.Create" var="createCourse"/>

</head>
<body>
<title>${courses}</title>
<br/>
${programs}
<br/>

<c:if test="${role == 'LECTURER'}">
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input type="hidden" name="command" value="forward"/>
        <input type="hidden" name="page" value="/WEB-INF/jsp/courses/create_course.jsp"/>
        <input class="btn btn-outline-secondary" type="submit" value="${createCourse}">
    </form>
</c:if>
<br/>
<c:forEach var="course" items="${courseList}">
    <c:out value="${ course.title }"/>
    <br/>
    <form class="form-inline my-2 my-lg-0" method="post"
          action="${request.getContextPath()}/final_task_war_exploded/controller">
        <input type="hidden" name="command" value="detailscourse"/>
        <input type="hidden" name="courseId" value="${course.id}"/>
        <input class="btn btn-outline-secondary" type="submit" value="${details}">
    </form>
</c:forEach>

<br/>

<fmt:message bundle="${locale}" key="button.previous" var="previous_button"/>
<fmt:message bundle="${locale}" key="button.next" var="next_button"/>

<c:if test="${role=='STUDENT' ||role== null}">

    <c:set value="${param.get('page')}" var="currentPage"/>

    <c:if test="${coursesCount > 5}">
        <div class="row align-text-bottom justify-content-center">
            <c:if test="${currentPage > 0}">
                <a class="pr-3 text-info"
                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=courseruncommand&page=${currentPage - 1}">${previous_button}</a>
            </c:if>

            <c:set var="pageCounter" value="${0}"/>
            <c:forEach var="num" begin="0" end="${coursesCount - 1}" step="5">

                <c:choose>
                    <c:when test="${currentPage == pageCounter || (currentPage == null && pageCounter == 0)}">
                        <a class="mx-1 h5 text-secondary"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=courseruncommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="mx-1 text-info"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=courseruncommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage != pageCounter - 1}">
                <a class="pl-3 text-info"
                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=courseruncommand&page=${currentPage + 1}">${next_button}</a>
            </c:if>
        </div>
    </c:if>
</c:if>

<c:if test="${role=='ADMIN' ||role=='LECTURER'}">
    <c:set value="${param.get('page')}" var="currentPage"/>

    <c:if test="${coursesCount > 5}">
        <div class="row align-text-bottom justify-content-center">
            <c:if test="${currentPage > 0}">
                <a class="pr-3 text-info"
                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=coursespage&page=${currentPage - 1}">${previous_button}</a>
            </c:if>

            <c:set var="pageCounter" value="${0}"/>
            <c:forEach var="num" begin="0" end="${coursesCount - 1}" step="5">

                <c:choose>
                    <c:when test="${currentPage == pageCounter || (currentPage == null && pageCounter == 0)}">
                        <a class="mx-1 h5 text-secondary"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=coursespage&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                    </c:when>
                    <c:otherwise>
                        <a class="mx-1 text-info"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=coursespage&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage != pageCounter - 1}">
                <a class="pl-3 text-info"
                   href="${request.getContextPath()}/final_task_war_exploded/controller?command=coursespage&page=${currentPage + 1}">${next_button}</a>
            </c:if>
        </div>
    </c:if>
</c:if>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</body>
</html>
