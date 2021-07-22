<%@page import="dbcon.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="models.Account"%>
<%@page import="models.Customer"%>
<%@page import="dao.AccountDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Account</title>
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
        table{  
            border-collapse: collapse;  
            width: 100%;   
        }  
    th,td{  
        border: 2px solid black;   
        padding: 15px;  
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
						class="	fa fa-bell-o"></span> Payment Options </a>
				</li>
              </ul>
				<ul class="navbar-nav mr-right">
					<li class="nav-item active"><a class="nav-link"
						href="listaccounts.jsp"> <span class="	fa fa-bell-o"></span>
							List Account <span class="sr-only">(current)</span></a></li>



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
	<main>
	<div class="card">
						<div class="card-header primary-background text-white text-center">
							<span class="fa fa-list fa-3x"></span> <br>
							<p>Account List</p>
						</div>
	<div>
	<table>
	<tr>
				<th>Account Number</th>
				<th>Name</th>
				<th>Currency</th>
				<th>Balance</th>
				
	</tr>
		<%
		Customer user = (Customer) session.getAttribute("currentUser");
		if (user == null) {
			response.sendRedirect("login.jsp");
		}
		AccountDao d = new AccountDao(FactoryProvider.getFactory());
		List<Account> l = null;
		l = d.getAccountByCustId(user.getId());
		

		for (Account acc : l) {
		%>
		<tr>
				<td><%=acc.getId()%></td>
				<td><%=acc.getAccountname()%></td>
				<td><%=acc.getAccounttype()%></td>
				<td><%=acc.getAmount()%></td>
				
		</tr>

		

		<%
		}
		%>
      </table>

		</br>
	</div>
	</div>
	</main>
</body>
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
</html>