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
import dao.PaymentDao;
import dbcon.FactoryProvider;
import models.Account;
import models.Message;
import models.Transactions;

/**
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
            String amount = request.getParameter("amount");
            String currency = request.getParameter("currency");
            String userid = request.getParameter("currentuser");
             //System.out.println(userEmail);
             //System.out.println(userPassword);
            AccountDao dao = new AccountDao(FactoryProvider.getFactory());
            Account acc = dao.getAccountByCurrency(currency,Integer.valueOf(userid));
            System.out.println(acc);
            Double am = (acc.getAmount()) - Integer.valueOf(amount);
            acc.setAmount((am));
            int u = dao.updateAccount(acc);
            
            
            if (u != 0) {
            	
            	PaymentDao dao1 = new  PaymentDao(FactoryProvider.getFactory());
            	
            	Transactions t = new Transactions(acc.getCustID(),acc.getId(),"Withdraw",am);
                int bol = dao1.saveTransaction(t);
                Message m = new Message("Withdraw Successfully", "success", "alert-success");
                HttpSession s = request.getSession();
                s.setAttribute("msg", m);
               response.sendRedirect("profile.jsp");
            } else {
                //......
//                login success
            	
            		
            	
            	Message msg = new Message("Invalid Details ! Either Email or Password is Incorrect  ! try with another", "error", "alert-danger");
                HttpSession s = request.getSession();
                s.setAttribute("msg", msg);
               
                    response.sendRedirect("profile.jsp");
                    //System.out.println("Customer is login"+ u.getName().toString());
            	

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
