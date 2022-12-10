<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!--Main layout-->
	<main class="mt-5 pt-4">
		<div class="container dark-grey-text mt-5">

			<!--Grid row-->
			<div class="row wow fadeIn"
				style="visibility: visible; animation-name: fadeIn;">

				<!--Grid column-->
				<div class="col-md-6 mb-4">
					<c:url value="/image?fname=${product.listImages[0]}" var="imgUrl"></c:url>
					<img src="${imgUrl}" class="img-fluid" alt="">

				</div>
				<!--Grid column-->

				<!--Grid column-->
				<div class="col-md-6 mb-4">

					<!--Content-->
					<div class="p-4">

						<div class="mb-3">
							<a href=""> <span class="badge purple mr-1">${product.category.name }</span>
							</a> <a href=""> <span class="badge blue mr-1">New</span>
							</a>
							<!--               <a href=""> -->
							<!--                 <span class="badge red mr-1">Bestseller</span> -->
							<!--               </a> -->
						</div>

						<p class="lead">
							<span class="mr-1"> <!--                 <del>$200</del> -->
							</span> <span>$ ${product.price }</span>
						</p>

						<p class="lead font-weight-bold">${product.name }</p>

						<p>${product.description }</p>

						<form class="d-flex justify-content-left">
							<!-- Default input -->
							<input type="number" value="1" aria-label="Search"
								class="form-control" style="width: 100px">
							<button
								class="btn btn-primary btn-md my-0 p waves-effect waves-light"
								type="submit">
								Add to cart <i class="fas fa-shopping-cart ml-1"></i>
							</button>

						</form>

					</div>
					<!--Content-->

				</div>
				<!--Grid column-->

			</div>
			<!--Grid row-->

			<hr>

			<!--Grid row-->
			<div class="row d-flex justify-content-center wow fadeIn"
				style="visibility: visible; animation-name: fadeIn;">

				<!--Grid column-->
				<div class="col-md-6 text-center">

					<h4 class="my-4 h4">Thêm hình ảnh</h4>

					<!-- 					<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. -->
					<!-- 						Natus suscipit modi sapiente illo soluta odit voluptates, -->
					<!-- 						quibusdam officia. Neque quibusdam quas a quis porro? Molestias -->
					<!-- 						illo neque eum in laborum.</p> -->

				</div>
				<!--Grid column-->

			</div>
			<!--Grid row-->

			<!--Grid row-->
			<div class="row wow fadeIn"
				style="animation-name: none;">
				<c:forEach items="${listOfImages}" var="item" varStatus="STT">
					<div class="col-lg-4 col-md-12 mb-4">
						<c:url value="/image?fname=${item}" var="imgUrl2"></c:url>
						<img class="img-fluid" alt="" src="${imgUrl2}" />
					</div>
				</c:forEach>
			</div>
			<!--Grid row-->

		</div>
	</main>

</body>