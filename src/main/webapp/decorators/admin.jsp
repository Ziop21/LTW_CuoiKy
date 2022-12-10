<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/commons/taglib.jsp" %>
<c:url value="/templates/" var="URL"></c:url>

<!DOCTYPE html>
<html>
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin</title>
    <!-- CSS -->
    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" rel="styleshee" type="text/css">
    <link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css" rel="styleshee" type="text/css">
    
    <link href="${URL}css/style.min.css" rel="stylesheet" type="text/css">
    <link href="${URL}css/mdb.min.css" rel="stylesheet" type="text/css">
 	<link href="${URL}css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${URL}css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- Header -->
<%@ include file="/commons/admin/header.jsp"%>

<dec:body />

<!-- Footer -->
<jsp:include page="/commons/admin/footer.jsp"></jsp:include>

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>


</body>
</html>