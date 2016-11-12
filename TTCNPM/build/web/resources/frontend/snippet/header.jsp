<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="signupmodal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
        </div>
    </div>
</div>
<jsp:include page="/resources/frontend/snippet/dangnhap.jsp"/>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-sm-12">
                <a  style="float: left;" class="name-store" href="site/index"><span class="name-1">BK</span><span class="name-2">Book</span></a>
                <ul class="nav-mymenu">
                    <li><a href="site/index" class="trangchu" style="text-decoration: none;">TRANG CHỦ</a></li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle danhmuc" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" style="text-decoration: none;">DANH MỤC <span class="caret"></span></a>
                      <ul class="dropdown-menu">
                          <c:forEach var="category" items="${categories}">
                              <spring:url value="category" var="first">
                                    <spring:param name="page" value="1" />
                                    <spring:param name="id" value="${category.id}" />
                                </spring:url>
                              <li><a href="${first}">${category.name}</a></li>
                          </c:forEach>
                      </ul>
                    </li>
                    <li><a href="site/about" style="text-decoration: none;" class="cuahang">CỬA HÀNG</a></li>
                </ul>
                <div class="clear"></div>
            </div>
            
            <c:if test="${empty sessionScope.user}">
                <div class="col-md-4 col-sm-12">
                    <div class="pull-right">
                        <ul class="nav-mymenu">
                            <li class="no-padding-right"><a href="<c:url value="/resources/frontend/snippet/dangki.jsp" />" class="sign-in" data-toggle="modal" data-target="#signupmodal" style="padding: 12px 5px;">ĐĂNG KÍ</a></li>
                            <li class="no-padding-left"><a class="btn btn-primary" href="#stack1" data-toggle='modal' style="padding: 0px 10px;">ĐĂNG NHẬP</a></li>
                        </ul>
                    </div>
                </div>
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                <div class="col-md-4 col-sm-12">
                    <div class="pull-right">
                        <ul class="nav-mymenu">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b class="caret"></b></a>
                                <ul class="dropdown-menu" style="margin-right: 40px;">
                                    <li><a href="user/info">Thông tin cá nhân</a></li>
                                    <li><a href="#">Lịch sử đơn hàng</a></li>
                                    <li><a href="cart/seeCart?page=1">Giỏ hàng</a></li>
                                    <li><a href="authentication/logout">Đăng xuất</a></li>
                                </ul>
                            </li>
                            <li><img height="35px" class="img-circle" src="<c:url value="/resources/frontend/snippet/images/${sessionScope.user.member.avatar}" />" alt="" /></li> 
                        </ul>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
    <hr class="myhr">
</header>