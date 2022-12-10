<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
</head>
<body>
	<form role="form" action="create" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>Tên sản phẩm:</label> <input class="form-control"
				placeholder="nhập tên product" name="name" />
		</div>
		<div class="form-group">
			<label>Mô tả:</label> <textarea rows="5" cols="25" class="form-control"
				 name="decription">
				 </textarea>
		</div>
		<div class="form-group">
			<label>Giá bán:</label><input type="number" class="form-control"
				placeholder="nhập giá bán" name="price" />
		</div>
		<div class="form-group">
			<label>Giá khuyến mãi:</label><input type="number" class="form-control"
				placeholder="nhập giá khuyến mãi" name="promotionalPrice" />
		</div>
		<div class="form-group">
			<label>Số lượng:</label><input type="number" class="form-control"
				placeholder="nhập số lượng" name="quantity" />
		</div>
		<div class="form-group">
			<label>Mã category:</label><input class="form-control"
				placeholder="nhập mã category" name="categoryId" />
		</div>
		<div class="form-group">
			<label>Mã cửa hàng:</label><input class="form-control"
				placeholder="nhập mã store" name="storeId" />
		</div>
		<div class="form-group">
			<label>Ảnh đại diện (Có thể chọn nhiều):</label> 
			<input type="file" name="icon" multiple/>
		</div>
		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
</body>
</html>