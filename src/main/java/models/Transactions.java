package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="transaction")
@XmlRootElement
public class Transactions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transID")
	int id;
	@Column(name="CustID")
	int customerid;
	@Column(name="accID")
	int accountid;
	@Column(name="transtype")
	String tranactiontype;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="balance")
	
	double balance;
	String date;
	public Transactions(int customerid, int accountid, String tranactiontype, double balance) {
		super();
		this.customerid = customerid;
		this.accountid = accountid;
		this.tranactiontype = tranactiontype;
		this.balance = balance;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
 	   LocalDateTime now = LocalDateTime.now(); 
 	   this.date = dtf.format(now);
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int id, int customerid, int accountid, String tranactiontype, double balance) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.accountid = accountid;
		this.tranactiontype = tranactiontype;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getTranactiontype() {
		return tranactiontype;
	}
	public void setTranactiontype(String tranactiontype) {
		this.tranactiontype = tranactiontype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
