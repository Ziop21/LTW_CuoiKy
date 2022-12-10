<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/admin/category/create" var="add"></c:url>
	<form role="form" action="${add}">
	<button type="submit" class="btn btn-default">Thêm category</button>
	</form>
<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
<!--                 <th>STT</th> -->
                <th>_id</th>
                <th>Tên</th>
                <th>Slug</th>
                <th>Category Cha</th>
                <th>Hình ảnh</th>
                <th>Đường dẫn hình ảnh</th>
                <th>Đã xóa</th>
                <th>Ngày tạo</th>
                <th>Ngày cập nhật</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="cate" varStatus="STT">
            <tr>
<%-- 				<td>${STT.index+1}</td> --%>
				<td>${cate._id }</td>
				<td>${cate.name }</td>
				<td>${cate.slug }</td>
				<td>${cate.categoryId == 0 ? "": cate.categoryId}</td>
				<c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				
				<td>${cate.image}</td>
				<td>${cate.isDeleted}</td>
				<td>${cate.createdAt}</td>
				<td>${cate.updatedAt}</td>
				<td>
					<a href="<c:url value='/admin/category/edit?id=${cate._id }'/>"
					class="center">Sửa</a> | 
					<a href="<c:url value='/admin/category/delete?id=${cate._id }'/>"
					class="center">Xóa</a></td>
			</tr>
		</c:forEach>
</table>
<c:url value="/admin/category/page" var="page"></c:url>
	<form role="form" action="${page }"
		style="margin-left: 40px; width: 700px; height: 100px">
		<input class="form-control" type="number"
			placeholder="nhập số lượng sản phẩm trong 1 trang"
			style="width: 200px;" size="2" value="${pageSize}" name="pageSize" />
		<button type="submit" class="btn btn-default pull-left">Xác
			nhận</button>
			
			<ul class="pagination pull-right">
		<%-- 		<c:if test="${tag>1}"> --%>
		<!-- 			<li><a -->
		<%-- 				href="${pageContext.request.contextPath }/web/product/page?index=${tag-1}&categoryid=0&sellerid=0">&laquo;</a></li> --%>
		<%-- 		</c:if> --%>
		<c:if test="${tag>1}">
			<li><a
				href="${pageContext.request.contextPath }/admin/category/page?index=${tag-1}&pageSize=${pageSize }">&laquo;</a></li>
		</c:if>
		<c:forEach begin="1" end="${endP}" var="i">
			<li class='${tag==i?"active":"" }'><a
				href="${pageContext.request.contextPath}/admin/category/page?index=${i}&pageSize=${pageSize }">${i}</a></li>
		</c:forEach>
		<c:if test="${tag<endP}">
			<li><a
				href="${pageContext.request.contextPath}/admin/category/page?index=${tag+1}&pageSize=${pageSize }">&raquo;</a></li>
		</c:if>
	</ul>
	</form>
<script src="https://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>

<script type="text/javascript">$(document).ready(function () {
    $('#example').DataTable();
});</script>
