package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.connectors.ConnectionFactory;
import com.banking.dto.Transaction;
import com.mysql.cj.protocol.Resultset;

public class TransactionDAOImpl implements TransactionDAO {
	private Connection con;
	
	public TransactionDAOImpl() {
		this.con=ConnectionFactory.requestConnection();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertTransaction(Transaction t) {
		PreparedStatement ps=null;
		String query="INSERT INTO PASSBOOK(TRAN_ID,USER_ACC,REC_ACC,TRAN_DATE,TRAN_TYPE,AMOUNT,BALANCE)"+"VALUES(?,?,?,sysdate(),?,?,?)";
		int res=0;
		try {
			con=ConnectionFactory.requestConnection();
			 con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setLong(1, t.getTrans_ID());
			ps.setLong(2, t.getUser_ACC());
			ps.setLong(3, t.getRec_ACC());
			ps.setString(4, t.getTran_TYPE());
		//	ps.setDate(5, d);
			ps.setDouble(5, t.getAmount());
			ps.setDouble(6, t.getBalance());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0) {
			try {
				con.commit();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}


	@Override
	public List<Transaction> getTransaction(long user) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query="SELECT * FROM PASSBOOK WHERE USER_ACC=? ORDER BY TRAN_DATE desc";
		Transaction t=null;
		ArrayList<Transaction> passbook=new ArrayList<Transaction>();
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, user);
			rs=ps.executeQuery();
			while(rs.next()) {
				t=new Transaction();
				t.setTrans_ID(rs.getLong(1));
				t.setUser_ACC(rs.getLong(2));
				t.setRec_ACC(rs.getLong(3));
				t.setTran_DATE(rs.getString(4));
				t.setTran_TYPE(rs.getString(5));
				t.setAmount(rs.getDouble(6));
				t.setBalance(rs.getDouble(7));
				passbook.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return passbook;
	}
@Override
public List getTransaction() {
	PreparedStatement ps=null;
	ResultSet rs=null;
	String query="SELECT * FROM PASSBOOK ORDER BY TRAN_DATE desc";
	Transaction t=null;
	ArrayList<Transaction> passbook=new ArrayList<Transaction>();
	try {
		ps=con.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next()) {
			t=new Transaction();
			t.setTrans_ID(rs.getLong(1));
			t.setUser_ACC(rs.getLong(2));
			t.setRec_ACC(rs.getLong(3));
			t.setTran_DATE(rs.getString(4));
			t.setTran_TYPE(rs.getString(5));
			t.setAmount(rs.getDouble(6));
			t.setBalance(rs.getDouble(7));
			passbook.add(t);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return passbook;
	
}
}
