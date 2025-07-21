package basic;
import java.util.HashMap;
import java.util.Scanner;



public class TransferringMoney {
	static int chances=3;
	static Scanner sc = new Scanner(System.in);
	static void transaction(long account_number, HashMap<Long, Double> account_info) throws AccountNotFoundException, InsufficientBalanceException {		
		if(account_info.containsKey(account_number))
		{
			System.out.println("Enter an account number to Transfer your money");			
			long acc_no = sc.nextLong();			
			System.out.println("enter amount to transfer");			
			double amount = sc.nextDouble();			
			if(account_info.containsKey(acc_no))
			{
				if(amount<account_info.get(account_number))
				{
					account_info.put(account_number,account_info.get(account_number)-amount);
					account_info.put(acc_no,account_info.get(acc_no)+amount);
				}
				else
				{
					throw new InsufficientBalanceException("Insufficient Balance");
				}
			}
			else if(chances!=1)
			{
				System.out.println("Account Number is Invalid");
				System.out.println("Try Again");
				chances--;
				transaction(account_number,account_info);
			}
			else
			{
				throw new AccountNotFoundException("Invalid Account Number");
			}
		}
	}	
}
