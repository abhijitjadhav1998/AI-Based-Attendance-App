<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<p>${message}</p>

<form:form action="/registration" method="post" modelAttribute="user">
	<div class="mb-3">
		<label>User Name</label>
		<form:input path="userName" class="form-control" />
	</div>
	<div class="mb-3">
		<label>Password</label>
		<form:password path="password" class="form-control" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>

<%@ include file="common/footer.jspf" %>