<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

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
			<c:if test="${username != null }">
				<a href="<c:url value="/myprofile/info?email=${username }"/>"><span style="color:white">${username }</span></a>
				<a href="<c:url value='/logout'/>" style="color:white">Đăng xuất</a>
			</c:if>
			<c:if test="${username == null }">
				<a href="<c:url value='/login'/>" style="color:white">Đăng nhập |</a>
				<a href="<c:url value='/register'/>" style="color:white">Đăng ký</a>
			</c:if>
		</div>
	</div>
</nav>