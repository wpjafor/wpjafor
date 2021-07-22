<%@page import="java.util.ArrayList"%>
<%@page import="models.Message"%>
<%@page import="dbcon.dbconnection"%>
<%@page import="models.Customer"%>
<%@page import="java.util.List"%>
<%@page import="models.Currency"%>

<%
Customer user = (Customer) session.getAttribute("currentUser");
if (user == null) {
	response.sendRedirect("login.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

</style>
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="profile"> <span
			class="fa fa-asterisk"></span> Home
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#"> <span
						class="	fa fa-bell-o"></span> eWallet <span class="sr-only">(current)</span></a>
				</li>





			</ul>

			<ul class="navbar-nav mr-right">
				<li class="nav-item active"><a class="nav-link" href="#"> <span
						class="	fa fa-bell-o"></span> <span class="sr-only">(current)</span></a>
				</li>


				<li class="nav-item"><a class="nav-link" href="LogoutServlet">
						<span class="fa fa-user-plus "></span> Logout
				</a></li>
			</ul>
		</div>
	</nav>



	<!--end of navbar-->




	<main
		class="d-flex align-items-center primary-background banner-background"
		style="height: 70vh">
		<div class="container">
			<div class="row">
				<div class="col-md-4 offset-md-4">

					<div class="card">
						<div class="card-header primary-background text-white text-center">
							<span class="fa fa-user-plus fa-3x"></span> <br>
							<p>Create Account</p>
						</div>
						<%
						Message m = (Message) session.getAttribute("msg");
						if (m != null) {
						%>
						<div class="alert <%=m.getCssClass()%>" role="alert">
							<%=m.getContent()%>
						</div>


						<%
						session.removeAttribute("msg");
						}
						%>



						<div class="card-body">
							<form action="CreateAccount" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">Account Name</label> <input
										name="account_name"  class="form-control"
										placeholder="Enter name">

								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Enter Amount</label> <input
										name="amount" class="form-control" id="amount"
										placeholder="Enter Amount">
								</div>
								<div class="form-group">
									<label for="exampleInput">Enter Currency</label>
									<select name="currency">
									<%
									Currency c = new Currency();
									List<String> l = c.getCurrency();
									
									
										for(String s :l) 
											{ %>
											<option value="<%= s %>"> <%= s %></option>
											<%} %>
									
									</select>


								</div>
								
								<div class="container text-center">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>


							</form>

						</div>


					</div>



				</div>


			</div>

		</div>

	</main>




	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
	
</body>
</html>