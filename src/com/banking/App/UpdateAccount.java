package com.banking.App;

import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dto.Customer;

public class UpdateAccount {
public static void updateAccount(Customer c) {
	Scanner sc=new Scanner(System.in);
	int choice=0;
	CustomerDAO cdao=new CustomerDAOImpl();
	System.out.println("Enter your field to be updated");
	do {
		System.out.println("1. Name");
		System.out.println("2. Phone Number");
		System.out.println("3. Email ID");
		choice =sc.nextInt();
		switch(choice) {
		case 1:
		{
			System.out.println("Enter the new name:");
			c.setName(sc.next());
			boolean res=cdao.updateCustomer(c);
			
			if(res)
			{
				System.out.println("Name updated to "+c.getName()+" Successfully");
			}
			else {
				System.out.println("Failed to update the name");
			}
			break;
		}
		case 2:
		{
			System.out.println("Enter the Phone number to be updated:");
			c.setPhone(sc.nextLong());
			boolean res=cdao.updateCustomer(c);
			
			if(res) {
				System.out.println("Phone number updated to "+c.getPhone()+" successfully");
			}
			else {
				System.out.println("Failed to update the phone Number");
			}
			break;
		}
		case 3:
		{
			System.out.println("Enter the Email ID to be updated:");
			c.setEmail(sc.next());
			boolean res=cdao.updateCustomer(c);
			
			if(res) {
				System.out.println("Email ID Updated to "+c.getEmail()+" successfully");
			}
			else {
				System.out.println("Failed to update the Mail ID");
			}
			break;
		}
		case 4: System.out.println("Exit to Main Menu");
		break;
		
		default:System.out.println("Invalid Choice!. Enter the correct choice!");
		}
	}
	while(choice!=4);
}
}
