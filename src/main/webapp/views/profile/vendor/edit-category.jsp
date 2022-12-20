<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/templates/" var="URL"></c:url>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="utf-8">
<title>Thông tin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link
	href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.profile {
	margin: 20px 0;
}

.profile-sidebar {
	padding: 20px 0 10px 0;
	background: #fff;
}

.profile-userpic img {
	float: none;
	margin: 0 auto;
	width: 50%;
	height: 50%;
	-webkit-border-radius: 50% !important;
	-moz-border-radius: 50% !important;
	border-radius: 50% !important;
}

.profile-usertitle {
	text-align: center;
	margin-top: 20px;
}

.profile-usertitle-name {
	color: #5a7391;
	font-size: 16px;
	font-weight: 600;
	margin-bottom: 7px;
}

.profile-usertitle-job {
	text-transform: uppercase;
	color: #5b9bd1;
	font-size: 12px;
	font-weight: 600;
	margin-bottom: 15px;
}

.profile-userbuttons {
	text-align: center;
	margin-top: 10px;
}

.profile-userbuttons .btn {
	text-transform: uppercase;
	font-size: 11px;
	font-weight: 600;
	padding: 6px 15px;
	margin-right: 5px;
}

.profile-userbuttons .btn:last-child {
	margin-right: 0px;
}

.profile-usermenu {
	margin-top: 30px;
}

.profile-usermenu ul li {
	border-bottom: 1px solid #f0f4f7;
}

.profile-usermenu ul li:last-child {
	border-bottom: none;
}

.profile-usermenu ul li a {
	color: #93a3b5;
	font-size: 14px;
	font-weight: 400;
}

.profile-usermenu ul li a i {
	margin-right: 8px;
	font-size: 14px;
}

.profile-usermenu ul li a:hover {
	background-color: #fafcfd;
	color: #5b9bd1;
}

.profile-usermenu ul li.active {
	border-bottom: none;
}

.profile-usermenu ul li.active a {
	color: #5b9bd1;
	background-color: #f6f9fb;
	border-left: 2px solid #5b9bd1;
	margin-left: -2px;
}

.profile-content {
	padding: 20px;
	background: #fff;
	min-height: 460px;
}
</style>
<link rel="apple-touch-icon" href="https://i.imgur.com/QRAUqs9.png">
<link rel="shortcut icon" href="https://i.imgur.com/QRAUqs9.png">
<!-- CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"
	rel="styleshee" type="text/css">
<link
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"
	rel="styleshee" type="text/css">


