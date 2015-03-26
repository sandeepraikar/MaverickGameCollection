<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Add New Game</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Styles -->
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/global.css" rel="stylesheet" />
<link href="css/font-awesome.min.css" rel="stylesheet" />
<link href="css/selectize.css" rel="stylesheet" />

</head>
<body class="navbar-fixed">

	<jsp:include page="Header.jsp" />
	<div id="main-container" class="main-container container">
		<div id="main-container-inner"><jsp:include page="Sidebar.jsp" />
			<div class="main-content">
				
				<div class="hr-green"> 	<hr/> </div>
				<div class="page-content">
					<div class="search-criteria">
						<div class="page-header">
							<div class="form-group">
								<h5><span><b><i>Add New Game to Collection</i></b></span></h5>
							</div>
						</div>
						<span id="errMsg" class="alert-danger"></span>
						<form:form method="POST" action="addNewGameImpl" modelAttribute="VideoGameCollection" class="form-horizontal"
								id="addGameForm">
							<fieldset>
							
								
								<div class="form-group row">
									<label class="col-md-2" for="videoGameId">VideoGame<em style="color:red;">*</em></label>
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
						
									<label class="col-md-2" for="consoleId">Console<em style="color:red;">*</em></label>
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
									<label class=" col-md-2" for="conditionId">Condition Type<em style="color:red;">*</em></label>
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
									
									<label class=" col-md-2" for="conditionId">Content Type<em style="color:red;">*</em></label>
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
								<div class="form-group row">
									<label class=" col-md-2" for="marketPrice">Market Price</label>
									<div class="col-md-2">
										<input id="txtMarketPrice" name="marketPrice"
											class="form-control" readonly="readonly" type="text" />
									</div>
									<label class=" col-md-2" for="purchasePrice">Purchase Price<em style="color:red;">*</em></label>
									<div class="col-md-5">
										<input id="purchasePrice" name="purchasePrice"
											class="form-control" type="text" maxlength="5" onpaste="return false;"/><span id="errmsg"></span>
									</div>
								</div>


								<div id="submitGame" class="col-md-offset-8 col-md-1">
									<button class="btn btn-primary" name="addNewGame"  id="btnSubmit">Add to Collection</button>
								</div>
								
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/custom.js"></script>
	<script type="text/javascript" src="js/custom-extra.js"></script>
	<script type="text/javascript">
		$("#errMsg").text("");
		$("#errMsg").hide();
		var flag=0;
		$("#videoGameId").change(function() {
			$.getJSON('getConsoleList',{
				videoGameId : $('#videoGameId').val(),
				ajax : 'true'
			},
			function(data) {
				var html = '<option value="">-Select-</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					var temp =data[i];
					var result = temp.split("|");
					html += '<option value="' + result[0]+ '">'+ result[1]	+ '</option>';
				}
				html += '</option>';

				$('#consoleId').html(html);
			
			});
		});
		
		$("#contentId").change(function(){
			if($('#videoGameId option:selected').length>0 &&  $('#consoleId option:selected').length>0){
				
				$.getJSON('getMarketPrice',{
					videoGameId : $('#videoGameId').val(),
					consoleId : $('#consoleId').val(),
					conditionId : $('#conditionId').val(),
					contentId : $(this).val(),
					ajax : 'true'
				},
				function(data) {					
					$('#txtMarketPrice').val(data[0]);					
					var temp=data[1];
					var validation = parseInt(temp);
					if(validation!=0){						
						alert("Game already exists in Collection!");
						flag=1;
					}else{
						flag=0;
						alert("Game doesn't exist in Collection!!");
					}
				});
			}else{
				alert("Please select the videogame and console from the dropdown");
			}
			
		});
		

 	 	$("#purchasePrice").keypress(function (e) {
		     //if the letter is not digit then display error and don't type anything
		     if (e.which != 8 && e.which != 0 && e.which != 46 && (e.which < 48 || e.which > 57)) {
		        //display error message
		        $("#errmsg").html("Digits Only").show().fadeOut("slow");
		        return false;
		    }
		  });
 	 	
		$("#btnSubmit").click(function() {
			
			$("#errMsg").text("");
			$("#errMsg").show();

			formcontrol = $('.form-control');
			if (formcontrol.length == 0
					|| $(formcontrol).val() == "") {
				$("#errMsg")
						.append(
								"<span>Please select required values</span><br>");
				return false;
			}

			videoGameId = $('#videoGameId');
			if ($(videoGameId).val() == "") {
				$("#errMsg")
						.append(
								"<span>Please select the VideoGame</span><br>");
				return false;
			}

			consoleId = $('#consoleId');
			if ($(consoleId).val() == "") {
				$("#errMsg")
						.append(
								"<span>Please select the Game Console</span><br>");
				return false;
			}
			
			conditionId = $('#conditionId');
			if ($(conditionId).val() == "") {
				$("#errMsg")
						.append(
								"<span>Please select the Game Condition</span><br>");
				return false;
			}
			
			contentId = $('#contentId');
			if ($(contentId).val() == "") {
				$("#errMsg").append("<span>Please select the Game Content</span><br>");
				return false;
			}
			
			purchasePrice = $('#purchasePrice');
			if ($(purchasePrice).val() == "") {
				$("#errMsg")
						.append(
								"<span>Please enter the purchase Price</span><br>");
				return false;
			}
			
			event.preventDefault();
			
			if(flag==1){
				$("#errMsg")
				.append(
						"<span>VideGame with the selected Console and Content already exits in Collection!!</span><br>");
				return false;
			}else{
				flag==0;
				$("#addGameForm").submit();
			}

			
	});
		
	</script>


</body>
</html>