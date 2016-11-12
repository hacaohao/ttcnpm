<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
            <div class="progress-bar progress-bar-warning" style="width: 34%">
                <p class="text-center">Hình thức thanh toán</p>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <form method="post" action="checkout/finalStep" id="invoice" class="thanhtoan" >
                        <h4>Hình thức thanh toán</h4>
                        <div class="form-group">
                            <label>
                                <input type="radio" name="payment" id="optionsRadios1" value="true" checked>
                                Thanh toán khi nhận hàng
                            </label>
                        </div>
                        <div class="form-group">
                            <label>
                                <input type="radio" name="payment" id="optionsRadios2" value="false">
                                Chuyển khoản
                            </label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-5 control-label" style="text-align: left;">Mã giảm giá</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="inputMa" placeholder="" name="code">
                            </div>
                        </div>
                        <div style="text-align: center;"><button type="submit" class="btn btn-primary">Thanh toán</button></div>
                    </form>
                </div>
                <%@include file="/resources/frontend/snippet/danhsachcheckout.jsp" %>
            </div>
        </div>
    </div>
</div>