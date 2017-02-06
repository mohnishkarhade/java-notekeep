<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file = "header.jsp" %>
    <title>Note Keep | Note Detail</title>

</head>
  <body>    
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<h2 class=" text-center">Welcome to <span class="text-info"><strong>Note Keep</strong></span></h2>
				<hr>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.jsp">Home</a></li>
  					<li role="presentation"><a href="addnote">Add Note</a></li>
  					<li role="presentation" class="active"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<br><br>			
				<c:forEach items="${notedetail}" var="record">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<p class="panel-title">Note Detail</p>
						</div>
						<div class="panel-body">
							<div class="alert alert-info">
								<strong>Note Id:</strong> ${record.getNoteId() }
							</div>
							
							<div class="alert alert-info">
								<strong>Note Title:</strong> ${record.getTitle() }
							</div>
							
							<div class="alert alert-info">
								<strong>Note Content:</strong> ${record.getContent() }
							</div>
							
							<div class="alert alert-info">
								<strong>Note Status:</strong> ${record.isStatus() }
							</div>
						</div>
						<div class="panel-footer">
							<a href="" class="btn btn-success btn-xs">Edit</a>&nbsp;
							<a href="deletenote?id=${record.getNoteId()}" class="btn btn-danger btn-xs">Delete</a>&nbsp;
						</div>
					</div>
				</c:forEach>				
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
    <%@ include file = "footer.jsp" %>    