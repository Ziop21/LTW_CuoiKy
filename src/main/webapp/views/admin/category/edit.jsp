<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit category</title>
</head>
<body>
	<c:url value="/admin/category/update" var="update"></c:url>
	<form role="form" action="${update}" method="post"
		enctype="multipart/form-data">
		<input name="_id" value="${category._id }" hidden="">
		<div class="form-group">
			<label>Tên:</label> <input type="text" class="form-control"
				value="${category.name }" name="name" />
		</div>
		<div class="form-group">
			<label>Mã category cha:</label> <input type="text"
				class="form-control" value="${category.categoryId == 0 ? '': cate.categoryId}"
				name="categoryId" />
		</div>
		<div class="form-group">
			<c:url value="/image?fname=${category.image}" var="imgUrl"></c:url>
			<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
			<label>Ảnh đại diện:</label> <input type="file" name="icon"
				value="${imgUrl}" />
		</div>
		<div class="form-check form-check-inline">

			<label for="isDeleted">Xóa mềm:</label> 
			
			<input id="isDeletedon" class="form-check-input" type="radio" name="isDeleted"
				${category.isDeleted?'checked':''} value="true"> 
			<label for="isDeletedon" class="form-check-label">Có</label> 
			
			<input id="isDeletedoff" class="form-check-input" type="radio" name="isDeleted"
				${!category.isDeleted?'checked':''} value="false"> 
			<label for="isDeletedoff" class="form-check-label">Không</label>

		</div>
		
		
		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-primary">Reset</button>
	</form>
</body>
</html>