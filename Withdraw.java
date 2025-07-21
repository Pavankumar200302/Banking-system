package basic;

import java.util.HashMap;
import java.util.Scanner;


public class Withdraw {	
	static Scanner sc = new Scanner(System.in);
	 static void withdraw(long account_number, HashMap<Long, Double> account_info) throws AccountNotFoundException,InsufficientBalanceException {		
		 if(account_info.containsKey(account_number))
		 {
			 System.out.println("Enter amount to Withdraw");
			 	double amount = sc.nextInt();
			 	if(amount<=account_info.get(account_number))
			 	{
			 		System.out.println("Your Withdraw amount is"+amount);
			 		account_info.put(account_number,account_info.get(account_number)-amount);
			 	}
			 	else
			 	{
			 		throw new InsufficientBalanceException("Insufficient Funds");
			 	}
			}
		 else
		 {
			 throw new AccountNotFoundException("Invalid Account Number");
		 }
	}
}
