<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>STT</th>
                <th>Hình</th>
                <th>Tên danh mục</th>
                <th>Trạng thái</th>
                <th>Chức năng</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${cateList}" var="cate" varStatus="STT">
            <tr>
				<td>${STT.index+1}</td>
				<c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
				<td><img height="150" width="200" src="${imgUrl}" /></td>
				<td>${cate.catename }</td>
				<td>${cate.status }</td>
				<td>
					<a href="<c:url value='/admin/category/edit?id=${cate.cateid }'/>"
					class="center">Sửa</a> | 
					<a href="<c:url value='/admin/category/delete?id=${cate.cateid }'/>"
					class="center">Xóa</a></td>
			</tr>
		</c:forEach>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>

<script type="text/javascript">$(document).ready(function () {
    $('#example').DataTable();
});</script>
