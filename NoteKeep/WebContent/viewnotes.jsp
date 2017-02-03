<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Note Keep</title>

    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
  <body>    
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h1 class=" text-center">Welcome to <span class="text-info"><strong>Note Keep</strong></span></h1>
				<hr>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.html">Home</a></li>
  					<li role="presentation"><a href="addnote">Add Note</a></li>
  					<li role="presentation" class="active"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<h2>All Notes</h2>				
				
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th>Id</th>							
							<th>Title</th>
							<th>Content</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${notelist}" var="record">
							<tr>
								<td>${record.getNoteId() }</td>
								<td>${record.getTitle() }</td>
								<td>${record.getContent() }</td>
								<td>${record.isStatus() }</td>
								<td>
									<a href="" class="btn btn-info btn-xs">View</a>&nbsp;
									<a href="" class="btn btn-success btn-xs">Edit</a>&nbsp;
									<a href="" class="btn btn-danger btn-xs">Delete</a>&nbsp;
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>