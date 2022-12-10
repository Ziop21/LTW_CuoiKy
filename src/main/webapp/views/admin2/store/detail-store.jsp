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
									<h3 class="text-center">Cập nhật cửa hàng</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="_id" class="control-label mb-1">ID
											</label> <input id="_id" name="_id" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store._id }">
									</div>
									<div class="form-group">
										<label for="name" class="control-label mb-1">Name
											</label> <input id="name" name="name" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.name }">
									</div>
									<div class="form-group">
										<label for="bio" class="control-label mb-1">Bio
											</label> <input id="bio" name="bio" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.bio }">
									</div>
									<div class="form-group">
										<label for="slug" class="control-label mb-1">Slug
											</label> <input id="slug" name="slug" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.slug }">
									</div>
									<div class="form-group">
										<label for="ownerId" class="control-label mb-1">Owner
											</label> <input id="ownerId" name="ownerId" type="text"
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
										<label for="isActive" class="control-label mb-1">Active
											</label> <input id="isActive" name="isActive" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.isActive }">
									</div>
									<div class="form-group">
										<label for="isOpen" class="control-label mb-1">Open
											</label> <input id="isOpen" name="isOpen" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.isOpen }">
									</div>
									<div class="form-group">
										<label for="avatar" class="control-label mb-1">Avatar
											</label> <input id="avatar" name="avatar" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.avatar }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Cover
											</label> <input id="cc-payment" name="cover" type="text"
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
										<label for="createdAt" class="control-label mb-1">Created At
											</label> <input id="createdAt" name="createdAt" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false" value="${store.createdAt }">
									</div>
									<div class="form-group">
										<label for="updatedAt" class="control-label mb-1">Updated At
											</label> <input id="updatedAt" name="updatedAt" type="text"
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