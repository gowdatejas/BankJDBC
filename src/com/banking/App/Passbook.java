package com.banking.App;

import java.util.Iterator;
import java.util.List;

import com.banking.dao.TransactionDAO;
import com.banking.dao.TransactionDAOImpl;
import com.banking.dto.Customer;
import com.banking.dto.Transaction;
import com.banking.dto.TransactionID;

public class Passbook {
public static void getPassbook(Customer c) {
	TransactionDAO tdao=new TransactionDAOImpl();
	List<Transaction> passbook=tdao.getTransaction(c.getAcc_No());
//	if(Transaction!= null && !Transaction.isEmpty()) {
	Iterator<Transaction>it=passbook.iterator();
	while(it.hasNext()) {
		Transaction t=it.next();
		System.out.println("<-------------------------------------------------------------->");
		System.out.println("TransactionID:"+t.getTrans_ID());
		System.out.println("Account_Number:"+t.getRec_ACC());
		System.out.println("Transaction Type"+t.getTran_TYPE());
		System.out.println("Transaction Date:"+t.getTran_DATE());
		if(t.getTran_TYPE().equals("CREDIT")) {
			System.out.println("+"+t.getAmount());
			System.out.println("Current Balance:"+t.getBalance());
			System.out.println("<------------------------------------------------------------>");
		}
		else {
			System.out.println("-"+t.getAmount());
			System.out.println("Current Balance:"+t.getBalance());
			System.out.println("<------------------------------------------------------------->");
		}
	}
}
}
