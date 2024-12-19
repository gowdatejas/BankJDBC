package com.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.banking.connectors.ConnectionFactory;
import com.banking.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO{
private Connection con;

	public CustomerDAOImpl() {
	this.con = ConnectionFactory.requestConnection();
}

	@Override
	public boolean insertCustomer(Customer c) {
		PreparedStatement ps=null; 
		String query="INSERT INTO CUSTOMER(NAME,PHONE,EMAIL,PIN)VALUES(?,?,?,?)"; 
		int res=0; 
		try { 
		con.setAutoCommit(false); 
		ps=con.prepareStatement(query); 
		   ps.setString(1,c.getName()); 
		   ps.setLong(2, c.getPhone()); 
		   ps.setString(3, c.getEmail()); 
		   ps.setInt(4, c.getPin()); 
		   res=ps.executeUpdate();   
		  } catch (SQLException e) { 
		   e.printStackTrace(); 
		  } 
		  if(res>0) 
		  { 
			  try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return true; 
		  } 
		  else 
		  {  
			  try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomer(long acc_No, int pin) {
		PreparedStatement ps=null; 
		  ResultSet rs=null; 
		  Customer c=null; 
		  String query="SELECT * FROM CUSTOMER WHERE ACC_NO=? AND PIN=?";
		  try {
			ps=con.prepareStatement(query);
			ps.setLong(1,acc_No); 
			   ps.setInt(2, pin); 
			   rs=ps.executeQuery(); 
			   if(rs.next()) 
			   { 
			    c=new Customer(); 
			    c.setAcc_No(rs.getLong(1)); 
			    c.setName(rs.getString(2)); 
			    c.setPhone(rs.getLong(3)); 
			    c.setEmail(rs.getString(4)); 
			    c.setBalance(rs.getDouble(5)); 
			    c.setPin(rs.getInt(6)); 
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Customer getCustomer(long phone, String email) {
		PreparedStatement ps=null; 
		  ResultSet rs=null; 
		  Customer c=null; 
		  String query="SELECT * FROM CUSTOMER WHERE PHONE=? AND EMAIL=?";
		  try {
			ps=con.prepareStatement(query);
			ps.setLong(1,phone); 
			   ps.setString(2, email); 
			   rs=ps.executeQuery();  
			   if(rs.next()) 
			  { 
			    c=new Customer(); 
			    c.setAcc_No(rs.getLong(1)); 
			    c.setName(rs.getString(2)); 
			    c.setPhone(rs.getLong(3)); 
			    c.setEmail(rs.getString(4)); 
			    c.setBalance(rs.getDouble(5)); 
			    c.setPin(rs.getInt(6)); 
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public Customer getCustomer(long acc_No) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=?";
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, acc_No);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				c=new Customer();
				c.setAcc_No(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setEmail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public List getCustomer() {
		PreparedStatement ps=null;
		ArrayList<Customer> customers=new ArrayList<Customer>();
		ResultSet rs=null;
		Customer c=null;
		String query="SELECT * FROM CUSTOMER";
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				c=new Customer();
				c.setAcc_No(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPhone(rs.getLong(3));
				c.setEmail(rs.getString(4));
				c.setBalance(rs.getDouble(5));
				c.setPin(rs.getInt(6));
				customers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		PreparedStatement ps=null;
		int res=0;
		String query="UPDATE CUSTOMER SET NAME=?,PHONE=?,EMAIL=?,BALANCE=?,PIN=? WHERE ACC_NO=?";

		try {
		    con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getEmail());
			ps.setDouble(4, c.getBalance());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAcc_No());
			res=ps.executeUpdate();
		}
		catch (SQLException e) {
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
	public boolean deleteCustomer(Customer c) {
		PreparedStatement ps=null;
		int res=0;
		String query="DELETE FROM CUSTOMER WHERE ACC_NO=?";
		try {
			con.setAutoCommit(false);
			ps=con.prepareStatement(query);
			ps.setLong(1, c.getAcc_No());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else {
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

}
