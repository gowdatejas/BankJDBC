package com.banking.App;

import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dto.Customer;

public class Login {
	public static void login() 
	{ 
	Scanner sc=new Scanner(System.in); 
	CustomerDAO cdao=new CustomerDAOImpl();
	
	System.out.println("Enter your Account number"); 
	long accno=sc.nextLong(); 
	System.out.println("Enter your PIN"); 
	int pin=sc.nextInt(); 
	Customer c=cdao.getCustomer(accno, pin); 
	if(c!=null) 
	{ 
		if(c.getAcc_No()==1100110011)
		{
			System.out.println("Welcome Admin: "+c.getName());
			Admin.admin(c);
		}
		else {
			System.out.println("Login Successful!");
			App.options(c);
		}
	}
	else 
	{ 
	System.out.println("Failed to login!"); 
	}   
	}
}
