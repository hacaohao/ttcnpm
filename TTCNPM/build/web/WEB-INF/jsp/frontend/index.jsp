<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BKBook</title>
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/" />
        <!-- Bootstrap -->
        <link href="<c:url value="/resources/frontend/snippet/css/bootstrap.min.css" />" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/all.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/trangchu.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/thongtinmuahang.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/style.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/lienhe.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/header.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/giohang.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/footer.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/font_Coiny.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/font-awesome.min.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/dmtls.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/dangki.css" />">
        <link rel="stylesheet" href="<c:url value="/resources/frontend/snippet/css/font-awesome.min.css" />"> 
        <link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/frontend/snippet/js/bootstrap.min.js" />"></script>
        <%@include file="/resources/frontend/snippet/header.jsp" %>
        <%@include file="/resources/frontend/snippet/searchbar.jsp" %>
        <jsp:include page="/resources/frontend/snippet/${content}.jsp"/>
        <%@include file="/resources/frontend/snippet/footer.jsp" %>
        
    </body>
</html>
