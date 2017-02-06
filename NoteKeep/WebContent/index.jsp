<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file = "header.jsp" %>
    <title>Note Keep | Home</title>
  </head>
  <body>
    
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 text-center">
				<h2>Welcome to <span class="text-warning"><strong>Note Keep</strong></span></h2>
				<hr>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation" class="active"><a href="index.jsp">Home</a></li>
  					<li role="presentation"><a href="addnote">Add Note</a></li>
  					<li role="presentation"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<br/>
				<form action="searchnote" class="" method="post">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search Note..." name="searchstring"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">Go!</button>
						</span>
					</div>
				</form>
				<!-- /input-group -->
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>    