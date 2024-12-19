package com.banking.App;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dao.TransactionDAO;
import com.banking.dao.TransactionDAOImpl;
import com.banking.dto.Customer;
import com.banking.dto.Transaction;
import com.banking.dto.TransactionID;

public class Admin {
public static void admin(Customer c) {
	Scanner sc=new Scanner(System.in);
	int choice=0;
	CustomerDAO cdao=new CustomerDAOImpl();
	TransactionDAO tdao=new TransactionDAOImpl();
	do {
		System.out.println("1. Get Account Data");
		System.out.println("2. Get Transaction List");
	    System.out.println("3. Delete any user");
	    System.out.println("4. Access your account");
	    System.out.println("5. Back to main menu");
	    choice =sc.nextInt();
	    switch(choice) {
	    case 1:
	    {
	    	System.out.println("<==============================Customer Data======================>");
	    	List<Customer> customers=cdao.getCustomer();
	    	Iterator<Customer> it=customers.iterator();
	    	while(it.hasNext()) {
	    		Customer c1=it.next();
	    		System.out.println(c1);
	    	}
	    	break;
	    }
	    case 2:
	    {
	    	System.out.println("<==============================Transaction Data===================>");
	    	List<Transaction> transactions=tdao.getTransaction();
	    	Iterator<Transaction> it=transactions.iterator();
	    	while(it.hasNext()) {
	    		Transaction t1=it.next();
	    		System.out.println(t1);
	    	}
	    	break;
	    }
	    case 3:
	    {
	    	System.out.println("Enter the Account Number of the user to be deleted:");
	    	Customer c1=cdao.getCustomer(sc.nextLong());
	
	    	if(c.getAcc_No()!=c1.getAcc_No()) {
	    	double amount=c1.getBalance();
	    	c.setBalance(c.getBalance()+amount);
	    	boolean res1=cdao.updateCustomer(c);
	    	
	    	if(res1) {
	    		Transaction t1=new Transaction();
	    		t1.setTrans_ID(TransactionID.generateTransactionId());
	    		t1.setUser_ACC(c.getAcc_No());
	    		t1.setRec_ACC(c1.getAcc_No());
	    		t1.setAmount(amount);
	    		t1.setTran_TYPE("CREDITED");
	    		t1.setBalance(c.getBalance());
	    		boolean res=tdao.insertTransaction(t1);
	    		
	    		if(res1 && res) {
	    			System.out.println("Proceeding to delete......! Account Has Been Deleted");
	    			cdao.deleteCustomer(c1);
	    		}
	    		else {
	    			System.out.println("Failed to delete");
	    		}
	    }
	    	else {
	    		System.err.println("Failed to delete; Amount transfer failed from the customer account");
	    	}
	    	}
	    	else {
	    		System.out.println("Cannot delete the Admin data");
	    	}
	    	break;
	    }
	    case 4:
	    		App.options(c);
	    		break;
	    
	    case 5: System.out.println("Going Back to the Main Menu");
	    		break;
	    		
	    		default:System.out.println("Invalid Choice!. Enter the correct choice!");
	    }
	}
	while(choice!=5);
}
}
