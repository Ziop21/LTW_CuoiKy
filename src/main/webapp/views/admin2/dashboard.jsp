<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<!-- Right Panel -->
<div id="right-panel" class="right-panel">
	<p class="SL1" id="SL1">${SL1 }</p>
	<!-- Header-->
	<header id="header" class="header">
		<div class="top-left">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/admin2/dashboard'/>"><img
					src="${URL }images/logo.png" alt="Logo"></a> <a
					class="navbar-brand hidden"
					href="<c:url value='/admin2/dashboard'/>"><img
					src="${URL }/images/logo2.png" alt="Logo"></a> <a id="menuToggle"
					class="menutoggle"><i class="fa fa-bars"></i></a>
			</div>
		</div>
		<div class="top-right">
			<div class="header-menu">
				<span
					style="text-align: center; display: inline-block; margin-top: 14px">Hello
					${email }</span>
				<div class="user-area dropdown float-right inline">
					<a href="#" class="dropdown-toggle active" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <img
						class="user-avatar rounded-circle" src="${URL }images/admin.jpg"
						alt="">
					</a>
					<div class="user-menu dropdown-menu">
						<a class="nav-link" href="#"><i class="fa fa- user"></i>My
							Profile</a> <a class="nav-link" href="<c:url value='/logout'/>"><i
							class="fa fa-power -off"></i>Logout</a>
					</div>
				</div>

			</div>
		</div>
	</header>
	<!-- /#header -->
	<!-- Content -->
	<div class="content">
		<!-- Animated -->
		<div class="animated fadeIn">
			<!-- Widgets  -->
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="card">
						<div class="card-body">
							<div class="stat-widget-five">
								<div class="stat-icon dib flat-color-1">
									<i class="pe-7s-cash"></i>
								</div>
								<div class="stat-content">
									<div class="text-left dib">
										<div class="stat-text">
											$<span class="count">${TongDoanhThuBan }</span>
										</div>
										<div class="stat-heading">Revenue</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-6 col-md-6">
					<div class="card">
						<div class="card-body">
							<div class="stat-widget-five">
								<div class="stat-icon dib flat-color-2">
									<i class="pe-7s-cart"></i>
								</div>
								<div class="stat-content">
									<div class="text-left dib">
										<div class="stat-text">
											<span class="count">${TongSLBan }</span>
										</div>
										<div class="stat-heading">Sales</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<!-- /Widgets -->
			<!--  Traffic  -->
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-body">
							<h4 class="box-title">Traffic</h4>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="card-body">
									<ul>
										<li>Số lượng bán tháng 1: ${SL1 } sản phẩm</li>
										<li>Số lượng bán tháng 2: ${SL2 } sản phẩm</li>
										<li>Số lượng bán tháng 3: ${SL3 } sản phẩm</li>
										<li>Số lượng bán tháng 4: ${SL4 } sản phẩm</li>
										<li>Số lượng bán tháng 5: ${SL5 } sản phẩm</li>
										<li>Số lượng bán tháng 6: ${SL6 } sản phẩm</li>
										<li>Số lượng bán tháng 7: ${SL7 } sản phẩm</li>
										<li>Số lượng bán tháng 8: ${SL8 } sản phẩm</li>
										<li>Số lượng bán tháng 9: ${SL9 } sản phẩm</li>
										<li>Số lượng bán tháng 10: ${SL10 } sản phẩm</li>
										<li>Số lượng bán tháng 11: ${SL11 } sản phẩm</li>
										<li>Số lượng bán tháng 12: ${SL12 } sản phẩm</li>
									</ul>
								</div>
							</div>
							<!-- /# column -->
							<div class="col-lg-6">
								<div class="card-body">
									<ul>
										<li>Doanh thu tháng 1: ${DT1 }</li>
										<li>Doanh thu tháng 2: ${DT2 }</li>
										<li>Doanh thu tháng 3: ${DT3 }</li>
										<li>Doanh thu tháng 4: ${DT4 }</li>
										<li>Doanh thu tháng 5: ${DT5 }</li>
										<li>Doanh thu tháng 6: ${DT6 }</li>
										<li>Doanh thu tháng 7: ${DT7 }</li>
										<li>Doanh thu tháng 8: ${DT8 }</li>
										<li>Doanh thu tháng 9: ${DT9 }</li>
										<li>Doanh thu tháng 10: ${DT10 }</li>
										<li>Doanh thu tháng 11: ${DT11 }</li>
										<li>Doanh thu tháng 12: ${DT12 }</li>
									</ul>
								</div>
								<!-- /.card-body -->
							</div>
						</div>
						<!-- /.row -->
						<div class="card-body"></div>
					</div>
				</div>
				<!-- /# column -->
			</div>
			<!--  /Traffic -->
			<div class="clearfix"></div>
			<!-- Orders -->
			<div class="orders">
				<div class="row">
					<div class="col-xl-8">
						<div class="card">
							<div class="card-body">
								<h4 class="box-title">Orders</h4>
							</div>
							<div class="card-body--">
								<div class="table-stats order-table ov-h">
									<table id="bootstrap-data-table"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>STT</th>
												<th>User</th>
												<th>CartId</th>
												<th>Address</th>
												<th>Phone</th>
												<th>Status</th>
												<th>AmountFromUser</th>
												<th>CreatedAt</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${orderList }" var="order" varStatus="STT">
												<tr>
													<td>${STT.index+1 }</td>
													<td>${order.userId }</td>
													<td>${order.cartId }</td>
													<td>${order.address }</td>
													<td>${order.phone }</td>
													<td class="${order.status!=null ? 'badge badge-success' : 'badge badge-warning' }">${order.status !=null? order.status:'Chưa xác nhận'}</td>
													<td>${order.amountFromUser }</td>
													<td>${order.createdAt }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.table-stats -->
							</div>
						</div>
						<!-- /.card -->
					</div>
					<!-- /.col-lg-8 -->
					<div class="col-md-12 col-lg-4">
						<div class="card">
							<div class="card-body">
								<!-- <h4 class="box-title">Chandler</h4> -->
								<div class="calender-cont widget-calender">
									<div id="calendar"></div>
								</div>
							</div>
						</div>
						<!-- /.card -->
					</div>
					<!-- /.col-md-4 -->
				</div>
			</div>
			<!-- /.orders -->
			<!-- Modal - Calendar - Add New Event -->
			<div class="modal fade none-border" id="event-modal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">
								<strong>Add New Event</strong>
							</h4>
						</div>
						<div class="modal-body"></div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default waves-effect"
								data-dismiss="modal">Close</button>
							<button type="button"
								class="btn btn-success save-event waves-effect waves-light">Create
								event</button>
							<button type="button"
								class="btn btn-danger delete-event waves-effect waves-light"
								data-dismiss="modal">Delete</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /#event-modal -->
			<!-- Modal - Calendar - Add Category -->
			<div class="modal fade none-border" id="add-category">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">
								<strong>Add a category </strong>
							</h4>
						</div>
						<div class="modal-body">
							<form>
								<div class="row">
									<div class="col-md-6">
										<label class="control-label">Category Name</label> <input
											class="form-control form-white" placeholder="Enter name"
											type="text" name="category-name" />
									</div>
									<div class="col-md-6">
										<label class="control-label">Choose Category Color</label> <select
											class="form-control form-white"
											data-placeholder="Choose a color..." name="category-color">
											<option value="success">Success</option>
											<option value="danger">Danger</option>
											<option value="info">Info</option>
											<option value="pink">Pink</option>
											<option value="primary">Primary</option>
											<option value="warning">Warning</option>
										</select>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default waves-effect"
								data-dismiss="modal">Close</button>
							<button type="button"
								class="btn btn-danger waves-effect waves-light save-category"
								data-dismiss="modal">Save</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /#add-category -->
		</div>
		<!-- .animated -->
	</div>

	<!-- /.content -->
	<div class="clearfix"></div>
</div>
<!-- /#right-panel -->

