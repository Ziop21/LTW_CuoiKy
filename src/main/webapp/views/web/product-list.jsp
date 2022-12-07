<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${productListNew}" var="proList">
	<img height="250" width="300"
		src="<c:url value="/image?fname=${proList.images}"/>"
		class="img-responsive" alt="${proList.productName }">
	<a
		href="<c:url value="/product/detail?productid=${proList.productId }"/>">
		${proList.productName }</a>
</c:forEach>
<div class="col-md-8 col-sm-8">
	<ul class="pagination pull-right">
		<c:if test="${tag>1}">
			<li><a
				href="${pageContext.request.contextPath }/product/list?index=${tag-1}&categoryid=0&sellerid=0">&laquo;</a></li>
		</c:if>
		<c:forEach begin="1" end="${endP}" var="i">
			<li class='${tag==i?"active":"" }'><a
				href="${pageContext.request.contextPath}/product/list?index=${i}">${i}</a></li>
		</c:forEach>
		<c:if test="${tag<endP}">
			<li><a
				href="${pageContext.request.contextPath}/product/list?index=${tag+1}">&raquo;</a></li>
		</c:if>
	</ul>
</div>