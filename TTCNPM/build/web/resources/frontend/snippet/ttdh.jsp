<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Thông tin đơn hàng</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/all.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

  </head>
  <body>
    <div id="global-header"></div>
    <div class="main-content">
    <div class="container" style="font-size: 1.2em; margin: auto;">
        <h3 style="margin-top: 0px; font-weight: bold;">Thông tin đơn hàng</h3>
        <table class="table-responsive">
            <tr>
                <td style="width: 200px;">
                    <span>Mã đơn hàng:</span>
                </td>
                <td>
                    <span>AKC22433109</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Trạng thái đơn hàng:</span>
                </td>
                <td>
                    <span style="font-weight: bold;">Đặt hàng</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Hình thức thanh toán:</span>
                </td>
                <td>
                    <span>Thanh toán khi nhận hàng</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Ngày giao hàng:</span>
                </td>
                <td>
                    <span>05-10-2016</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Ghi chú:</span>
                </td>
                <td>
                    <span></span>
                </td>
            </tr>
        </table>

        <h3 style="font-weight: bold;">Thông tin khách hàng</h3>
        <table class="table-responsive">
            <tr>
                <td style="width: 200px;">
                    <span>Họ và tên:</span>
                </td>
                <td>
                    <span style="font-weight: bold;">Nguyễn Văn X</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Số điện thoại:</span>
                </td>
                <td>
                    <span>0983612317</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Email:</span>
                </td>
                <td>
                    <span>nguyenvanx@gmail.com</span>
                </td>
            </tr>
            <tr>
                <td>
                    <span>Địa chỉ nhận hàng:</span>
                </td>
                <td>
                    <span>Số 59 đường Võ Văn Ngân, quận Thủ Đức, TP.HCM</span>
                </td>
            </tr>
        </table>

        <h3 style="font-weight: bold;">Chi tiết đơn hàng</h3>
        <table class="table-responsive table-hover" style="width: 100%;">
            <tr>
                <th style="width: 400px; font-size: 1.2em; font-weight: bold; text-align: center; border: 1px solid;">
                    Sản phẩm
                </th>
                <th style="width: 200px; font-size: 1.2em; font-weight: bold; text-align: center; border: 1px solid;">
                    Đơn giá
                </th>
                <th style="width: 200px; font-size: 1.2em; font-weight: bold; text-align: center; border: 1px solid;">
                    Số lượng
                </th>
                <th style="width: 200px; font-size: 1.2em; font-weight: bold; text-align: center; border: 1px solid;">
                    Thành tiền
                </th>
            </tr>
            <tr>
                <td style="border: 1px solid;">
                    <img src="images/thobaymau.jpg" alt="thobaymau" class="img-thumbnail" style="width: 100px; height: 100px; margin-right: 20px;" />
                    <span>Thỏ bảy màu</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>68.000</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>2</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>136.000</span>
                </td>
            </tr>
            <tr>
                <td style="border: 1px solid;">
                    <img src="images/toitaigioibancungthe.jpg" alt="thobaymau" class="img-thumbnail" style="width: 100px; height: 100px; margin-right: 20px;" />
                    <span>Tôi tài giỏi, bạn cũng thế</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>220.000</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>1</span>
                </td>
                <td style="border: 1px solid; text-align: center;">
                    <span>220.000</span>
                </td>
            </tr>
            <tr>
                <td style="border-left: 1px solid; font-weight: bold; padding: 2px 5px;" colspan="3">
                    <span>Tổng</span>
                </td>
                <td style="border-left: 1px solid; border-right: 1px solid; text-align: center; font-weight: bold;">
                    <span>356.000</span>
                </td>
            </tr>
            <tr>
                <td style="border-left: 1px solid; font-weight: bold; padding: 2px 5px;" colspan="3">
                    <span>VAT (10%)</span>
                </td>
                <td style="border-left: 1px solid; border-right: 1px solid; text-align: center; font-weight: bold;">
                    <span>35.600</span>
                </td>
            </tr>
            <tr>
                <td style="border-left: 1px solid; font-weight: bold; padding: 2px 5px;" colspan="3">
                    <span>Phí vận chuyển</span>
                </td>
                <td style="border-left: 1px solid; border-right: 1px solid; text-align: center; font-weight: bold;">
                    <span>0</span>
                </td>
            </tr>
            <tr>
                <td style="border-left: 1px solid; border-bottom: 1px solid; font-weight: bold; padding: 2px 5px;" colspan="3">
                    <span style="color: red;">Tổng thành tiền</span>
                </td>
                <td style="border-left: 1px solid; border-right: 1px solid; border-bottom: 1px solid; text-align: center; font-weight: bold;">
                    <span style="color: red;">391.600</span>
                </td>
            </tr>
            
        </table>
    </div>
    </div>
    <div id="global-footer"></div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        $('#global-header').load('header.html');
        $('#global-footer').load('footer.html');
    </script>
  </body>
</html>