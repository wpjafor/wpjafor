/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import models.Customer;



/**
 *
 * @author Asus
 */
public class CustomerDao {

    private SessionFactory factory;

    public CustomerDao(SessionFactory f) {
        this.factory = f;
    }

    //method to insert user to data base:
  /*  public boolean saveUser(customer cust) {
        boolean f = false;
        try {
            //user -->database
           /* user.setName("bhanu");
            user.setEmail("kn@gmail.com");
            user.setPassword("bhanu");
            user.setGender("male");
            user.setAge("13");
            user.setRole("stu");
        	String r =user.getRole();
      
            String query = "insert into user(name,email,password,gender,age,role) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAge());           
            pstmt.setString(6, user.getRole());
            
            


            pstmt.executeUpdate();
            
            /*if(r.equals("Student"))
            {
            String query = "insert into teacher(name,email,password,gender,age,role) values (?,?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAge());           
            pstmt.setString(6, user.getRole());
            }
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }*/

    //get user by useremail and userpassword:
    public Customer getUserByLoginIDAndPassword(String id, String password) {
    	System.out.println(id +"; " + password);
        Customer cust = null;

        try {
              String query = "from Customer where login_id =: l and password =: p";
              Session s = this.factory.openSession();
              Query q =s.createQuery(query);
              q.setParameter("l", id );
              q.setParameter("p", password );
              
               cust = (Customer) q.uniqueResult();
               s.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cust;
    }

  /*  public boolean updateUser(User user) {

        boolean f = false;
        try {

            String query = "update user set name=? , email=? , password=? , gender=? ,age=? , role=? where  id =?";
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, user.getName());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPassword());
            p.setString(4, user.getGender());
            p.setString(5, user.getAge());
            p.setString(6, user.getRole());
            p.setInt(7, user.getId());

            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public User getUserByUserId(int userId) {
        User user = null;
        try {
            String q = "select * from user where id=?";
            PreparedStatement ps = this.con.prepareStatement(q);
            ps.setInt(1, userId);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                user = new User();

//             data from db
                String name = set.getString("name");
//             set to user object
                user.setName(name);

                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setPassword(set.getString("password"));
                user.setGender(set.getString("gender"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }  */

}
