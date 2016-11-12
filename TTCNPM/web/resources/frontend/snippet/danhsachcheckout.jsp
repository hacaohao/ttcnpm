<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="util"%>
<div class="col-md-8">
    <div class="item-list">
        <h3>Đơn hàng</h3>
        <c:forEach var="item" items="${cart}">
            <hr>
            <div class="item">
                <div class="row">
                    <div class="col-md-2 col-sm-2 col-xs-2">
                        <a href="book/detail?id=${book.id}">
                            <img class="img-responsive img-book img-hover" src="<c:url value="/resources/frontend/snippet/images/${item.book.image}" />" alt="">
                        </a>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-4">
                        <p class="book-name">${item.book.name}</p>
                        <p class="book-author"><span>Tác giả: </span>${item.book.writer}</p>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-3 form-group">
                        <p><span>Đơn giá: ${item.price} VND</span></p>
                        <p><span>Số lượng: ${item.quantity}</span></p>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-3">
                        <div class="row">
                            <div class="col-md-11 col-md-offfset-1 col-sm-11 col-xs-11">
                                <p class="book-price">${item.quantity * item.price} VND</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- end item -->
        </c:forEach>
        <hr>
        <div style="text-align: center;"><h4>Tổng tiền: ${totalPrice} VND</h4></div>
    </div>
</div>