<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/resources/frontend/snippet/slider.jsp" %>  
<div class="main-content">
    <div class="container ">
        <div class="row">
            <%@include file="/resources/frontend/snippet/sidebar.jsp" %>  

            <div class="col-md-7 col-sm-6 col-xs-12 margin-bottom no-padding-left no-padding-right">
                <div class="mid-content">
                    <div class="box">
                        <div class="title">
                            <h4>${title}</h4>
                        </div> <!-- end title -->

                        <div class="item-list row">
                            <c:forEach var="book" items="${books.content}">
                                <div class="col-md-3 col-sm-6 col-xs-6 item no-padding-left no-padding-right">
                                    <a href="book/detail?id=${book.id}">
                                        <img class="img-responsive img-book img-hover img-book-boxshadow" src="<c:url value="/resources/frontend/snippet/images/${book.image}" />" alt="">
                                    </a>
                                    <p class="book-name">${book.name}</p>
                                    <p class="book-author">${book.writer}</p>
                                    <p class="book-price">${book.price}VND</p>
                                </div> <!-- end item -->
                            </c:forEach>
                        </div> <!-- end item-list -->
                        <div class="clear"></div>
                    </div> <!-- end box -->

                    <!--Pagination-->
                    <div style="text-align: center;">                       
                        <util:pagination thispage="${books}"></util:pagination>
                    </div>
                </div> <!-- end mid-content -->
            </div>

            <%@include file="/resources/frontend/snippet/bestSelling.jsp" %> 
        </div>
    </div>
</div>