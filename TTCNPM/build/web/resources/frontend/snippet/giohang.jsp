<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<div class="main-content">
    <div class="container">

        <div class="row">
            <h3><span class="glyphicon glyphicon-shopping-cart"></span> Giỏ hàng</h3>
        </div>

        <div class="item-title">
            <div class="row">
                <div class="col-md-5 col-md-offset-2 col-sm-5 col-sm-offset-2 col-xs-5 col-xs-offset-2">
                    <h3>Mặt hàng</h3>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-2">
                    <h3>Số lượng</h3>
                </div>
                <div class="col-md-3 col-sm-3 col-xs-3">
                    <h3>Tổng giá</h3>
                </div>
            </div>
        </div> <!-- end item title -->

        <div class="item-list">
            <c:if test="${!empty cart}">
                <c:forEach var="item" items="${cart}" varStatus="counter">
                    <div class="item">
                        <div class="row">
                            <div class="col-md-2 col-sm-2 col-xs-12">
                                <a>
                                    <img class="img-responsive img-book img-hover img-book-boxshadow" src="<c:url value="/resources/frontend/snippet/images/${item.book.image}" />" alt="">
                                </a>
                            </div>
                            <div class="col-md-5 col-sm-5 col-xs-6">
                                <p class="book-name"><span>Tác phẩm: </span>${item.book.name}</p>
                                <p class="book-author"><span>Tác giả: </span>${item.book.writer}</p>
                                <p class="book-price"><span>Giá bán: </span>${item.price} VND</p>
                            </div>
                            <div class="col-md-2 col-sm-2 col-xs-2 form-group">
                                <form method="post" action="cart/updateQuantity">
                                    <input type="hidden" name="index" value="${counter.index}" />
                                    <input type="number" name="quantity" class="form-control margin-top" min="0" value="${item.quantity}" />
                                    <br/>
                                    <input type="submit" class="btn btn-success" value="Đồng ý" />
                                </form>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-4">
                                <div class="row">
                                    <div class="col-md-11 col-md-offfset-1 col-sm-11 col-xs-11">
                                        <a href="cart/deleteItem?index=${counter.index}" class="glyphicon glyphicon-remove pull-right" ></a>
                                        <p class="book-price margin-top">${item.price * item.quantity} VND</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!-- end item -->
                </c:forEach>
                <div style="text-align: center;">                       
                    <util:pagination thispage="${page}"></util:pagination>
                </div>
                <div class="item-title" >
                    <div class="row">
                        <div class="col-md-2 col-md-offset-7 col-sm-2 col-sm-offset-7 col-xs-2 col-xs-offset-7">
                            <h3>Tổng tiền</h3>
                        </div>
                        <div class="col-md-3 col-sm-3 col-xs-3">
                            <h3>${totalPrice} VND</h3>
                        </div>
                    </div>
                </div> <!-- end item-title -->
                <div class="row">
                    <div class="pull-right margin-right margin-top margin-bottom">
                        <a href="checkout/initCheckout" class="btn btn-primary">Thanh toán</a>
                        <a href="site/index" class="btn btn-primary">Trang chủ</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty cart}">
                <div class="item">
                    <div class="row">
                        <p class="text-danger text-center">Không có sản phẩm nào trong giỏ hàng</p>
                    </div>  
                </div>
            </c:if>          
        </div> <!-- end item-list -->
    </div>
</div>