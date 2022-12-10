<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách</title>
</head>
<body>
	<h1>Danh sách hình ảnh sản phẩm</h1>
	<div style="display:flex; justify-content: center;">
		<c:forEach items="${listImages}" var="item" varStatus="STT">
				<c:url value="/image?fname=${item}" var="imgUrl"></c:url>
				<img style="margin-left:10px; margin-right:10px" 
				height="200" width="200" src="${imgUrl}" />
		</c:forEach>
	</div>


</body>
</html>