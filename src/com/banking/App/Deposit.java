package com.banking.App;

import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dao.TransactionDAO;
import com.banking.dao.TransactionDAOImpl;
import com.banking.dto.Customer;
import com.banking.dto.Transaction;
import com.banking.dto.TransactionID;

public class Deposit {
public static void deposit(Customer c) {
	CustomerDAO cdao=new CustomerDAOImpl();
	TransactionDAO tdao=new TransactionDAOImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the amount to be Deposited");
	double amount=sc.nextDouble();
	c.setBalance(c.getBalance()+amount);
	boolean res=cdao.updateCustomer(c);
	if(res) {
		Transaction t=new Transaction();
		t.setTrans_ID(TransactionID.generateTransactionId());
		t.setUser_ACC(c.getAcc_No());
		t.setRec_ACC(c.getAcc_No());
		t.setTran_TYPE("CREDIT");
		t.setAmount(amount);
		t.setBalance(c.getBalance());
		boolean res1=tdao.insertTransaction(t);
		if(res) {
			System.out.println("Amount of Rs. "+amount+" has been added Succesfully!");
			System.out.println("Your updated Balance is Rs. "+c.getBalance());
		}
		else {
			System.out.println("Failed to Deposit! Try Again later");
		}
	}
}
}
