<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<section style="margin-top: 20px" class="text-center mb-4">
	<div class="row wow fadeIn"
		style="visibility: visible; animation-name: fadeIn; margin-left: 25px; margin-right: 25px">
		<c:forEach items="${categories}" var="cate" varStatus="STT">
			<div class="col-lg-3 col-md-6 mb-4">

				<!--Card-->
				<div class="card">

					<!--Card image-->
					<div class="view overlay" style="display:flex; justify-content: center">
						<c:url value="/image?fname=${cate.image}" var="imgUrl"></c:url>
						<a href="<c:url value='/web/product/category?id=${cate._id }'/>">
							<img src="${imgUrl}" height="150" width="200" alt="">
						</a>
					</div>
					<!--Card image-->

					<!--Card content-->
					<div class="card-body text-center">

						<h5>
							<strong> <a
								href="<c:url value='/web/product/category?id=${cate._id }'/>"
								class="dark-grey-text">${cate.name } </a>
							</strong>
						</h5>
					</div>
					<!--Card content-->

				</div>
				<!--Card-->

			</div>
		</c:forEach>


	</div>

</section>
<c:url value="/web/category/page" var="page"></c:url>
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
				href="${pageContext.request.contextPath }/web/category/page?index=${tag-1}&pageSize=${pageSize }">&laquo;</a></li>
		</c:if>
		<c:forEach begin="1" end="${endP}" var="i">
			<li class='${tag==i?"active":"" }'><a
				href="${pageContext.request.contextPath}/web/category/page?index=${i}&pageSize=${pageSize }">${i}</a></li>
		</c:forEach>
		<c:if test="${tag<endP}">
			<li><a
				href="${pageContext.request.contextPath}/web/category/page?index=${tag+1}&pageSize=${pageSize }">&raquo;</a></li>
		</c:if>
	</ul>
	</form>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
