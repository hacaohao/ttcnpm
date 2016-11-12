<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
</div>
<div class="modal-body">
    <div class="panel-heading">
        <div class="panel-title text-center">
            <h1 class="dangkititle">Tạo mới tài khoản</h1>
            <p class="text-center text-danger" id="error"></p>
        </div>
    </div>
    <div class="main-login main-center">      
        <form class="form-horizontal" method="post" action="" id="signupform">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-6 margin-right">
                    <div class="form-group">
                        <label for="name" class="cols-md-2 control-label">Họ tên</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Nhập họ và tên" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm" class="cols-md-2 control-label">Số điện thoại</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-mobile fa-lg" aria-hidden="true"></i></span>
                                <input type="phone" class="form-control" name="contactnumber" id="contactnumber"  placeholder="Nhập số điện thoại" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm" class="cols-md-2 control-label">Ngày sinh</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-calendar fa-lg" aria-hidden="true"></i></span>
                                <input type="date" class="form-control" name="bdate" id="bdate"  placeholder="Nhập ngày sinh" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <label for="confirm" class="margin-right">Giới tính</label>
                            <input type="radio" name='gender' value="true" checked> Nam
                            <input type="radio" name='gender' value="false"> Nữ
                        </div>
                    </div>

                </div>
                <div class="col-md-5 col-sm-5 col-xs-5 ">
                    <div class="form-group">
                        <label for="email" class="cols-md-2 control-label">Email</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="email" class="form-control" name="email" id="email"  placeholder="Nhập địa chỉ mail" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="cols-md-2 control-label">Mật khẩu</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="password" id="password"  placeholder="Nhập mật khẩu" required/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="confirm" class="cols-md-2 control-label">Xác nhận mật khẩu</label>
                        <div class="cols-md-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Nhập xác nhận mật khẩu" required/>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="form-group ">
                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Đăng kí</button>
            </div>
        </form>
    </div>
</div>
<script>
    jQuery(document).ready(function($) {
        $("#signupform").submit(function(e){
            event.preventDefault();
            validateByAjax();
        });
    });
    
    function validateByAjax(){
        $.ajax({
            type : "POST",
            url : "authentication/signup",
            dataType : "text",
            mimeType:"text/html; charset=UTF-8",
            data : {
                name : $("#name").val(),
                contactnumber : $("#contactnumber").val(),
                bdate : $("#bdate").val(),
                email : $("#email").val(),
                password : $("#password").val(),
                confirm : $("#confirm").val(),
                sex : $('input[name=gender]:checked', '#signupform').val()
            },
            timeout : 100000,
            success : function(data) {
                if(data == "Đăng ký thành công, vui lòng kiểm tra mail để kiểm tra thông tin."){
                    $('#error').text(data); 
                    setInterval(function(){ location.reload(); }, 3000);
                }else{
                     $('#error').text(data);
                }                                
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
</script>