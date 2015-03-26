<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Maverick Video Game Collection</title>
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

						<div class="page-header">
							<div class="form-group">
								<h5><span><b><i>Search Games in Collection</i></b></span></h5>
							</div>
						</div>
						<span id="errMsg" class="alert-danger"></span>
						<form:form method="POST" action="searchCollectionImpl" id="searchCollection"
							modelAttribute="VideoGameCollection">

							<fieldset>

								<div class="form-group row"></div>
								<div class="form-group row">
									<label class="col-md-2" for="videoGameId">VideoGame</label>
									<div class="col-md-5">
									<select id="videoGameId" name="videoGameId"
																class="form-control">
										<option value="">-Select-</option>
										<c:forEach items="${videoGameList}" var="videoGame">
											<c:set var="videoGameDerived" value="${fn:split(videoGame, '|')}"/>
											<option value="${videoGameDerived[0]}">
												<c:out value="${videoGameDerived[1]}" />
											</option>
										</c:forEach>
									</select>
									</div>
						
									<label class="col-md-2" for="consoleId">Console</label>
									<div class="col-md-2">
									<select id="consoleId" name="consoleId"
																class="form-control">
										<option value="">-Select-</option>
										<c:forEach items="${consoleList}" var="console">
											<c:set var="consoleDerived" value="${fn:split(console, '|')}"/>
											<option value="${consoleDerived[0]}">
												<c:out value="${consoleDerived[1]}" />
											</option>
										</c:forEach>
									</select>
									</div>

								</div>

								<div class="form-group row">
									<label class=" col-md-2" for="conditionId">Condition Type</label>
									<div class="col-md-3">
									<select id="conditionId" name="conditionId"
																class="form-control">
										<option value="">-Select-</option>
										<c:forEach items="${conditionList}" var="condition">
											<c:set var="conditionDerived" value="${fn:split(condition, '|')}"/>
											<option value="${conditionDerived[0]}">
												<c:out value="${conditionDerived[1]}" />
											</option>
										</c:forEach>
									</select>
									</div>
									
									<label class=" col-md-2" for="conditionId">Content Type</label>
									<div class="col-md-4">
									<select id="contentId" name="contentId"
																class="form-control">
										<option value="">-Select-</option>
										<c:forEach items="${contentList}" var="content">
											<c:set var="contentDerived" value="${fn:split(content, '|')}"/>
											<option value="${contentDerived[0]}">
												<c:out value="${contentDerived[1]}" />
											</option>
										</c:forEach>
									</select>
									</div>
									
								</div>
								<div class="row">
									<div class="col-md-offset-9 col-md-1">
										<button type="submit" class="btn btn-primary" name="searchCollection" id="btnSubmit">Search	Collection</button>
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>

					<c:choose>
						<c:when test="${!empty colectionList}">
							<div class="search-result">
								<div class="result-header">
									<h3 id="resultCount">Search Results</h3>
								</div>
								<div class="table-responsive">
									<table class="table table-bordered table-advance" id="results">
										<thead>
											<tr>
												<th>Collection Id</th>
												<th>Video Game Id</th>
												<th>Console Id</th>
												<th>Content Id</th>
												<th>Condition Id</th>
												<th>Purchase Date</th>
												<th>Market Price</th>
												<th>Purchase Price</th>	
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${colectionList}" var="vgameCollection">
												<c:set var="queryDerived" value="${fn:split(vgameCollection, '|')}"/>
												<tr>
													<td><c:out value="${queryDerived[0]}" /></td>
													<td><c:out value="${queryDerived[1]}" /></td>
													<td><c:out value="${queryDerived[2]}" /></td>
													<td><c:out value="${queryDerived[3]}" /></td>
													<td><c:out value="${queryDerived[4]}" /></td>
													<td><c:out value="${queryDerived[5]}" /></td>
													<td><c:out value="${queryDerived[6]}" /></td>
													<td><c:out value="${queryDerived[7]}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- <div class="row">								
								<div id="pageNavPosition" class="col-md-offset-6 col-md-6 paging_bootstrap dataTables_paginate"></div>
								</div>
 -->
							</div>
						</c:when>
						<c:otherwise>						
							<div>
								<c:out value="${SearchResult}" />
							</div>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${!empty videoGameCollection}">
							<div class="search-result">
								<div class="panel-heading alert-success">
									<i class="icon-exclamation-triangle icon-large"></i><span
										class="title">Video Game ${videoGameCollection.videoGameId} has been successfully added to Collection</span>
								</div>

								<fieldset>
									<legend></legend>
									<div class="table-responsive">
										<table
											class="table table-bordered table-advance"
											id="results">
											<thead>
												<tr>
												<th>Collection Id</th>
												<th>Video Game Id</th>
												<th>Console Id</th>
												<th>Content Id</th>
												<th>Condition Id</th>
												<th>Purchase Date</th>
												<th>Purchase Price</th>	
											</tr>
											</thead>
											<tbody>
												<tr>
													<td><c:out value="${videoGameCollection.collectionId}" /></td>
													<td><c:out value="${videoGameCollection.videoGameId}" /></td>
													<td><c:out value="${videoGameCollection.consoleId}" /></td>
													<td><c:out value="${videoGameCollection.contentId}" /></td>
													<td><c:out value="${videoGameCollection.conditionId}" /></td>
													<td><c:out value="${videoGameCollection.purchaseDate}" /></td>
													<td><c:out value="${videoGameCollection.purchasePrice}" /></td>
												</tr>
											</tbody>
										</table>

									</div>
								</fieldset>
							</div>
						</c:when>

					</c:choose>
				</div>
			</div>
		</div>
	</div>


		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		<script type="text/javascript" src="js/custom-extra.js"></script>
		<script type="text/javascript" src="js/paging.js"></script>
		<script type="text/javascript" src="js/jquery.tablesorter.js"></script>

<!-- 
	<script type="text/javascript">

	var pager = new Pager('results', 10);
	pager.init();
	pager.showPageNav('pager', 'pageNavPosition');
	pager.showPage(1);		
	$("#results").tablesorter();
	var recordCount= document.getElementById("results").rows.length;
	recordCount--;
    $("#resultCount").text("Search Results ("+ recordCount + " Listed)");
	</script> -->

</body>
</html>