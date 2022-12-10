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
									<h3 class="text-center">Chi tiết cửa hàng</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">ID
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store._id }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Name
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.name }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Bio
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.bio }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Slug
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.slug }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Owner
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.ownerId }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Staff
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Active
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.isActive }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Open
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.isOpen }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Avatar
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.avatar }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Cover
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.cover }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Feature Image
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Created At
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.createdAt }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Updated At
											</label> <input id="cc-payment" name="cc-payment" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.updatedAt }">
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