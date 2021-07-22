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
import models.Currency;
import dao.AccountDao;
import dao.PaymentDao;
import dbcon.FactoryProvider;
import dbcon.dbconnection;
import models.Account;
import models.Message;
import models.Transactions;

/**
 * Servlet implementation class ConverterServlet
 */
@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverterServlet() {
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
            String fromcurrency = request.getParameter("fromcurrency");
            String tocurrency = request.getParameter("tocurrency");
            String accId = request.getParameter("accnumber");
            String userid = request.getParameter("currentuser");
             //System.out.println(userEmail);
             //System.out.println(userPassword);
            Currency c = new Currency();
           Double am = c.Converter(fromcurrency,tocurrency,amount);
            AccountDao dao = new AccountDao(FactoryProvider.getFactory());
            Account fromacc = dao.getAccountByCurrency(fromcurrency,Integer.valueOf(userid));
            Account toacc = dao.getAccountByCurrency(tocurrency,Integer.valueOf(userid));
            double am1 = fromacc.getAmount() - Integer.valueOf(amount);
            fromacc.setAmount((am1));
            int u = dao.updateAccount(fromacc);
            double am2 = toacc.getAmount() + am;
            toacc.setAmount((am2));
            int u1 = dao.updateAccount(toacc);
           
    	            
    	            if (u != 0 & u1 != 0) {
    	            	
    	            	PaymentDao dao1 = new  PaymentDao(FactoryProvider.getFactory());
    	            	Transactions t = new Transactions(fromacc.getCustID(),fromacc.getId(),"Convert",am);
    	                int bol = dao1.saveTransaction(t);
    	               
    	                Transactions t1 = new Transactions(toacc.getCustID(),toacc.getId(),"Convert",am2);
    	                int bol1 = dao1.saveTransaction(t1);
    	               
    	                Message m = new Message("Convert Successfully", "success", "alert-success");
    	                HttpSession s = request.getSession();
    	                s.setAttribute("msg", m);
    	               response.sendRedirect("profile.jsp");
    	            } else {
    	                //......
//    	                login success
    	           
    	            	Message msg = new Message("Invalid Details ! Either Email or Password is Incorrect  ! try with another", "error", "alert-danger");
    	                HttpSession s = request.getSession();
    	                s.setAttribute("msg", msg);
    	               
    	                    response.sendRedirect("profile.jsp");
    	                    //System.out.println("Customer is login"+ u.getName().toString();
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
