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
                        <form method="post" action="controller">
                            <input type="submit" value="${main}">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/WEB-INF/jsp/main.jsp"/>
                        </form>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link">
                        <form method="post" action="controller">
                            <input type="submit" value="${courses}">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/WEB-INF/jsp/courses.jsp"/>
                        </form>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link">
                        <form method="post" action="controller">
                            <input type="submit" value="${contacts}">
                            <input type="hidden" name="command" value="forward"/>
                            <input type="hidden" name="page" value="/WEB-INF/jsp/contacts.jsp"/>
                        </form>
                    </a>
                </li>


            </ul>

        </div>

        <span class="navbar-brand mb-0 h1">${title}</span>


        <form method="post" action="controller">
            <input type="hidden" name="command" value="language"/>
            <input type="submit" value="${changeLanguage}">
        </form>

    </div>
    </div>
    </div>
    </div>
</nav>
</body>
</html>