<link href="${URL}css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="font-size: 16px; background: #F1F3FA;">
	<!-- Header -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="index.html">Simple Ecommerce</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<c:url value="/" var="link"></c:url>
					<li class="nav-item active"><a class="nav-link"
						href="${link}home">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${link}category/list">Categories</a></li>
					<li class="nav-item"><a class="nav-link" href="product.html">Product</a>
					</li>
					<li class="nav-item "><a class="nav-link" href="product.html">Cart</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Contact</a>
					</li>
				</ul>

				<form class="form-inline my-2 my-lg-1">
					<div class="input-group input-group-sm">
						<input type="text" class="form-control" placeholder="Search...">
						<div class="input-group-append">
							<button type="button" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
					<a class="btn btn-success btn-sm ml-3" href="cart.html"> <i
						class="fa fa-shopping-cart"></i> Cart <span
						class="badge badge-light">${countCartItem==null?'0':countCartItem }</span>
					</a>
				</form>
			</div>
			<div class="navbar-inline">
				<c:if test="${user != null }">
					<a href="<c:url value="/myprofile/info?email=${user.email }"/>"><span
						style="color: white">${user.email }</span></a>
					<a href="<c:url value='/logout'/>" style="color: white">Đăng
						xuất</a>
				</c:if>
				<c:if test="${user == null }">
					<a href="<c:url value='/login'/>" style="color: white">Đăng
						nhập |</a>
					<a href="<c:url value='/register'/>" style="color: white">Đăng
						ký</a>
				</c:if>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">

					<div class="profile-userpic">
						<img src="${user.avatar }" class="img-responsive"
							alt="Thông tin cá nhân">
					</div>

					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${user.firstname }
							${user.lastname }</div>
						<div class="profile-usertitle-job">${user.role }</div>
					</div>

					<div class="profile-usermenu">
						<ul class="nav">
							<li><a
								href="<c:url value="/myprofile/info?userId=${user._id }"/>">
									<i class="glyphicon glyphicon-info-sign"></i> Thông tin cá nhân
							</a></li>
							<li><a
								href="<c:url value="/myprofile/edit?userId=${user._id }"/>">
									<i class="glyphicon glyphicon-info-sign"></i> Cập nhật thông
									tin cá nhân
							</a></li>
							<c:if test="${user.role.contains('User')}">
								<li class="active"><a
									href="<c:url value="/myprofile/listorder?userId=${user._id }"/>">
										<i class="glyphicon glyphicon-shopping-cart"></i> Quản lý đơn
										hàng
								</a></li>
							</c:if>
							<li><a
								href="<c:url value="/myprofile/status-regisvendor?userId=${user._id }"/>">
									<i class="glyphicon glyphicon-shopping-cart"></i> Đăng ký
									vendor
							</a></li>
							<c:if test="${user.role.contains('Vendor')}">
								<li class="active"><a
									href="<c:url value="/myprofile/listorder?userId=${user._id }"/>">
										<i class="glyphicon glyphicon-shopping-cart"
										id="dropdownMenuButton"></i> Quản lí cửa hàng
							</a>
							</li>
							</c:if>
						</ul>
					</div>

				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<div class="card">
						<div class="card-header"></div>
						<div class="card-body">
							<!-- Credit Card -->
							<div id="pay-invoice">
								<div class="card-body">
									<div class="card-title">
										<h3 class="text-center">Cập nhật danh mục</h3>
									</div>
									<hr>
									<form action="#" method="post" novalidate="novalidate">
										<div class="form-group">
											<label for="_id" class="control-label mb-1">ID </label> <input
												id="_id" name="_id" type="text" class="form-control"
												aria-required="true" aria-invalid="false"
												value="${cate._id }">
										</div>
										<div class="form-group">
											<label for="name" class="control-label mb-1">Name </label> <input
												id="name" name="name" type="text" class="form-control"
												aria-required="true" aria-invalid="false"
												value="${cate.name }">
										</div>
										<div class="form-group">
											<label for="slug" class="control-label mb-1">Slug </label> <input
												id="slug" name="slug" type="text" class="form-control"
												aria-required="true" aria-invalid="false"
												value="${cate.slug }">
										</div>
										<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Imgaes
											</label> <input id="cc-payment" name="icon" type="file"
											class="form-control" aria-required="true"
											aria-invalid="false" value="cate }">
											<img alt="" src="cate ">
									</div>
										<div class="form-group">
											<label for="categoryId" class="control-label mb-1">CategoryId
											</label> 
											<select class="form-select"
												aria-label="Default select example" id="categoryId" name="categoryId">
												<option selected value="${cate.categoryId }">${cate.categoryId }</option>
												<c:forEach items="${cateList } " var="cate">
												<option value="${cate._id }">${cate.name }</option>
												</c:forEach>
											</select>
										</div>
										<div class="form-group">
											<label for="createdAt" class="control-label mb-1">Created
												At </label> <input id="createdAt" name="createdAt" type="text"
												class="form-control" aria-required="true"
												aria-invalid="false" value="${product.createdAt }">
										</div>
										<div class="form-group">
											<label for="updatedAt" class="control-label mb-1">Updated
												At </label> <input id="updatedAt" name="updatedAt" type="text"
												class="form-control" aria-required="true"
												aria-invalid="false" value="${product.updatedAt }">
										</div>
										<div>
											<button id="payment-button" type="submit"
												class="btn btn-lg btn-info btn-block">Cập nhật</button>
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
	<footer class="text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-4 col-xl-3">
					<h5>About</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<p class="mb-0">Le Lorem Ipsum est simplement du faux texte
						employé dans la composition et la mise en page avant impression.</p>
				</div>

				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
					<h5>Informations</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
					<h5>Others links</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><a href="">Link 1</a></li>
						<li><a href="">Link 2</a></li>
						<li><a href="">Link 3</a></li>
						<li><a href="">Link 4</a></li>
					</ul>
				</div>

				<div class="col-md-4 col-lg-3 col-xl-3">
					<h5>Contact</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<ul class="list-unstyled">
						<li><i class="fa fa-home mr-2"></i> My company</li>
						<li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
						<li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
						<li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
					</ul>
				</div>
				<div class="col-12 copyright mt-3">
					<p class="float-left">
						<a href="#">Back to top</a>
					</p>
					<p class="text-right text-muted">
						created with <i class="fa fa-heart"></i> by <a
							href="https://t-php.fr/43-theme-ecommerce-bootstrap-4.html"><i>t-php</i></a>
						| <span>v. 1.0</span>
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		type="text/javascript"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min
.js"
		type="text/javascript">
		
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript">
		
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
		
	</script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
	<dec:body />

	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script> -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>


</body>
</html>