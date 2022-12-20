<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp" %>
 <!-- Left Panel -->
    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="<c:url value='/admin2/dashboard'/>" class="dropdown-toggle"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>
                    </li>
                    <li class="menu-title">Management</li><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown ${categoryCheck=='1' ? 'alert-primary':''  }">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Category</a>
                    </li>
                    <li class="menu-item-has-children dropdown ${productCheck=='1' ? 'alert-primary':''  }">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Product</a>                     
                    </li>
                    <li class="menu-item-has-children dropdown ${userCheck=='1' ? 'alert-primary':''  }">
                        <a href="<c:url value='/admin2/user/list'/>" class="dropdown-toggle"  aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>User</a>
                    </li>
                    <li class="menu-item-has-children dropdown ${storeCheck=='1' ? 'alert-primary':''  }">
                        <a href="<c:url value='/admin2/store/list'/>" class="dropdown-toggle"  aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Store</a>
                    </li>
                     <li class="menu-item-has-children dropdown ${orderCheck=='1' ? 'alert-primary':''  }">
                        <a href="<c:url value='/admin2/order/list'/>" class="dropdown-toggle"  aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Order</a>
                    </li>
                    <li class="menu-item-has-children dropdown ${vendorCheck=='1' ? 'alert-primary':''  }">
                        <a href="<c:url value='/admin2/vendor/list'/>" class="dropdown-toggle"  aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Vendor</a>
                    </li>
                  
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside>
    <!-- /#left-panel -->
    
    
    