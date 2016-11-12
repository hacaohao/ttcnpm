<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript"> 
    jQuery(document).ready(function($) {
        $("#forget").submit(function(e){
            event.preventDefault();
            forgetByAjax();
        });
    });
    
    function forgetByAjax(){
        $.ajax({
            type : "POST",
            url : "authentication/forget",
            dataType : "text",
            mimeType:"text/html; charset=UTF-8",
            data : {
                email : $("#email").val()
            },
            timeout : 100000,
            success : function(data) {   
                if(data == "Password mới đã được gửi vào email."){
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
    
//    $("#backSignIn").click(function(e){
//        $('#test').load('<c:url value="/resources/frontend/snippet/dangnhap.jsp" />', function () {
//            $('.modal-body-forget-pass').html($('.modal-body-login').html());
//            $('#test').html('');
//            $('.modal-body-forget-pass').removeClass('modal-body-forget-pass').addClass('modal-body-login');
//        });
//    });
</script>
