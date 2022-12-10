<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
<h2>Giỏ hàng</h2>
	<div class="row">
		<div class="col-md-12">
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>STT</th>
						<th>Ảnh</th>
						<th>Tên sản phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng</th>
						<th>Thành tiền</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cartItemList}" var="cartitem" varStatus="STT">
						<tr>
							<td>${STT.index+1}</td>
							<c:forEach items="${products }" var="product">
								<c:if test="${product._id == cartitem.productId}">
									<c:url value="/image?fname=${product.image }" var="imgUrl"></c:url>
									<td><img height="150" width="200" src="${imgUrl}" /></td>
								</c:if>
							</c:forEach>
							<c:forEach items="${products }" var="product">
								<c:if test="${product._id == cartitem.productId}">
									<td>${product.name }</td>
								</c:if>
							</c:forEach>
							<c:forEach items="${products }" var="product">
								<c:if test="${product._id == cartitem.productId}">
									<td>${product.price }</td>
								</c:if>
							</c:forEach>
							<td>${cartitem.count }</td>
							<c:forEach items="${products }" var="product">
								<c:if test="${product._id == cartitem.productId}">
									<td>${product.price*cartitem.count}</td>
								</c:if>
							</c:forEach>
							<td><a
								href="<c:url value='/cartitem/edit?id=${cartitem._id }'/>"
								class="center">Sửa</a> | <a
								href="<c:url value='/cartitem/delete?id=${cartitem._id }'/>"
								class="center">Xóa</a></td>
						</tr>
					</c:forEach>
			</table>
			<a href="<c:url value='/order/checkout'/>">Đặt hàng</a>
			<table id="example" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>STT</th>
						<th>Tên sản phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng đã bán</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${allproducts}" var="productitem" varStatus="STT">
						<tr>
							<td>${STT.index+1}</td>
							<td>${productitem.name }</td>
							<td>${productitem.price }</td>
							<td>${productitem.sold }</td>
							<td><a
								href="<c:url value='/cartitem/add?productId=${productitem._id }'/>"
								class="center">Thêm vào giỏ</a>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
