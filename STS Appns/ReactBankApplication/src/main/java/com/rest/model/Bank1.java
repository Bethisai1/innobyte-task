package com.rest.model;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class Bank1 {
	@Id
	private String accountNumber;
	private String name;
	private String  password;
	private double amount;
	private String address;
	private long mobile_no;
	
	@Enumerated(EnumType.STRING)
	private Accountstatus status = Accountstatus.active;

	public enum Accountstatus{
		active,inactive
	}

	public Bank1() {
		super();
		
	}

	public Bank1(String accountNumber, String name, String password, double amount, String address, long mobile_no,
			Accountstatus status) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobile_no = mobile_no;
		this.status = status;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Accountstatus getStatus() {
		return status;
	}

	public void setStatus(Accountstatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bank1 [accountNumber=" + accountNumber + ", name=" + name + ", password=" + password + ", amount="
				+ amount + ", address=" + address + ", mobile_no=" + mobile_no + ", status=" + status + "]";
	}
	

}
	
