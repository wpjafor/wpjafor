package models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="accounts")
@XmlRootElement
public class Account {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountID")
	int id;
	@Column(name="custID")
	int custID;
	@Column(name="account_name")
	String accountname;
	@Column(name="currency")
	String accounttype;
	@Column(name="balance")
	double amount;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, int custID, String accountname, String accounttype, double amount) {
		super();
		this.id = id;
		this.custID = custID;
		this.accountname = accountname;
		this.accounttype = accounttype;
		this.amount = amount;
	}
	public Account(int custID, String accountname, String accounttype, double amount) {
		super();
		this.custID = custID;
		this.accountname = accountname;
		this.accounttype = accounttype;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
