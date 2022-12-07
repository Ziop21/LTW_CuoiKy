<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">E-COMMERCE BOOTSTRAP THEME</h1>
        <p class="lead text-muted mb-0">Simple theme for e-commerce buid with Bootstrap 4.0.0. Pages available : home, category, product, cart & contact</p>
    </div>
</section>
<c:url value="/" var="link"></c:url>
<div class="container">
    <div class="row">
        <div class="col">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/55595c/fff" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/a30ca3/fff" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="https://dummyimage.com/855x365/1443ff/fff" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-12 col-md-3">
            <div class="card">
                <div class="card-header bg-success text-white text-uppercase">
                    <i class="fa fa-heart"></i> Top product
                </div>
                <c:url value="/image?fname=${topProduct.images }" var="imgUrl"></c:url>
							<img class="img-fluid border-0" height="150" width="200" src="${imgUrl}" alt="Card image cap"/>
                <div class="card-body">
                    <h4 class="card-title text-center"><a href="<c:url value='//product/detail?productid=${topProduct.productId}'/>" title="View Product">${topProduct.productName}</a></h4>
                    <div class="row">
                        <div class="col">
                            <p class="btn btn-danger btn-block">${topProduct.price} $</p>
                        </div>
                        <div class="col">
                            <a href="product.html" class="btn btn-success btn-block">View</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="container mt-3">
    <div class="row">
        <div class="col-sm">
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Last products
                </div>
                <div class="card-body">
                    <div class="row">
                    
                    <c:forEach items="${lastProducts}" var="prods">
           				<div class="col-sm">
                            <div class="card">
                            <c:url value="/image?fname=${prods.images }" var="imgUrl"></c:url>
							<img class="card-img-top" height="150" width="200" src="${imgUrl}" alt="Card image cap"/>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="<c:url value='//product/detail?productid=${prods.productId }'/>" title="View Product">${prods.productName }</a></h4>
                                    <p class="card-text">${prods.description }</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${prods.price} $</p>
                                        </div>
                                        <div class="col">
                                            <a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
                    </div>
                </div>
            </div>
            <div class="card">
                <div class="card-header bg-primary text-white text-uppercase">
                    <i class="fa fa-star"></i> Top products
                </div>
                <div class="card-body">
                    <div class="row">
                    <c:forEach items="${topProducts}" var="prods">
           				<div class="col-sm">
                            <div class="card">
                            <c:url value="/image?fname=${prods.images }" var="imgUrl"></c:url>
							<img class="card-img-top" height="150" width="200" src="${imgUrl}" alt="Card image cap"/>
                                <div class="card-body">
                                    <h4 class="card-title"><a href="<c:url value='//product/detail?productid=${prods.productId }'/>" title="View Product">${prods.productName }</a></h4>
                                    <p class="card-text">${prods.description }</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${prods.price} $</p>
                                        </div>
                                        <div class="col">
                                            <a href="cart.html" class="btn btn-success btn-block">Add to cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
					</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


