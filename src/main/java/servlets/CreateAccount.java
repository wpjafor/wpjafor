package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import dao.CustomerDao;
import dbcon.FactoryProvider;
import dbcon.dbconnection;
import models.Account;
import models.Customer;
import models.Message;

/**
 * Servlet implementation class CreateAcoount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

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
//          login 
//            fetch username and password from request
            String accname = request.getParameter("account_name");
            String acctype = request.getParameter("currency");
            String amount = request.getParameter("amount");
            
            // System.out.println(userEmail);
            // System.out.println(userPassword);
            Account acc = new Account(1, accname, acctype, Double.valueOf(amount));

            //create a user daao object..
            AccountDao dao = new AccountDao(FactoryProvider.getFactory());
            if (dao.saveAccount(acc) ==0) {
//            save..
            	Message msg = new Message("Invalid Details ! Either Email or Password is Incorrect  ! try with another", "error", "alert-danger");
                HttpSession s = request.getSession();
                s.setAttribute("msg", msg);

               response.sendRedirect("login.jsp");
            } else {
                //......
//                login success
            	
            		
            	
            	
                //s.setAttribute("currentUser", u);
                //String role = u.getRole();
              // System.out.println(role);
            	Message m = new Message("Account added Successfully", "success", "alert-success");
                HttpSession s = request.getSession();
                s.setAttribute("msg", m);
                    response.sendRedirect("createaccount.jsp");
                   // System.out.println("Customer is login"+ u.getName().toString());
            	

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
