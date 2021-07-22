package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import dao.CustomerDao;
import dao.PaymentDao;
import dbcon.FactoryProvider;
import dbcon.dbconnection;
import models.Account;
import models.Customer;
import models.Message;
import models.Transactions;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet LoginServlet</title>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<p> hello serv;et </p>");
//	          login 
//	            fetch username and password from request
	            String amount = request.getParameter("amount");
	            String currency = request.getParameter("currency");
	            String accId = request.getParameter("accnumber");
	            String userid = request.getParameter("currentuser");
	             //System.out.println(userEmail);
	             //System.out.println(userPassword);
	            AccountDao dao = new AccountDao(FactoryProvider.getFactory());
	            Account acc = dao.getAccountByCurrency(currency,Integer.valueOf(userid));
	            List<Account> acc1 = dao.getAccountByCustId(Integer.valueOf(accId));
	            System.out.println(acc1);
	            System.out.println(acc +":"+ acc1);
	           
	            for (Account a : acc1)
	            {
	            	if(a.getAccounttype().equals( acc.getAccounttype()))
	            	{
	            		
	            		Double am = (acc.getAmount() - Integer.valueOf(amount));
	    	            acc.setAmount((am));
	    	            int u = dao.updateAccount(acc);
	    	            
	    	            Double am1 = (a.getAmount()) + Integer.valueOf(amount);
	    	            a.setAmount(am1);
	    	            int u1 = dao.updateAccount(a);
	    	            System.out.println(u +";"+ u1);
	    	            
	    	            if (u != 0 && u1 != 0) {
	    	            	
	    	            	PaymentDao dao1 = new  PaymentDao(FactoryProvider.getFactory());
	    	            	Transactions t = new Transactions(acc.getCustID(),acc.getId(),"Transfer",am);
	    	                int bol = dao1.saveTransaction(t);
	    	                Transactions t1 = new Transactions(a.getCustID(),a.getId(),"Transfer",am1);
	    	                int bol1 = dao1.saveTransaction(t1);
	    	               
	    	                Message m = new Message("Transfer Successfully", "success", "alert-success");
	    	                HttpSession s = request.getSession();
	    	                s.setAttribute("msg", m);

	    	               response.sendRedirect("profile.jsp");
	    	            } else {
	    	                //......
//	    	                login success
	    	            	
	    	            		
	    	            	
	    	            	Message msg = new Message("Something Went wrong !", "error", "alert-danger");
	    	                HttpSession s = request.getSession();
	    	                s.setAttribute("msg", msg);
	    	               
	    	                    response.sendRedirect("profile.jsp");
	    	                    //System.out.println("Customer is login"+ u.getName().toString());
	    	            	

	    	            }
	    	            

	            	}
	            	else {
    	                //......
//    	                login success
    	            	
    	            		
    	            	
    	            	Message msg = new Message("Something Went wrong !", "error", "alert-danger");
    	                HttpSession s = request.getSession();
    	                s.setAttribute("msg", msg);
    	               
    	                    response.sendRedirect("profile.jsp");
    	                    //System.out.println("Customer is login"+ u.getName().toString());
    	            	

    	            }
	            }
	            
	            out.println("</body>");
	            out.println("</html>");
	        }
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			processRequest(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			processRequest(request, response);
		}
}
