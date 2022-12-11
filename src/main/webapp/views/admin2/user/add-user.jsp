<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
    <div id="right-panel" class="right-panel">

<!-- Header-->
<header id="header" class="header">
	<div class="top-left">
		<div class="navbar-header">
			<a class="navbar-brand" href="./"><img
				src="${URL }images/logo.png" alt="Logo"></a> <a
				class="navbar-brand hidden" href="./"><img
				src="${URL }images/logo2.png" alt="Logo"></a> <a id="menuToggle"
				class="menutoggle"><i class="fa fa-bars"></i></a>
		</div>
	</div>
	<div class="top-right">
		<div class="header-menu">
			<span
				style="text-align: center; display: inline-block; margin-top: 14px">Hello
				${email }</span>

			<div class="user-area dropdown float-right">
				<a href="#" class="dropdown-toggle active" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <img
					class="user-avatar rounded-circle" src="images/admin.jpg"
					alt="User Avatar">
				</a>

				<div class="user-menu dropdown-menu">
					<a class="nav-link" href="#"><i class="fa fa-user"></i>My
						Profile</a> <a class="nav-link" href="<c:url value='/logout'/>"><i
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
							<li><a href="#">Store</a></li>
							<li class="active">List</li>
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
			<div class="col-lg-6 mx-auto">
				<div class="card">
					<div class="card-header"></div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center">Thêm user</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="_id " class="control-label mb-1">ID: </label> <input
											id="_id " name="_id " type="text" class="form-control"
											aria-required="true" aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="firstname" class="control-label mb-1">Firstname:
										</label> <input id="firstname" name="firstname" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="lastname" class="control-label mb-1">Lastname:
										</label> <input id="lastname" name="lastname" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="id_card" class="control-label mb-1">Id_card:
										</label> <input id="id_card" name="id_card" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="email" class="control-label mb-1">Email: </label>
										<input id="email" name="email" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="phone" class="control-label mb-1">Phone: </label>
										<input id="phone" name="phone" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="isEmailActive" class="control-label mb-1">EmailActive:
										</label> <input id="isEmailActive" name="isEmailActive" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="isPhoneActive" class="control-label mb-1">PhoneActive:
										</label> <input id="isPhoneActive" name="isPhoneActive" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="salt" class="control-label mb-1">Salt: </label> <input
											id="salt" name="salt" type="text" class="form-control"
											aria-required="true" aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="password" class="control-label mb-1">Password
										</label> <input id="password" name="password" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="role" class="control-label mb-1">Role </label> <input
											id="role" name="role" type="text" class="form-control"
											aria-required="true" aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="address" class="control-label mb-1">Address
										</label> <input id="address" name="address" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="icon" class="control-label mb-1">Avatar </label> <img
											alt="" src="${user.avatar }"><input id="icon"
											name="icon" type="file" class="form-control"
											aria-required="true" aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="createdAt" class="control-label mb-1">CreatedAt:
										</label> <input id="createdAt" name="createdAt" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
									</div>
									<div class="form-group">
										<label for="updatedAt" class="control-label mb-1">UpdatedAt:
										</label> <input id="updatedAt" name="updatedAt" type="text"
											class="form-control" aria-required="true"
											aria-invalid="false">
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
</div>