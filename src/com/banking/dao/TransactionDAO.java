package com.banking.dao;

import java.util.List;

import com.banking.dto.Transaction;

public interface TransactionDAO {
	public boolean insertTransaction(Transaction t); 
	public List getTransaction(long user); 
	public List getTransaction();
}
