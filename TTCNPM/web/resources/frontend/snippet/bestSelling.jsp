<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-3 col-sm-3 col-xs-12 margin-bottom no-padding-left no-padding-right">
    <div class="right-content">
        <div class="box">
            <div class="title">
                <h4>Bán chạy trong tuần</h4>
            </div>  <!-- end title -->
            <div class="item-list ">
                <c:forEach var="book" items="${bestSeller}">
                    <div class="item col-md-12 col-sm-12 col-xs-6 no-padding-right no-padding-left margin-bottom">
                        <div class="col-md-5 col-sm-12 no-padding-right no-padding-left">
                            <a href="book/detail?id=${book.id}">
                                <img class="img-responsive img-book img-hover img-book-boxshadow" src="<c:url value="/resources/frontend/snippet/images/${book.image}" />" alt="">
                            </a>
                        </div> 
                        <div class="col-md-7 col-sm-12 no-padding-right no-padding-left">
                            <p class="book-name">${book.name}</p>
                            <p class="book-author">${book.writer}</p>
                            <p class="book-price">${book.price}VND</p>
                        </div>
                    </div> <!-- end item -->
                </c:forEach>
            </div> <!-- end item-list -->

            <div class="link-more">
                <spring:url value="book/bestSeller" var="first">
                    <spring:param name="page" value="1" />
                </spring:url>
                <a href="${first}" class="pull-right"><< Xem chi tiết >></a>
            </div> <!-- end link-more -->
            <div class="clear"></div>
        </div>

    </div><!-- end right-content -->
</div>  
