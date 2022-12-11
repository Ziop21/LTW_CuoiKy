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
									<h3 class="text-center">Chi tiet cửa hàng</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="_id" class="control-label mb-1">ID:${store._id }
											</label>
									</div>
									<div class="form-group">
										<label for="name" class="control-label mb-1">Name:${store.name }
											</label> 
									</div>
									<div class="form-group">
										<label for="bio" class="control-label mb-1">Bio:${store.bio }
											</label>
									</div>
									<div class="form-group">
										<label for="slug" class="control-label mb-1">Slug:${store.slug }
											</label> 
									<div class="form-group">
										<label for="ownerId" class="control-label mb-1">Owner:${store.ownerId }
											</label>
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Staff
											</label> 
									</div>
									<div class="form-group">
										<label for="isActive" class="control-label mb-1">Active:${store.isActive }
											</label> 
									</div>
									<div class="form-group">
										<label for="isOpen" class="control-label mb-1">Open:${store.isOpen }
											</label> 
									</div>
									<div class="form-group">
										<label for="avatar" class="control-label mb-1">Avatar:
											</label> <img alt="" src="${store.avatar }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Cover
											</label> 
											<img src="${store.cover }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Feature Image
											</label>
											<img alt="" src="">
									</div>
									<div class="form-group">
										<label for="createdAt" class="control-label mb-1">Created At:${store.createdAt }
											</label>
									</div>
									<div class="form-group">
										<label for="updatedAt" class="control-label mb-1">Updated At :${store.updatedAt }
											</label> 
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