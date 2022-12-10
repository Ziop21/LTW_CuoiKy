<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col-md-7">
			<h2>Điền thông tin thanh toán</h2>
			<c:url value="/order/checkout" var="checkout"></c:url>
			<form action="${checkout }" method="post">
				<div class="form-group">
					<label for="address">Địa chỉ</label> <input type="text"
						class="form-control" id="address" name="address"
						aria-describedby="address" placeholder="Nhap dia chi">
				</div>
				<div class="form-group">
					<label for="phone">Số điện thoại </label> <input type="text"
						class="form-control" id="phone" name="phone"
						placeholder="Password">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="traTienMat"
						name="traTienMat" value="true"> <label
						class="form-check-label" for="traTienMat">Trả tiền mặt</label>
				</div>
				<button type="submit" class="btn btn-primary">Đặt hàng</button>
			</form>
		</div>
		<div class="row">
			<div class="col-md-auto">
				<h2>Thông tin đơn hàng</h2>
				<ul style="list-style: none;">
					<li>
					<span>Sản phẩm:</span>
						<ul>
							<c:forEach items="${cartItemList}" var="cartItem">
								<c:forEach items="${products}" var="product">
									<c:if test="${product._id == cartItem.productId}">
										<li><span>${cartItem.count } x ${product.name }</span> <span>x ${product.price }</span></li>
									</c:if>
								</c:forEach>
							</c:forEach>
						</ul>
					</li>
					<li><span>Tong thanh toan</span> <span>${thanhtien }</span></li>
				</ul>
			</div>
		</div>
	</div>
</div>