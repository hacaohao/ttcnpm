<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="stack1" class="modal fade" tabindex="-1" data-focus-on="input:first" style="display: none">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button> 
            </div>
            <div class="modal-body-login">
                <div class="panel panel-tittle">

                    <!-- login tittle-->
                    <div class="panel-heading text-center">
                        <h1 class="dangnhaptitle">Đăng nhập </h1>
                        <p class="text-center text-danger" id="errorLogin"></p>
                    </div>

                    <!-- login body-->
                    <div class="panel-body" id="login_main_frame">
                        <form action="" method="POST" id="signinform">

                            <!-- username-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3 col-md-offset-1">
                                        <label for="email" class="control-label">Địa chỉ email</label>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="email" id="email"  placeholder="Nhập địa chỉ email"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- password-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3 col-md-offset-1">
                                        <label for="name" class="control-label">Mật khẩu</label>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="password" class="form-control" name="password" id="password"  placeholder="Nhập mật khẩu"/>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <!-- login status-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8 col-md-offset-4">
                                        <label class="checkbox-inline"><input type="checkbox" value="">Lưu trạng thái đăng nhập</label>
                                    </div>
                                </div>
                            </div>

                            <!-- login button and forget password-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8 col-md-offset-4">
                                        <button type="submit" class="btn btn-success btn-login"> Đăng nhập</button>    
                                        <a style="outline: none;" class="btn btn-link" data-toggle="modal" href="#stack2">Quên mật khẩu</a>
                                    </div>
                                </div>
                            </div>

                            <!-- login with facebook and G++ -->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5 col-md-offset-4">
                                        <div class="smallrow">
                                            <button type="submit" class="btn btn-primary btn-fb">Đăng nhập bằng facebook</button>    
                                        </div>
                                        <div class="smallrow">
                                            <button type="submit" class="btn btn-primary btn-gg">Đăng nhập bằng Google+</button>  
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>

                </div>
            </div> <!-- /.container-->
        </div>
    </div>
</div>

<div id="stack2" class="modal fade" tabindex="-1" data-focus-on="input:first" style="display: none">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div id="signin" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                    </div>
                </div>
            </div>
            <div class="modal-body-forget-pass">
                <div class="panel panel-tittle">

                    <!-- forget password tittle-->
                    <div class="panel-heading text-center">
                        <h1>Quên mật khẩu</h1>
                        <p class="text-center text-danger" id="errorForget"></p>
                    </div>

                    <!-- forget password body-->
                    <div class="panel-body">
                        <form action="" method="POST" id="forget">

                            <!-- email input-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-3 col-md-offset-1">
                                        <label for="email" class="control-label">Địa chỉ email</label>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="email" id="emailForget"  placeholder="Nhập địa chỉ email"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- send requirement-->
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-8 col-md-offset-4">
                                        <button type="submit" class="btn btn-success btn-fg">Gửi yêu cầu</button>
                                        <button type="button" data-dismiss="modal" class="btn btn-success">Đóng</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div> <!-- /.container-->
        </div>
    </div>
</div>
<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $("#signinform").submit(function (e) {
            event.preventDefault();
            loginByAjax();
        });

        $("#forget").submit(function (e) {
            event.preventDefault();
            forgetByAjax();
        });
    });

    function loginByAjax() {
        $.ajax({
            type: "POST",
            url: "authentication/signin",
            dataType: "text",
            mimeType: "text/html; charset=UTF-8",
            data: {
                email: $("#email").val(),
                password: $("#password").val()
            },
            timeout: 100000,
            success: function (data) {
                if (data == "Đăng nhập thành công.") {
                    $('#errorLogin').text(data);
                    setInterval(function () {
                        location.reload();
                    }, 3000);
                } else {
                    $('#errorLogin').text(data);
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    }

    function forgetByAjax() {
        $.ajax({
            type: "POST",
            url: "authentication/forget",
            dataType: "text",
            mimeType: "text/html; charset=UTF-8",
            data: {
                email: $("#emailForget").val()
            },
            timeout: 100000,
            success: function (data) {
                if (data == "Password mới đã được gửi vào email.") {
                    $('#errorForget').text(data);
                    setInterval(function () {
                        location.reload();
                    }, 3000);
                } else {
                    $('#errorForget').text(data);
                }
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    }
</script>
