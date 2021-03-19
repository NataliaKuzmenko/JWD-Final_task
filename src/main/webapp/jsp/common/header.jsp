<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="localization.pagecontent" var="locale"/>

<fmt:message bundle="${locale}" key="label.Header" var="header"/>
<fmt:message bundle="${locale}" key="label.brand" var="lion"/>
<fmt:message bundle="${locale}" key="label.Title" var="title"/>
<fmt:message bundle="${locale}" key="label.Main" var="main"/>
<fmt:message bundle="${locale}" key="label.contacts" var="contacts"/>
<fmt:message bundle="${locale}" key="label.Courses" var="courses"/>
<fmt:message bundle="${locale}" key="label.language" var="changeLanguage"/>
<fmt:message bundle="${locale}" key="label.Login" var="login"/>
<fmt:message bundle="${locale}" key="label.CreateAnAccount" var="CreateAnAccount"/>
<fmt:message bundle="${locale}" key="label.Profile" var="profile"/>
<fmt:message bundle="${locale}" key="label.Logout" var="logout"/>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>${header}</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand">
                <img src="images/Lion.png" width="45" height="45">
                ${lion}
            </a>

        </div>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link">
                        <form class="form-inline my-2 my-lg-0" method="post" action="controller">
                            <input class="btn btn-outline-secondary" type="submit" value="${main}">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/jsp/main.jsp"/>
                        </form>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link">
                        <form class="form-inline my-2 my-lg-0" method="post" action="controller">
                            <input class="btn btn-outline-secondary" type="submit" value="${courses}">
                            <input type="hidden" name="command" value="courseRunCommand"/>
                        </form>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link">
                        <form class="form-inline my-2 my-lg-0" method="post" action="controller">
                            <input class="btn btn-outline-secondary" type="submit" value="${contacts}">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/jsp/contacts.jsp"/>
                        </form>
                    </a>
                </li>
            </ul>
        </div>

        <span class="navbar-brand mb-0 h1">${title}</span>

        <c:choose>
            <c:when test="${role != null}">

            <a class="nav-link">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="controller">
                    <input class="btn btn-outline-secondary" type="submit"
                           value="${profile}">
                    <input type="hidden" name="command" value="forward"/>
                    <input type="hidden" name="page" value="/jsp/profile.jsp"/>
                </form>
            </a>


            <a class="nav-link">
                <form class="form-inline my-2 my-lg-0" method="post"
                      action="controller">
                    <input class="btn btn-outline-secondary" type="submit"
                           value="${logout}">
                    <input type="hidden" name="command" value="logout"/>
                </form>
            </a>

            </c:when>
            <c:otherwise>

            <a class="nav-link">
                <form class="form-inline my-2 my-lg-0" id="headerForm" method="post" action="controller">
                    <input class="btn btn-outline-secondary" type="submit" value="${login}">
                    <input type="hidden" name="command" value="forward"/>
                    <input type="hidden" name="page" value="/jsp/login.jsp"/>
                </form>
            </a>


            <a class="nav-link">
                <form class="form-inline my-2 my-lg-0" method="post" action="controller">
                    <input type="hidden" name="command" value="forward"/>
                    <input type="hidden" name="page" value="/jsp/registration.jsp"/>
                    <input class="btn btn-outline-secondary" type="submit" value="${CreateAnAccount}"/>
                </form>

            </a>
            </c:otherwise>
        </c:choose>


        <form class="form-inline my-2 my-lg-0" method="post" action="controller">
            <input type="hidden" name="command" value="language"/>
            <input class="btn btn-outline-secondary" type="submit" name="currentNavLocale" value="${changeLanguage}">
        </form>


    </div>
</nav>
</body>
</html>
