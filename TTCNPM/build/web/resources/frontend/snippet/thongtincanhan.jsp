<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<section class="main-content">
    <div class="container">
        <div class="row">
            <div> <!-- main frame-->
                <div class="panel panel-tittle">

                    <!-- forget password body-->
                    <div class="panel-body">
                        <!-- row1-->
                        <div class="row display-info">
                            <div class="col-md-4 avatar-frame">
                                <div class="avatar">
                                    <div class="col-md-12"></div>
                                </div>
                                <div class="smallrow under-avatar-frame">
                                    <div class="underAvatar">
                                        <label class="text-under">${sessionScope.user.member.code}</label>
                                    </div>
                                    <div class="underAvatar jewel">
                                    </div>
                                    <div class="underAvatar">
                                        <label class="text-under">${sessionScope.user.member.totalPoint}</label>
                                    </div>
                                    <div class="clear">
                                    </div>
                                </div>
                            </div>

                            <!-- col2 row 1 -->
                            <div class="col-md-7 col-md-offset-1">
                                <div class="row">
                                    <table>
                                        <tr>
                                            <td>
                                                <label class="infomation">Họ và tên:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">${sessionScope.user.member.name}</label>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <label class="infomation">Giới tính:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">${sessionScope.user.member.sex?"Nam":"Nữ"}</label>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <label class="infomation">Ngày sinh:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">${sessionScope.user.member.stringDoB}</label>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <label class="infomation">Email:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">${sessionScope.user.email}</label>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <label class="infomation">Số điện thoại:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">${sessionScope.user.member.phone}</label>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <label class="infomation">Mật khẩu:</label>
                                            </td>
                                            <td>
                                                <label class="infomation">Cập nhật ngày ${sessionScope.user.updatedPasswordAt}</label>
                                            </td>
                                        </tr>
                                    </table>
                                </div>

                                <!-- change-->
                                <div class="row">
                                    <button type="submit" class="btn btn-primary btn-change">Thay đổi</button>
                                </div>
                            </div>
                        </div> 

                        <!-- change form-->
                        <div class="row form-change">
                            <div>
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-3 col-md-offset-1">
                                            <label class="text-info">Họ và tên</label>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="text-info-frame">
                                                <input type="text" class="form-control" id="name-info" value="${sessionScope.user.member.name}" disabled="True" />
                                            </div> 
                                        </div>
                                        <div class="col-md-3">
                                            <button type="submit" class="btn btn-link" id="name-change" class="linkClick">chỉnh sửa</button>
                                        </div>             
                                    </div>
                                </div> 

                                <!-- under change-->
                                <form:form action="user/updateInfoMember" method="post" commandName="member">
                                     <div class="smallrow" id="name-change-under">
                                        <div class="form-group col-md-8 col-md-offset-3 under-frame ">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <label>Nhập họ tên của bạn </label><form:input path="name" cssClass="form-control" id="name-under-info" />
                                                </div> 
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12 btn-under">
                                                    <button type="submit" class="btn btn-primary ">Lưu thay đổi</button>
                                                    <button type="reset" class="btn btn-primary ">Hủy</button>
                                                </div>
                                            </div> 
                                        </div>
                                    </div> 
                                </form:form>
                                
                                <!--password-->
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-3 col-md-offset-1">
                                            <label class="text-info">Số điện thoại</label>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="text-info-frame">
                                                <input type="phone" class="form-control" id="pass-info" name="phone" value="${sessionScope.user.member.phone}" disabled="True" />
                                            </div> 
                                        </div>
                                        <div class="col-md-3">
                                            <button type="submit" class="btn btn-link" id="phone-change" class="linkClick">chỉnh sửa</button>
                                        </div>             
                                    </div>

                                </div> 

                                <!-- under change-->
                                <form action="user/updateInfoMember" method="post" id="member">
                                    <div class="smallrow" id="phone-change-under">
                                        <div class="form-group col-md-8 col-md-offset-3 under-frame ">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <label>Nhập số điện thoại của bạn </label><input type="phone" class="form-control" id="pass-under-info" name="phone" />
                                                </div> 
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12 btn-under">
                                                    <button type="submit" class="btn btn-primary ">Lưu thay đổi</button>
                                                    <button type="reset" class="btn btn-primary ">Hủy</button>
                                                </div>
                                            </div> 
                                        </div>
                                    </div> 
                                </form>
                                
                                <!--password-->
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-3 col-md-offset-1">
                                            <label class="text-info">Password</label>
                                        </div>
                                        <div class="col-md-5">
                                            <div class="text-info-frame">
                                                <input type="password" class="form-control" id="pass-info" value="${sessionScope.user.password}" disabled="True" />
                                            </div> 
                                        </div>
                                        <div class="col-md-3">
                                            <button type="submit" class="btn btn-link" id="pword-change" class="linkClick">chỉnh sửa</button>
                                        </div>             
                                    </div>

                                </div> 

                                <!-- under change-->
                                <form:form action="user/updateInfoUser" method="post" commandName="user">
                                    <div class="smallrow" id="pword-change-under">
                                        <div class="form-group col-md-8 col-md-offset-3 under-frame ">
                                            <div class="row">
                                                <div class="col-md-8">
                                                    <label>Nhập mật khẩu của bạn</label><form:password cssClass="form-control" path="password" id="pass-under-info"/>
                                                </div> 
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12 btn-under">
                                                    <button type="submit" class="btn btn-primary ">Lưu thay đổi</button>
                                                    <button type="reset" class="btn btn-primary ">Hủy</button>
                                                </div>
                                            </div> 
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>       
                </div>
            </div>
        </div>
    </div> <!-- /.main row-->
</div> <!-- /.container-->
</section> <!-- /.main-->

<!--Script hide and show-->
<script>

    //khoitao
    $(".form-change").hide();
    $("#name-change-under").hide();
    $("#add-change-under").hide();
    $("#email-change-under").hide();
    $("#pword-change-under").hide();
    $("#phone-change-under").hide();
    
    //
    $(".btn-change").click(function () {
        $(".form-change").toggle();
    });
    //name
    $("#name-change").click(function () {
        $("#name-change-under").toggle();
    });
    //add
    $("#add-change").click(function () {
        $("#add-change-under").toggle();
    });
    //email
    $("#email-change").click(function () {
        $("#email-change-under").toggle();
    });
    //password
    $("#pword-change").click(function () {
        $("#pword-change-under").toggle();
    });
    
    $("#phone-change").click(function () {
        $("#phone-change-under").toggle();
    });
</script>
