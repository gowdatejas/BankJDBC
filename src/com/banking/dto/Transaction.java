package com.banking.dto;

public class Transaction {

	private long trans_ID;
	private long user_ACC;
	private long rec_ACC;
	private String tran_DATE;
	private String tran_TYPE;
	private double amount;
	private double balance;
	
	public Transaction(long trans_ID, long user_ACC, long rec_ACC, String tran_DATE, String tran_TYPE, double amount,
			double balance) {
		super();
		this.trans_ID = trans_ID;
		this.user_ACC = user_ACC;
		this.rec_ACC = rec_ACC;
		this.tran_DATE = tran_DATE;
		this.tran_TYPE = tran_TYPE;
		this.amount = amount;
		this.balance = balance;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTrans_ID() {
		return trans_ID;
	}

	public void setTrans_ID(long trans_ID) {
		this.trans_ID = trans_ID;
	}

	public long getUser_ACC() {
		return user_ACC;
	}

	public void setUser_ACC(long user_ACC) {
		this.user_ACC = user_ACC;
	}

	public long getRec_ACC() {
		return rec_ACC;
	}

	public void setRec_ACC(long rec_ACC) {
		this.rec_ACC = rec_ACC;
	}

	public String getTran_DATE() {
		return tran_DATE;
	}

	public void setTran_DATE(String tran_DATE) {
		this.tran_DATE = tran_DATE;
	}

	public String getTran_TYPE() {
		return tran_TYPE;
	}

	public void setTran_TYPE(String tran_TYPE) {
		this.tran_TYPE = tran_TYPE;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [trans_ID=" + trans_ID + ", user_ACC=" + user_ACC + ", rec_ACC=" + rec_ACC + ", tran_DATE="
				+ tran_DATE + ", tran_TYPE=" + tran_TYPE + ", amount=" + amount + ", balance=" + balance + "]";
	}
	
}
