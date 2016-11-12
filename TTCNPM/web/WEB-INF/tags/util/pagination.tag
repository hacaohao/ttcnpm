<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="thispage"
             type="pagination.Page" required="true"
             rtexprvalue="true" description="The current Page"%>

<c:set var="currentPage" value="${thispage.currentIndex}" />
<c:set var="lastPageDisplay" value="${thispage.endIndex}" />
<c:set var="baseUrl" value="${thispage.baseUrl}" />
<c:set var="lastPage" value="${thispage.lastPageIndex}" />

<ul class="pagination">
    <spring:url value="${baseUrl}" var="first">
        <spring:param name="page" value="1" />
    </spring:url>
    <li><a href="${first}">First</a></li>

    <spring:url value="${baseUrl}" var="prev">
        <spring:param name="page" value="${currentPage - 1}" />
    </spring:url>
    <c:if test="${currentPage eq 1}">
        <c:set var="disabledPrev" value="disabled" />
    </c:if>
    <li class="${disabledPrev}"><a href="${prev}" class="btn ${disabledPrev}">Prev</a></li>  
    
    <c:if test="${currentPage == lastPage}">
        <c:if test="${currentPage - 4 >= 1}">
            <spring:url value="${baseUrl}" var="prevFourPage">
                <spring:param name="page" value="${currentPage - 4}" />
            </spring:url>
            <li><a href="${prevFourPage}">${currentPage - 4}</a></li>
        </c:if>
    </c:if> 
    
    <c:if test="${currentPage == lastPage}">
        <c:if test="${currentPage - 3 >= 1}">
            <spring:url value="${baseUrl}" var="prevThreePage">
                <spring:param name="page" value="${currentPage - 3}" />
            </spring:url>
            <li><a href="${prevThreePage}">${currentPage - 3}</a></li>
        </c:if>
    </c:if> 

    <c:if test="${currentPage - 2 >= 1}">
        <spring:url value="${baseUrl}" var="prevTwoPage">
            <spring:param name="page" value="${currentPage - 2}" />
        </spring:url>
        <li><a href="${prevTwoPage}">${currentPage - 2}</a></li>
    </c:if>
        
    <c:if test="${currentPage - 1 >= 1}">
        <spring:url value="${baseUrl}" var="prevPage">
            <spring:param name="page" value="${currentPage - 1}" />
        </spring:url>
        <li><a href="${prevPage}">${currentPage - 1}</a></li>
    </c:if>

        <spring:url value="${baseUrl}" var="currentPageLink">
            <spring:param name="page" value="${currentPage}" />
        </spring:url>
        <li class="active"><a href="${currentPageLink}">${currentPage}</a></li>
        
    <c:if test="${currentPage + 1 <= lastPage}">
        <spring:url value="${baseUrl}" var="nextPage">
            <spring:param name="page" value="${currentPage + 1}" />
        </spring:url>
        <li><a href="${nextPage}">${currentPage + 1}</a></li>
    </c:if>
        
    <c:if test="${currentPage + 2 <= lastPage}">
        <spring:url value="${baseUrl}" var="nextTwoPage">
            <spring:param name="page" value="${currentPage + 2}" />
        </spring:url>
        <li><a href="${nextTwoPage}">${currentPage + 2}</a></li>
    </c:if>
        
    <c:if test="${currentPage == 1}">
        <c:if test="${currentPage + 3 <= lastPage}">
            <spring:url value="${baseUrl}" var="nextThreePage">
                <spring:param name="page" value="${currentPage + 3}" />
            </spring:url>
            <li><a href="${nextThreePage}">${currentPage + 3}</a></li>
        </c:if>
    </c:if>   
            
    <c:if test="${currentPage == 1}">
        <c:if test="${currentPage + 4 <= lastPage}">
            <spring:url value="${baseUrl}" var="nextFourPage">
                <spring:param name="page" value="${currentPage + 4}" />
            </spring:url>
            <li><a href="${nextFourPage}">${currentPage + 4}</a></li>
        </c:if>
    </c:if> 
    
    <spring:url value="${baseUrl}" var="next">
        <spring:param name="page" value="${currentPage + 1}" />
    </spring:url>
    <c:if test="${currentPage eq lastPage}">
        <c:set var="disabledNext" value="disabled" />
    </c:if>
    <li class="${disabledNext}"><a href="${next}" class="btn ${disabledNext}">Next</a></li>    

    <spring:url value="${baseUrl}" var="last">
        <spring:param name="page" value="${lastPage}" />
    </spring:url>
    <li><a href="${last}">Last</a></li>
</ul>