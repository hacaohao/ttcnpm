<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>thong tin ca nhan</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/style.css">
  
  </head>
<body>
<div id="global-header"></div>
<section class="main-content">
 <div class="container">
  <div class="row">
    <h3 id="history-title">Lịch sử đơn hàng </h3>
  </div>
  
  <div class="table-responsive">
  <table class="table" id="history-table">
    <thead>
      <tr>
        <th class="h_align">Số thứ tự</th>
        <th class="h_align">Mã đơn hàng</th>
        <th class="h_align">Ngày giao hàng</th>
        <th class="h_align">Thành tiền</th>
        <th class="h_align">Trạng thái</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="h_align">1</td>
        <td class="h_align">AKC22433100</td>
        <td class="h_align">11-10-2016</td>
        <td class="h_align">213.000</td>
        <td class="h_align">Đã duyệt</td>
        <td class="h_align">
            <a href='ttdh.html' class="btn btn-link" id="history_show">Xem</a>
        </td>
      </tr>
      
      <tr>
        <td class="h_align">2</td>
        <td class="h_align">AKC22433102</td>
        <td class="h_align">15-10-2016</td>
        <td class="h_align">56.000</td>
        <td class="h_align">Chưa duyệt</td>
        <td class="h_align">
            <a href='ttdh.html' class="btn btn-link" id="history_show">Xem</a>
            <button type="submit" class="btn btn-link" id="history_cancel">Hủy</button>
        </td>
      </tr>
      
      <tr>
        <td class="h_align">3</td>
        <td class="h_align">AKC22433104</td>
        <td class="h_align">20-10-2016</td>
        <td class="h_align">136.000</td>
        <td class="h_align">Chưa duyệt</td>
        <td class="h_align">
            <a href='ttdh.html' class="btn btn-link" id="history_show">Xem</a>
            <button type="submit" class="btn btn-link" id="history_cancel">Hủy</button>
        </td>
      </tr>
      
      <tr>
        <td class="h_align">4</td>
        <td class="h_align">AKC22433108</td>
        <td class="h_align">25-10-2016</td>
        <td class="h_align">196.500</td>
        <td class="h_align">Chưa duyệt</td>
        <td class="h_align">
            <a href='ttdh.html' class="btn btn-link" id="history_show">Xem</a>
            <button type="submit" class="btn btn-link" id="history_cancel">Hủy</button>
        </td>
      </tr>
      
      <tr>
        <td class="h_align">5</td>
        <td class="h_align">AKC22433111</td>
        <td class="h_align">28-10-2016</td>
        <td class="h_align">136.000</td>
        <td class="h_align">Chưa duyệt</td>
        <td class="h_align">
            <a href='ttdh.html' class="btn btn-link" id="history_show">Xem</a>
            <button type="submit" class="btn btn-link" id="history_cancel">Hủy</button>
        </td>
      </tr>
      
    </tbody>
  </table>
  <div class="smallrow">
            <div class="underAvatar">
                <label class="text-under">123456</label>
            </div>
            <div class="underAvatar jewel">
            </div>
            <div class="underAvatar">
                <label class="text-under">200</label>
            </div>
            <div class="clear">
            </div>
</div>
  </div>
 </div>
</section>
<div id="global-footer"></div>
  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script>
      $(function(){
        $('#global-header').load('header.html');
        $('#global-footer').load('footer.html');
      });
    </script>
</body>
</html>

