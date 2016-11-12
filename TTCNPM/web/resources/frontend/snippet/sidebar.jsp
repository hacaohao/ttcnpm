<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-md-2 col-sm-3 col-xs-12 margin-bottom no-padding-left no-padding-right">
    <div class="left-content">
        <div class="title">
            <h4>Danh mục sách</h4>
        </div>
        <div class="categories">
            <ul>
                <c:forEach var="category" items="${categories}">
                    <spring:url value="category" var="first">
                        <spring:param name="page" value="1" />
                        <spring:param name="id" value="${category.id}" />
                    </spring:url>
                    <li><a href="${first}">${category.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div> <!-- end left-content -->
</div> 
