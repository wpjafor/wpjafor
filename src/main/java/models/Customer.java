package models;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	String name;
	String address;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CustID")
	int Id;
	@Column(name="customer_email")
	String email;
	@Column(name="phone_number")
	int phonenumber;
	@Column(name="login_id")
	String loginID;
	@Column(name="password")
	String password;
	public String getName() {
		return name;
	}
	public Customer() {
		
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String address, int id, String email, int phonenumber, String loginID, String password) {
		super();
		this.name = name;
		this.address = address;
		Id = id;
		this.email = email;
		this.phonenumber = phonenumber;
		this.loginID = loginID;
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
