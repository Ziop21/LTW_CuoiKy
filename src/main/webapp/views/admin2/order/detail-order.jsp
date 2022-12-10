<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<div class="content">
	<div class="animated fadeIn">

		<div class="row">
			<div class="col-lg-6 mx-auto">
				<div class="card">
					<div class="card-header">
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center">Chi tiết đơn hàng</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">ID
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order._id }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">UserId
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.userId }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">CartId
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.cartId }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Address
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.address }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Phone
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.phone }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Status
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.status }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">AmountFromUser
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.amountFromUser }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">CreatedAt
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.createdAt }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">UpdateAt
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${order.updatedAt }">
									</div>
								</form>
							</div>
						</div>

					</div>
				</div>
				<!-- .card -->
			</div>
		</div>
	</div>
</div>