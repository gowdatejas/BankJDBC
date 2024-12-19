package com.banking.dto;

public class Customer {
	//INSTANCE VARIABLE
	private long acc_No;
	private String name;
	private long phone;
	private String email;
	private double balance;
	private int pin;
	public Customer(long acc_No, String name, long phone, String email, double balance, int pin) {
		super();
		this.acc_No = acc_No;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.balance = balance;
		this.pin = pin;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getAcc_No() {
		return acc_No;
	}
	public void setAcc_No(long acc_No) {
		this.acc_No = acc_No;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Customer [acc_No=" + acc_No + ", name=" + name + ", phone=" + phone + ", email=" + email + ", balance="
				+ balance + "]";
	}
	
}
