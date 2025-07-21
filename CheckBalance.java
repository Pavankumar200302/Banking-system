package basic;

import java.util.HashMap;
import java.util.Scanner;


public class CheckBalance {
	static int chances=3;
	static Scanner sc = new Scanner(System.in);
	static void checkBalance(long account_number,HashMap<Long,Double> account_info) throws AccountNotFoundException
	{	
		if(account_info.containsKey(account_number))
		{
			System.out.println("Your Balance is:");
			System.out.println(account_info.get(account_number));
		}
		else if(chances!=1)
		{
			System.out.println("Your Account Number is Invalid");
			System.out.println("Try Again");
			chances--;
			account_number = sc.nextLong();
			checkBalance(account_number,account_info);
		}
		else 
		{	
			throw new AccountNotFoundException("Invalid Account Number");	
		}
	}
}
