<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row margin-bottom">
        <div class="col-md-8">
            <span class="no-padding-left no-padding-right margin-left"><i style="color: #8c8c8c;" class="fa fa-phone-square fa-2x" aria-hidden="true"></i><span class="icon-font">(08)123456 - 097654321</span></span>
            <span class="no-padding-left no-padding-right"><i style="color: #8c8c8c;" class="fa fa-car fa-2x" aria-hidden="true"></i><span class="icon-font">Miễn phí giao hàng</span></span>
            <span class="no-padding-left no-padding-right"><i style="color: #8c8c8c;" class="fa fa-book fa-2x" aria-hidden="true"></i><span class="icon-font">60.000 tựa sách</span></span>
        </div>
        <div class="col-md-4">
            <span class="pull-right">
                <form method="get" action="book/search">
                    <input type="text" placeholder="Nhập từ khóa" class="myinput-search" name="keyword">
                    <input type="hidden" name="page" value="1" />
                    <button type="submit"><i class="fa fa-search fa-2x" style="color: #8c8c8c;"></i></button>
                </form>
            </span>
        </div>
    </div>
</div>