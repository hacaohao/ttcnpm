<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="main-content">
    <div class="container ttmh">
        <br>
        <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 33%">
                <p class="text-center">Đăng nhập</p>
            </div>
            <div class="progress-bar progress-bar-info" style="width: 33%">
                <p class="text-center">Thông tin mua hàng</p>
            </div>
        </div>
        <div class="container-fluid ">
            <div class="row">
                <div class="col-md-4">
                    <h4>Thông tin giao hàng</h4><br/>
                    <form:form class="form-horizontal" method="post" action="checkout/checkoutStep2" commandName="invoice">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-12">
                                    <label>Họ và tên</label><input type="text" class="form-control" name="customerName" value="${sessionScope.user.member.name}" required />
                                </div> 
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-12">
                                    <label>Số điện thoại</label><input type="phone" class="form-control" name="customerPhone" value="${sessionScope.user.member.phone}" required />
                                </div> 
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-12">
                                    <label>Địa chỉ</label><input type="text" class="form-control" name="customerAddress" value="" required />
                                </div> 
                            </div>
                        </div>
                        <div style="text-align: center;"><button type="submit" class="btn btn-primary">Tiếp tục</button></div>
                    </form:form>
                </div>
                <%@include file="/resources/frontend/snippet/danhsachcheckout.jsp" %>
            </div>
        </div>
    </div>
</div>