package com.banking.App;

import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dao.TransactionDAO;
import com.banking.dao.TransactionDAOImpl;
import com.banking.dto.Customer;
import com.banking.dto.Transaction;
import com.banking.dto.TransactionID;

public class TransferAmount {
public static void transferAmount(Customer c) {
	CustomerDAO cdao= new CustomerDAOImpl();
	Transaction t1=null;
	Transaction t2=null;
	TransactionDAO tdao=new TransactionDAOImpl();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the amount to be transfered");
	double amount=sc.nextDouble();
	System.out.println("Enter the Benefiviary Account number");
	long rec_acc=sc.nextLong();
	Customer receiver =cdao.getCustomer(rec_acc);
	
	if(c.getAcc_No()!=receiver.getAcc_No() && c.getBalance()>0 && c.getBalance()>=amount && amount>0)
	{
		System.out.println("Enter the PIN");
		int pin=sc.nextInt();
		if(pin==c.getPin())
		{
			c.setBalance(c.getBalance()-amount);
			boolean c_res=cdao.updateCustomer(c);
			
			if(c_res)
			{
				t1=new Transaction();
				t1.setTrans_ID(TransactionID.generateTransactionId());
				t1.setUser_ACC(c.getAcc_No());
				t1.setRec_ACC(receiver.getAcc_No());
				t1.setTran_TYPE("DEBITED");
				t1.setAmount(amount);
				t1.setBalance(c.getBalance());
				boolean res1=tdao.insertTransaction(t1);
			}
			receiver.setBalance(receiver.getBalance()+amount);
			boolean receiver_res=cdao.updateCustomer(receiver);
			if(receiver_res) {
				{
					t2=new Transaction();
					t2.setTrans_ID(t1.getTrans_ID());
					t2.setUser_ACC(receiver.getAcc_No());
					t2.setRec_ACC(c.getAcc_No());
					t2.setTran_TYPE("CREDITED");
					t2.setAmount(amount);
					t2.setBalance(receiver.getBalance());
					boolean res1=tdao.insertTransaction(t2);
				}
			}
			if(c_res && receiver_res)
			{
				System.out.println("Transaction Succesfull");
			}
			else {
				System.out.println("Transaction Failed !!!");
			}
		}
	}
	else {
		System.out.println("Transaction Failed !!!");
	}
}
}
