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
	<c:url value="/admin/product/update" var="update"></c:url>
	<form role="form" action="${update}" method="post"
		enctype="multipart/form-data">
		<input name="_id" value="${product._id }" hidden="">
		<div class="form-group">
			<label>Tên sản phẩm:</label> <input class="form-control"
				placeholder="nhập tên product" value="${product.name }" name="name" />
		</div>
		<div class="form-group">
			<label>Mô tả:</label> <textarea rows="5" cols="25" class="form-control"
				 name="description">${product.description}
				 </textarea>
		</div>
		<div class="form-group">
			<label>Giá bán:</label><input type="number" class="form-control"
				placeholder="nhập giá bán" name="price" value="${product.price }" />
		</div>
		<div class="form-group">
			<label>Giá khuyến mãi:</label><input type="number" class="form-control"
				placeholder="nhập giá khuyến mãi" name="promotionalPrice" value="${product.promotionalPrice }"/>
		</div>
		<div class="form-group">
			<label>Số lượng:</label><input type="number" class="form-control"
				placeholder="nhập số lượng" name="quantity" value="${product.quantity }"/>
		</div>
		<div class="form-check form-check-inline">

			<label for="isActive">isActive:</label> 
			
			<input id="isActiveon" class="form-check-input" type="radio" name="isActive"
				${product.isActive?'checked':''} value="true"> 
			<label for="isActiveon" class="form-check-label">Có</label> 
			
			<input id="isActiveoff" class="form-check-input" type="radio" name="isActive"
				${!product.isActive?'checked':''} value="false"> 
			<label for="isActiveoff" class="form-check-label">Không</label>

		</div>
		<div class="form-check form-check-inline">

			<label for="isSelling">isSelling:</label> 
			
			<input id="isSellingon" class="form-check-input" type="radio" name="isSelling"
				${product.isSelling?'checked':''} value="true"> 
			<label for="isSellingon" class="form-check-label">Có</label> 
			
			<input id="isSellingoff" class="form-check-input" type="radio" name="isSelling"
				${!product.isSelling?'checked':''} value="false"> 
			<label for="isSellingoff" class="form-check-label">Không</label>

		</div>
		<div style="display:flex; justify-content: center;">
		<c:forEach items="${listImages}" var="item" varStatus="STT">
				<c:url value="/image?fname=${item}" var="imgUrl"></c:url>
				<img style="margin-left:10px; margin-right:10px" 
				height="200" width="200" src="${imgUrl}" />
		</c:forEach>
	</div>
		<div class="form-group">
			<label>Ảnh đại diện (Có thể chọn nhiều):</label> 
			<input type="file" name="icon" multiple/>
		</div>
		<div class="form-group">
			<label>Mã category:</label><input class="form-control"
				placeholder="nhập mã category" name="categoryId" value="${product.categoryId }"/>
		</div>
		<div class="form-group">
			<label>Mã cửa hàng:</label><input class="form-control"
				placeholder="nhập mã store" name="storeId" value="${product.storeId }"/>
		</div>
		<div class="form-group">
			<label>Rating:</label><input class="form-control"
				placeholder="nhập rating" name="rating" value="${product.rating }"/>
		</div>
		
		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-primary">Reset</button>
	</form>
</body>
</html>