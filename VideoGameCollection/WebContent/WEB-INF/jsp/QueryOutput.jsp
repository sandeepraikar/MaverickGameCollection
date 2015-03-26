<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Queries</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/global.css" rel="stylesheet">

</head>
<body class="navbar-fixed">
	<jsp:include page="Header.jsp" />
	<div id="main-container" class="main-container container">

		<div id="main-container-inner"><jsp:include page="Sidebar.jsp" /><div
				class="main-content">
				
				<div class="hr-green"> 	<hr/> </div>
				<div class="page-content">
					<div class="search-criteria">
					
					<c:choose>
						<c:when test="${!empty queryResult1}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query1</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame ID</th>
												<th>Console Name</th>													
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult1}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query1 -->
					<!--Query 2 starts  -->
						<c:choose>
						<c:when test="${!empty queryResult2}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query2</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame Title</th>
												<th>No. of occurances</th>													
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult2}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query2 -->
					
					<!-- Query3 -->
					<div class="search-result">
					<div class="result-header">
									<h3 id="resultCount">Query3</h3>
								</div>
					Total Cost of Collection = $ <c:out value="${queryResult3}" />
					</div>
					<!--Endof Query 3  -->
					
					<!--Query 4 starts  -->
					<c:choose>
						<c:when test="${!empty queryResult4}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query4</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame Title</th>
												<th>Content Type</th>																									
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult4}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>																										
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query4 -->
					
					<!--Query 5 starts  -->
					<c:choose>
						<c:when test="${!empty queryResult5}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query5</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame Title</th>
												<th>Max. Purchase Price</th>													
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult5}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query5 -->
					<!--Query 6 starts  -->
					<c:choose>
						<c:when test="${!empty queryResult6}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query6</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame Title</th>
												<th>Purchase Price</th>
												<th>Market Price</th>													
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult6}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>
													<td><c:out value="${queryDerived[2]}" /></td>													
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query6 -->
					<!--Query 7 starts  -->
					<c:choose>
						<c:when test="${!empty queryResult7}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Query7</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>VideoGame Title</th>
												<th>Purchase Price</th>																									
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${queryResult7}" var="query">
												<c:set var="queryDerived" value="${fn:split(query, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>																								
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>
					<!-- End of Query7 -->
				</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/custom-extra.js"></script>
	<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
	

</body>
</html>