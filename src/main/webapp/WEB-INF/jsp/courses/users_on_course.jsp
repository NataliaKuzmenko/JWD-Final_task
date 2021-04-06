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

    <fmt:message bundle="${locale}" key="label.Courses" var="courses"/>
    <fmt:message bundle="${locale}" key="table.ListStudents" var="listStudents"/>
    <fmt:message bundle="${locale}" key="user.Email" var="email"/>
    <fmt:message bundle="${locale}" key="user.Name" var="name"/>
    <fmt:message bundle="${locale}" key="user.Surname" var="surname"/>
    <fmt:message bundle="${locale}" key="result.StatusStudent" var="status"/>
    <fmt:message bundle="${locale}" key="result.Mark" var="mark"/>
    <fmt:message bundle="${locale}" key="result.Comment" var="comment"/>
    <fmt:message bundle="${locale}" key="user.ChangeStatus" var="changeStatusStudent"/>
    <fmt:message bundle="${locale}" key="button.AddResults" var="addResults"/>
    <fmt:message bundle="${locale}" key="message.ListEmpty" var="listEmpty"/>
        <title>${courses}</title>
</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>

    <c:if test="${errorData == true}">
        <div class="alert alert-primary" role="alert">
        ${listEmpty}
        </div>
    </c:if>

${listStudents}
<br/>
<table class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">${email}</th>
        <th scope="col">${name}</th>
        <th scope="col">${surname}</th>
        <th scope="col">${status}</th>
        <th scope="col">${mark}</th>
        <th scope="col">${comment}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="result" items="${userList}">
        <tr>
            <td><c:out value="${result.key.email}"/></td>
            <td><c:out value="${result.key.firstName}"/></td>
            <td><c:out value="${result.key.lastName}"/></td>
            <td><c:out value="${result.value.status}"/>
                <div class="dropdown show">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                       data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        ${changeStatusStudent}
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <a class="dropdown-item"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=inittableusersoncourse&user_id=${result.key.userId}&statusUser=APPLIED">Подал
                            заявку</a>
                        <a class="dropdown-item"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=inittableusersoncourse&user_id=${result.key.userId}&statusUser=TRAINING_IN_PROGRESS">Занимается
                            на курсе</a>
                        <a class="dropdown-item"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=inittableusersoncourse&user_id=${result.key.userId}&statusUser=FINISHED">Закончил
                            курс</a>
                        <a class="dropdown-item"
                           href="${request.getContextPath()}/final_task_war_exploded/controller?command=inittableusersoncourse&user_id=${result.key.userId}&statusUser=DENIED">Отклонить
                            заявку</a>
                    </div>
                </div>
            </td>
            <td><c:out value="${result.value.mark}"/></td>
            <td><c:out value="${result.value.comment}"/></td>
            <td>
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="${request.getContextPath()}/final_task_war_exploded/controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${addResults}">
                    <input type="hidden" name="command" value="forwardtosetresult"/>
                    <input type="hidden" name="user_id" value="${result.key.userId}"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
