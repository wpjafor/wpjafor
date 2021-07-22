package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import models.Account;

public class AccountDao {
	private SessionFactory factory;

    public AccountDao(SessionFactory f) {
        this.factory = f;
    }

	    //method to insert user to data base:
	    public int saveAccount(Account acc) {
	        int userId = 0;
	        Transaction transaction = null;
	        try  {
	        	Session s = this.factory.openSession();
	            // start a transaction
	            transaction = s.beginTransaction();
	            // save the student object
	            userId = (int) s.save(acc);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return userId;

	    }
	    public Account getAccountByCurrency(String currency,int custId) {
	    	//System.out.println(id +"; " + password);
	        Account acc = null;

	        try {

	        	 String query = "from Account where currency =: c and custID =: id";
	              Session s = this.factory.openSession();
	              Query q =s.createQuery(query);
	              q.setParameter("c", currency );
	              q.setParameter("id", custId );
	              //q.setParameter("p", password );
	              System.out.println(q);
	               acc =  (Account) q.uniqueResult();
	               s.close();
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return acc;
	    }
	    public List<Account> getAccountByCustId(int custId) {
	        List<Account> list = new ArrayList<>();
	        //fetch all post by id
	        //fetch all the post
	        try {

	            String query = ("from Account where custID=: id");
	            Session s = this.factory.openSession();
	              Query q =s.createQuery(query);
	              q.setParameter("id", custId );
	              //q.setParameter("p", password );
	              
	               list =   q.list();
	               s.close();
	            
	            

	           
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    public int updateAccount( Account acc) {

	        int f = 0;
	        try {
                
	            String query = "update Account set balance=: b where  accountID =: a";
	            Session s = this.factory.openSession();
	            s.getTransaction().begin();
	              Query q =s.createQuery(query);
	              q.setParameter("a", acc.getId());
                  System.out.println(acc.getAmount());
	              q.setParameter("b", acc.getAmount());
	             
	              //q.setParameter("p", password );
	              
	               f=q.executeUpdate();  
	              
                   s.getTransaction().commit();
	               s.close();
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return f;
	    }
	        
	    }


