package com.banking.App;

import java.util.Scanner;

import com.banking.dao.CustomerDAO;
import com.banking.dao.CustomerDAOImpl;
import com.banking.dto.Customer;

public class ResetPin {
public static void resetPin(Customer c) {
	Scanner sc=new Scanner(System.in);
	CustomerDAO cdao=new CustomerDAOImpl();
	System.out.println("Enter the Phone Number");
	long phone=sc.nextLong();
	System.out.println("Enter your Mail ID");
	String email=sc.next();
	if(phone==c.getPhone() && email.equals(c.getEmail()))
	{
		System.out.println("Set a new Pin");
		int pin =sc.nextInt();
		System.out.println("Confirm the Pin");
		int confirm=sc.nextInt();
		if(pin==confirm)
		{
			c.setPin(pin);
			boolean res=cdao.updateCustomer(c);
			
			if(res) {
				System.out.println("Pin Updated Succesfully");
			}
			else {
				System.out.println("Failed to Update the PIN");
			}
		}
		else {
			System.out.println("Pin mismatch or incorrect PIN");
		}
	}
	else {
		System.out.println("Incorrect Phone number or Emial ID");
	}
}
}
