<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Carousel -->
<div id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <div class="fill" style='background-image:url("<c:url value="/resources/frontend/snippet/images/slider1.png" />");background-size: 100% 100%;'></div>
        </div>
        <div class="item">
            <div class="fill" style='background-image:url("<c:url value="/resources/frontend/snippet/images/slider2.jpg" />");background-size: 100% 100%;'></div>
        </div>
        <div class="item">
            <div class="fill" style='background-image:url("<c:url value="/resources/frontend/snippet/images/slider3.jpg" />");background-size: 100% 100%;'></div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
</div> <!-- end Carousel -->
