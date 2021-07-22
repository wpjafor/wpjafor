package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Transactions;

public class PaymentDao {
	private SessionFactory factory;

    public PaymentDao(SessionFactory f) {
        this.factory = f;
    }


    //method to insert user to data base:
    public int saveTransaction(Transactions t) {
    	 int userId = 0;
	        Transaction transaction = null;
	        try  {
	        	Session s = this.factory.openSession();
	            // start a transaction
	            transaction = s.beginTransaction();
	            
	            userId = (int) s.save(t);
	            // commit transaction
	            transaction.commit();
	            s.close();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return userId;
    }
    public List<Transactions> getTransactionByCustId(int custId) {
    	List<Transactions> list = new ArrayList<>();
        //fetch all post by id
        //fetch all the post
        try {

            String query = ("from Transactions where custID=: id");
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

    public List<Transactions> getTransactionByCustIdAndDate(int custId,String date) {
    	List<Transactions> list = new ArrayList<>();
        //fetch all post by id
        //fetch all the post
        try {

            String query = ("from Transactions where custID=: id and date =: d");
            Session s = this.factory.openSession();
              Query q =s.createQuery(query);
              q.setParameter("id", custId );
              q.setParameter("d", date );
              //q.setParameter("p", password );
               list =   q.list();
               s.close();    

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Transactions> getTransactionByCustIdAndDateAndAccount(int custId,String date, int accId) {
    	List<Transactions> list = new ArrayList<>();
        //fetch all post by id
        //fetch all the post
        try {

            String query = ("from Transactions where custID=: id and date =: d and accID =: a");
            Session s = this.factory.openSession();
              Query q =s.createQuery(query);
              q.setParameter("id", custId );
              q.setParameter("d", date );
              q.setParameter("a", accId );
              //q.setParameter("p", password );
               list =   q.list();
               s.close();    

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	

}
