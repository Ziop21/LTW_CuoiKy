<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="list-group margin-bottom-25 sidebar-menu">
	<c:forEach items="${categoryList}" var="cateList">
		<li class="list-group-item clearfix">
		<% // <a	href="<c:url value="/product/list?categoryid=${cateList.cateid}"/>">%>
		<a	href="<c:url value="/product/loadAjax"/>">
				<img src="<c:url value="/image?fname=${cateList.images}"/>"
				class="img-circle" width="22px"> ${cateList.catename}
		</a></li>
	</c:forEach>
</ul>
Hiển thị tên sản phẩm trong đối tượng Product thông qua biến product
được truyền từ Controller
<h1>${product.productName}</h1>