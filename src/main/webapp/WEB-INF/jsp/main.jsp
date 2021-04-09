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

    <fmt:message bundle="${locale}" key="label.Main" var="namePage"/>
    <fmt:message bundle="${locale}" key="main.1.Description" var="main_1_Description"/>
    <fmt:message bundle="${locale}" key="main.2.Description" var="main_2_Description"/>
    <fmt:message bundle="${locale}" key="main.3.Description" var="main_3_Description"/>
    <fmt:message bundle="${locale}" key="main.4.Description" var="main_4_Description"/>
    <fmt:message bundle="${locale}" key="main.5.Description" var="main_5_Description"/>

    <title>${namePage} </title>

</head>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<body>
<div class="main">
    <div class="container">
        <div class="row"></div>
        <div class="row">
            <div class="col-lg-3"></div>
            <div class="col-lg-6">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="images/phon-main.jpg" class="img-fluid" class="text-info" alt="slide1">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-info">${main_1_Description}</h3>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="images/1599896359_5.jpg" class="img-fluid" alt="slide2">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-info">${main_2_Description}</h3>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img class="img-fluid" src="images/78181.jpg" alt="slide3">
                            <div class="carousel-caption d-none d-md-block">
                                <h3 class="text-info">${main_3_Description} ${main_4_Description} ${main_5_Description}</h3>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="col-lg-3"></div>
        </div>
    </div>
</div>
</body>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
</html>
