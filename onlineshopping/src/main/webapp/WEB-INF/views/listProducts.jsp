<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<div class="container">
	<div class="row">

		<%--To Display the sidebar --%>
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<%--To Display the Products --%>
		<div class="col-md-9">
			<div class="row">
				<div class="col-md-12">
					<c:if test="${userClickShowAllProducts==true}">
						<script type="text/javascript">
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickShowCategoryProducts==true}">
						<script type="text/javascript">
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="productListTable"
						class="table table-striped table-borderd">
						<thead>

							<tr>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
							</tr>

						</thead>


					</table>
				</div>
			</div>
		</div>
	</div>

</div>
