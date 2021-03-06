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

    <fmt:message bundle="${locale}" key="label.Users" var="users"/>
    <fmt:message bundle="${locale}" key="button.ChangeRole" var="change_role"/>
    <fmt:message bundle="${locale}" key="user.RoleChanged" var="roleChanged"/>
    <fmt:message bundle="${locale}" key="user.RoleChangedError" var="roleChangeError"/>
    <fmt:message bundle="${locale}" key="user.Name" var="name"/>
    <fmt:message bundle="${locale}" key="user.Surname" var="surname"/>
    <fmt:message bundle="${locale}" key="user.Email" var="email"/>
    <fmt:message bundle="${locale}" key="user.User" var="user"/>

    <title>${users}</title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h3 class="text-info">${users}</h3>
            <c:if test="${changeRoleError == true}">
                <div class="alert alert-warning" role="alert">
                        ${roleChangeError}</div>
            </c:if>
            <c:if test="${changeRole == true}">
                <div class="alert alert-success" role="alert">
                        ${roleChanged}</div>
            </c:if>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">${name}</th>
                    <th scope="col">${surname}</th>
                    <th scope="col">${email}</th>
                    <th scope="col">${user}</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td><c:out value="${ user.firstName }"/></td>
                        <td><c:out value="${ user.lastName }"/></td>
                        <td><c:out value="${ user.email }"/></td>
                        <td><c:out value="${ user.role }"/></td>
                        <td>
                            <form class="form-inline my-2 my-lg-0" method="post"
                                  action="${request.getContextPath()}/final_task_war/controller">
                                <input class="btn btn-outline-secondary" type="submit" value="${change_role}">
                                <input type="hidden" name="command" value="inittableuserscommand"/>
                                <input type="hidden" name="user_id" value="${user.userId}"/>
                                <input type="hidden" name="role" value="${user.role}"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <c:set value="${param.get('page')}" var="currentPage"/>

            <c:if test="${usersCount > 5}">
                <div class="row align-text-bottom justify-content-start">
                    <c:if test="${currentPage > 0}">
                        <a class="pr-3 text-info"
                           href="${request.getContextPath()}/final_task_war/controller?command=inittableuserscommand&page=${currentPage - 1}">${previous_button}</a>
                    </c:if>

                    <c:set var="pageCounter" value="${0}"/>
                    <c:forEach var="num" begin="0" end="${usersCount - 1}" step="5">

                        <c:choose>
                            <c:when test="${currentPage == pageCounter || (currentPage == null && pageCounter == 0)}">
                                <a class="mx-1 h5 text-secondary"
                                   href="${request.getContextPath()}/final_task_war/controller?command=inittableuserscommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                            </c:when>
                            <c:otherwise>
                                <a class="mx-1 text-info"
                                   href="${request.getContextPath()}/final_task_war/controller?command=inittableuserscommand&page=${pageCounter}">${pageCounter = pageCounter + 1}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${currentPage != pageCounter - 1}">
                        <a class="pl-3 text-info"
                           href="${request.getContextPath()}/final_task_war/controller?command=inittableuserscommand&page=${currentPage + 1}">${next_button}</a>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
