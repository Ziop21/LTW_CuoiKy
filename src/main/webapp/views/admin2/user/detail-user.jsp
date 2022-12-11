<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>
<c:url value="/templates/" var="URL"></c:url>
    <div id="right-panel" class="right-panel">

<!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="./"><img src="${URL }images/logo.png" alt="Logo"></a>
                    <a class="navbar-brand hidden" href="./"><img src="${URL }images/logo2.png" alt="Logo"></a>
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
            <div class="top-right">
                <div class="header-menu">
                    <span style="text-align:center;display: inline-block;margin-top:14px">Hello ${email }</span>

                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                            <a class="nav-link" href="#"><i class="fa fa-user"></i>My Profile</a>

                            <a class="nav-link" href="<c:url value='/logout'/>"><i class="fa fa-power-off"></i>Logout</a>
                        </div>
                    </div>
                </div>
            </div>
        </header><!-- /header -->
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
					<div class="card-header">
					</div>
					<div class="card-body">
						<!-- Credit Card -->
						<div id="pay-invoice">
							<div class="card-body">
								<div class="card-title">
									<h3 class="text-center">Chi tiết user</h3>
								</div>
								<hr>
								<form action="#" method="post" novalidate="novalidate">
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">ID:${user._id }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Firstname: ${user.firstname }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Lastname:${user.lastname }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Id_card:${user.id_card }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Email:${user.email }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Phone:${user.phone }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">EmailActive:{user.isEmailActive }
											</label> 
											</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">PhoneActive:{user.isPhoneActive }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Salt:${user.salt }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Password:{user.hashed_password }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Role:{user.role }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Address: ${user.address }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">Avatar
											</label> <img alt="" src="${user.avatar }">
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">CreatedAt:${user.createdAt }
											</label> 
									</div>
									<div class="form-group">
										<label for="cc-payment" class="control-label mb-1">UpdatedAt:${user.updatedAt }
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
</div>