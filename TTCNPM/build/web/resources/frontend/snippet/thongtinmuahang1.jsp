<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content">
    <div class="container ttmh">
        <div class="progress">
            <div class="progress-bar progress-bar-success" style="width: 33%">
                <p class="text-center">Đăng nhập</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <form method="post" action="checkout/checkoutStep1" id="invoice">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Vui lòng điền email:</label>                            
                            <input type="email" class="form-control" id="exampleInputEmail1" name="customerEmail" value="${sessionScope.user.email}" placeholder="Email" required />  
                        </div>
                        <div style="text-align: center;"><button type="submit" class="btn btn-primary">Tiếp tục</button></div>
                    </form>
                </div>
                <%@include file="/resources/frontend/snippet/danhsachcheckout.jsp" %>
            </div>
        </div>
    </div>
</div>