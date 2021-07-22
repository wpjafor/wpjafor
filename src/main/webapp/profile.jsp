<%@page import="java.util.List"%>
<%@page import="models.Currency"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Message"%>
<%@page import="dbcon.dbconnection"%>
<%@page import="models.Customer"%>

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
<title>Profile  - you are logged in!</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="index.jsp"> <span
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
				<li class="nav-item active"><a class="nav-link" href="profile.jsp"> <span
						class="	fa fa-bell-o"></span> Payment Options <span class="sr-only">(current)</span></a>
				</li>
              </ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-item active"><a class="nav-link"
						href="listaccounts.jsp"> <span class="	fa fa-bell-o"></span>
							List Account </a></li>



				</ul>

				<ul class="navbar-nav mr-right">
					<li class="nav-item active"><a class="nav-link"
						href="createaccount.jsp"> <span class="	fa fa-bell-o"></span>
							Create Account </a></li>
                </ul>
					<ul class="navbar-nav mr-right">
						<li class="nav-item active"><a class="nav-link"
							href="listtransaction.jsp"> <span class="	fa fa-bell-o"></span>
								List Transaction</a></li>
						<li class="nav-item"><a class="nav-link" href="LogoutServlet">
								<span class="fa fa-user-plus "></span> Logout
						</a></li>
					</ul>
		</div>
	</nav>



	<!--end of navbar-->


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


	<main>

		<div class="container text-center">

			<ul class="nav nav-pills">
				<li class="active"><a data-toggle="pill" href="#deposit">Deposit
						Money</a></li>
				<li><a data-toggle="pill" href="#withdraw">Withdraw</a></li>
				<li><a data-toggle="pill" href="#transfer">Transfer</a></li>
				<li><a data-toggle="pill" href="#converter">Converter</a></li>
			</ul>

			<div class="tab-content">
				<div id="deposit" class="tab-pane fade in active">
					<div class="card-body">
						<form action="DepositServlet" method="post">
							<div class="form-group">
							<input name="currentuser" type ="Hidden"
									class="form-control" value ="<%= user.getId() %>">
								<label for="exampleInput">Amount</label> <input name="amount"
									class="form-control" placeholder="Enter Amount">

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
								<button type="submit" class="btn btn-primary">Deposit</button>
							</div>
						</form>

					</div>

				</div>
				<div id="withdraw" class="tab-pane fade">
					<div class="card-body">
						<form action="WithdrawServlet" method="post">
						<input name="currentuser" type ="Hidden"
									class="form-control" value ="<%= user.getId() %>">
							<div class="form-group">
								<label for="exampleInput">Amount</label> <input name="amount" r
									class="form-control" placeholder="Enter Amount">

							</div>
							<div class="form-group">
									<label for="exampleInput">Enter Currency</label>
									<select name="currency">
									<%
									Currency c1 = new Currency();
									List<String> l1 = c1.getCurrency();
									
									
										for(String s :l1) 
											{ %>
											<option value="<%= s %>"> <%= s %></option>
											<%} %>
									
									</select>


								</div>


							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Withdraw</button>
							</div>
						</form>

					</div>

				</div>
				<div id="transfer" class="tab-pane fade">
					<div class="card-body">
						<form action="TransferServlet" method="post">
						<input name="currentuser" type ="Hidden"
									class="form-control" value ="<%= user.getId() %>">
							<div class="form-group">
								<label for="exampleInput">Amount</label> <input name="amount"
									class="form-control" placeholder="Enter Amount">

							</div>
							<div class="form-group">
									<label for="exampleInput">Enter Currency</label>
									<select name="currency">
									<%
									Currency c2 = new Currency();
									List<String> l2 = c.getCurrency();
									
									
										for(String s :l2) 
											{ %>
											<option value="<%= s %>"> <%= s %></option>
											<%} %>
									
									</select>


								</div>
							<div class="form-group">
								<label for="exampleInput">Enter Customer Account Number</label>
								<input name="accnumber" class="form-control" id=""
									placeholder="Enter Account Number">
							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Transfer</button>
							</div>
						</form>

					</div>
				</div>
				<div id="converter" class="tab-pane fade">
					<div class="card-body">
					<input name="currentuser" type ="Hidden"
									class="form-control" value ="<%= user.getId() %>">
						<form action="ConverterServlet" method="post">
							<div class="form-group">
								<label for="exampleInput">Amount</label> <input name="amount" r
									class="form-control" placeholder="Enter Amount">

							</div>
							<div class="form-group">
									<label for="exampleInput">From Currency</label>
									<select name="fromcurrency">
									<%
									Currency c4 = new Currency();
									List<String> l4 = c.getCurrency();
									
									
										for(String s :l4) 
											{ %>
											<option value="<%= s %>"> <%= s %></option>
											<%} %>
									
									</select>


								</div>
							<div class="form-group">
									<label for="exampleInput">To  Currency</label>
									<select name="tocurrency">
									<%
									Currency c5 = new Currency();
									List<String> l5 = c.getCurrency();
									
									
										for(String s :l5) 
											{ %>
											<option value="<%= s %>"> <%= s %></option>
											<%} %>
									
									</select>


								</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Convert</button>
							</div>
						</form>

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