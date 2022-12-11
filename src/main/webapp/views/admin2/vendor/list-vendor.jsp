<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
<!-- Right Panel -->

<div id="right-panel" class="right-panel">

	<!-- Header-->
	<header id="header" class="header">
		<div class="top-left">
			<div class="navbar-header">
				<a class="navbar-brand" href="./"><img src="images/logo.png"
					alt="Logo"></a> <a class="navbar-brand hidden" href="./"><img
					src="images/logo2.png" alt="Logo"></a> <a id="menuToggle"
					class="menutoggle"><i class="fa fa-bars"></i></a>
			</div>
		</div>
		<div class="top-right">
			<div class="header-menu">

				<div class="user-area dropdown float-right">
					<a href="#" class="dropdown-toggle active" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <img
						class="user-avatar rounded-circle" src="images/admin.jpg"
						alt="User Avatar">
					</a>

					<div class="user-menu dropdown-menu">
						<a class="nav-link" href="#"><i class="fa fa-user"></i>My
							Profile</a> <a class="nav-link" href="#"><i
							class="fa fa-power-off"></i>Logout</a>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- /header -->
	<!-- Header-->

	<div class="breadcrumbs">
		<div class="breadcrumbs-inner">
			<div class="row m-0">
				<div class="col-sm-4">
					<div class="page-header float-left">
						<div class="page-title">
							<h1>Dashboard</h1>
						</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="page-header float-right">
						<div class="page-title">
							<ol class="breadcrumb text-right">
								<li><a href="#">Dashboard</a></li>
								<li><a href="#">Table</a></li>
								<li class="active">Basic table</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-lg-6">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">Vendor List</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table ">
								<thead>
									<tr>
										<th class="serial">STT</th>
										<th class="avatar">Avatar</th>
										<th>ID</th>
										<th>Name</th>
										<th>Store</th>
										<th>Phone</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${vendors }" var="vendor" varStatus="STT">
										<tr>
											<td class="serial">${STT.index+1 }</td>
											<td class="avatar">
												<div class="round-img">
													<a href="#"><img class="rounded-circle"
														src="${vendor.avatar }" alt=""></a>
												</div>
											</td>
											<td>#${vendor._id }</td>
											<td><span class="name">${vendor.firstname }
													${vendor.lastname }</span></td>
											<td><span class="name">${vendor.store.name }</span></td>
											<td><span class="name">${vendor.phone }</span></td>
											<td><a
												href="<c:url value='/admin2/user/edit?userId=${vendor._id }'/>"
												class="badge badge-info">Cập nhật </a> <a
												href="<c:url value='/admin2/user/detail?userId=${vendor._id }'/>"
												class="badge badge-success">Chi tiết </a> <a
												href="<c:url value='/admin2/user/delete?userId=${vendor._id }'/>"
												class="badge badge-danger">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="card">
						<div class="card-header">
							<strong class="card-title">VendorRegistration List</strong>
						</div>
						<div class="table-stats order-table ov-h">
							<table class="table ">
								<thead>
									<tr>
										<th class="serial">STT</th>
										<th>ID</th>
										<th>User Name</th>
										<th>Approved</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${vendorRegiss }" var="vendorRegis" varStatus="STT">
										<tr>
											<td class="serial">${STT.index+1 }</td>
											<td>#${vendorRegis._id }</td>
											<td><span class="name">${vendorRegis.user.firstname }
													${vendorRegis.user.lastname }</span></td>
											<td><span class="name">${vendor.isApproved }</span></td>
											<td><a
												href="<c:url value='/admin2/vendor/approved?Id=${vendorRegis._id }'/>"
												class="badge badge-info">Duyệt</a> <a
												href="<c:url value='/admin2/vendor/delete?Id=${vendorRegis._id }'/>"
												class="badge badge-danger">Xóa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>


			</div>
		</div>
		<!-- .animated -->
	</div>
	<!-- .content -->

</div>
<!-- /#right-panel -->

<!-- Right Panel -->