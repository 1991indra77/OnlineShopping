<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<spring:url value="/resources/js/" var="js" />
<spring:url value="/resources/css/" var="css" />
<spring:url value="/resources/images/" var="image" />
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>
<script>
	window.menu = '${title}';
	window.contextRoot='${pageContext.request.contextPath}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/shop-homepage.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/bootstrap-custom-theme.css" rel="stylesheet">

<!-- Data Table CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<div class="content">
			<!-- Page Content -->
			<c:if test="${userClickHome==true}">
				<%@include file="./home.jsp"%>
			</c:if>
			<c:if test="${userClickAbout==true}">
				<%@include file="./about.jsp"%>
			</c:if>
			<c:if test="${userClickContact==true}">
				<%@include file="./contact.jsp"%>
			</c:if>
			<c:if test="${userClickShowAllProducts==true or userClickShowCategoryProducts==true}">
				<%@include file="./listProducts.jsp"%>
			</c:if>
		</div>
		
		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- DataTables -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- custom JS -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
