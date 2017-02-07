<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file = "header.jsp" %>
    <title>Note Keep | Update Note</title>
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
  					<li role="presentation"><a href="addnote">Add Note</a></li>
  					<li role="presentation" class="active"><a href="viewnotes">View Notes</a></li>
  					<li role="presentation"><a href="about">About</a></li>
				</ul>
				<h2>Update Note</h2>
				<c:forEach items="${notedata}" var="record">
					
				<form action="updatenote" method="post" class="well">
					<input type="text" name="id" class="hidden" value="${record.getNoteId()}">
					<div class="form-group">
						<label>Note Title:</label>
						<input type="text" name="title" class="form-control" value="${record.getTitle()}">
					</div>
					<div class="form-group">
						<label>Note Content:</label>
						<textarea type="text" name="content" class="form-control" rows="4">${record.getContent()}</textarea>
					</div>
					<div class="form-group">
					<c:set var="status" value="${record.isStatus() }"></c:set>
					<c:choose>						
						<c:when test="${fn:containsIgnoreCase(status, 'done')}">
							<label>Status:</label>
							<input type="radio" name="status" value="done" checked> Done
							<input type="radio" name="status" value="Not done" > Not Done
						</c:when>
						<c:when test="${fn:containsIgnoreCase(status, 'Not done')}">
							<label>Status:</label>
							<input type="radio" name="status" value="done" > Done
							<input type="radio" name="status" value="Not done" checked> Not Done
						</c:when>
						<c:otherwise>
							<label>Status:</label>
							<input type="radio" name="status" value="done" > Done
							<input type="radio" name="status" value="Not done"> Not Done
						</c:otherwise>
					</c:choose>
					</div>
					<input type="submit" class="btn btn-success" value="Update">
					<a href="viewnotes" class="btn btn-danger">Cancel</a>
				</form>
				</c:forEach>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
    <%@ include file="footer.jsp" %>