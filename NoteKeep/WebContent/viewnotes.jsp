<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file = "header.jsp" %>
    <title>Note Keep | All Notes</title>

</head>
  <body>    
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h2 class=" text-center">Welcome to <span class="text-info"><strong>Note Keep</strong></span></h2>
				<hr>
				<ul class="nav nav-pills nav-justified">
					<li role="presentation"><a href="index.jsp">Home</a></li>
  					<li role="presentation"><a href="addnote">Add Note</a></li>
  					<li role="presentation" class="active"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<h2>All Notes</h2>				
				
				<div class="table-responsive">
				<table class="table table-hover">
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
					<c:choose>
						<c:when test="${not empty notelist}">
							<c:forEach items="${notelist}" var="record">
								<tr>
									<td>${record.getNoteId() }</td>
									<td>${record.getTitle() }</td>
									<td>${record.getContent().substring(0,5) }...</td>
									<td>${record.isStatus() }</td>
									<td><a href="notedetail?id=${record.getNoteId()}"
										class="btn btn-info btn-xs">View</a>&nbsp; <a href=""
										class="btn btn-success btn-xs">Edit</a>&nbsp; <a
										href="deletenote?id=${record.getNoteId()}"
										class="btn btn-danger btn-xs">Delete</a>&nbsp;</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr><td class="alert alert-danger" align="center" colspan="5">Records not found</td></tr>
						</c:otherwise>	
					</c:choose>
					</tbody>
				</table>
				</div>
				<br>
				<a href="addnote" class="btn pull-right btn-primary">Add Note</a>
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
   <%@ include file = "footer.jsp" %>    