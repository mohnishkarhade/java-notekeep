<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file = "header.jsp" %>
    <title>Note Keep | Add Note</title>
  </head>
  <body>
    
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h2 class="text-center">Welcome to <span class="text-info"><strong>Note Keep</strong></span></h2>
				<hr>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.jsp">Home</a></li>
  					<li role="presentation" class="active"><a href="addnote">Add Note</a></li>
  					<li role="presentation"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<h2>Add Note</h2>
				<form action="addnote" method="post" class="well">
					<div class="form-group">
						<label>Note Title:</label>
						<input type="text" name="title" class="form-control" required>
					</div>
					<div class="form-group">
						<label>Note Content:</label>
						<textarea type="text" name="content" class="form-control" rows="4" required></textarea>
					</div>
					<div class="form-group">
						<label>Status:</label>
						<input type="radio" name="status" value="done" required> Done
						<input type="radio" name="status" value="Not done" required> Not Done
					</div>
					<input type="submit" class="btn btn-success" value="Add">
					<a href="index.jsp" class="btn btn-danger">Cancel</a>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
    <%@ include file="footer.jsp" %>