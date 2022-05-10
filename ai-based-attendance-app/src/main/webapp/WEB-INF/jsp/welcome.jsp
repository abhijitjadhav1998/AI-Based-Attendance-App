<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="signup-form">

	<form:form action="processRegister" method="post"
		modelAttribute="employee">
		<h2>Register</h2>
		<p class="hint-text">Create your account. It's free and only takes
			a minute.</p>
		<div class="form-group">
			<label>User Name</label>
			<form:input path="username" class="form-control" />

		</div>
		<div class="form-group">
			<label>Password</label>
			<form:password path="password" class="form-control" />
		</div>
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" class="form-control" />
		</div>
		<div class="form-group">
			<label>Designation</label>
			<form:input path="designation" class="form-control" />
		</div>
		<div class="form-group">

			Gender: Male
			<form:radiobutton path="gender" value="M" />
			Female
			<form:radiobutton path="gender" value="F" />
		</div>
		<div class="form-group">
			<label>Salary</label>
			<form:input path="salary" class="form-control" />
		</div>
		<div class="form-group">
			<label>City</label>
			<form:input path="city" class="form-control" />
		</div>

		<div class="form-group">
			<label>Mobile No</label>
			<form:input path="mobileNo" class="form-control" />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success btn-lg btn-block">Register
				Now</button>
		</div>

		<div class="text-center">
			Already have an account? <a href="Login">Log in</a>
		</div>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>