<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>
    <!-- Right Panel -->

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

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong class="card-title">Danh sách cửa hàng</strong>
                            </div>
                            <div class="card-body">
                            <a href="<c:url value='/admin2/user/add'/>" class="btn btn-outline-primary" style="margin-bottom:10px"> Thêm mới</a>
                                <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Name</th>
                                            <th>Bio</th>
                                            <th>Slug</th>
                                            <th>Owner</th>
                                            <th>Active</th>
                                            <th>Open</th>
                                            <th>Avatar</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${storeList }" var="store" varStatus="STT">
                                    	<tr>
                                            <td>${STT.index+1 }</td>
                                            <td>${store.name }</td>
                                            <td>${store.bio }</td>
                                            <td>${store.slug }</td>
                                            <td>${store.user.firstname} ${store.user.lastname  }</td>
                                            <td>${store.isActive==true ? 'Active':'No active' }</td>
                                            <td>${store.isOpen==true ? 'Open':'Close'  }</td>
                                            <td>${store.avatar }</td>
                                            <td><a href="<c:url value='/admin2/store/edit?storeId=${store._id }'/>" class="btn btn-info" >Cập nhật </a> <a href="<c:url value='/admin2/store/detail?storeId=${store._id }'/>" class="btn btn-success" >Chi tiết </a> <a href="<c:url value='/admin2/store/delete?storeId=${store._id }'/>" class="btn btn-danger">Xóa</a></td> 
                                        </tr>
                                    	</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->


        <div class="clearfix"></div>

        <footer class="site-footer">
            <div class="footer-inner bg-white">
                <div class="row">
                    <div class="col-sm-6">
                        Copyright &copy; 2018 Ela Admin
                    </div>
                    <div class="col-sm-6 text-right">
                        Designed by <a href="https://colorlib.com">Colorlib</a>
                    </div>
                </div>
            </div>
        </footer>

    </div><!-- /#right-panel -->

    <!-- Right Panel -->