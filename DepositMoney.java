package basic;
import java.util.HashMap;
import java.util.Scanner;



public class DepositMoney {
	static Scanner sc = new Scanner(System.in);	
    static void depositMoney(long account_number, HashMap<Long, Double> account_info) throws AccountNotFoundException{			
		if(account_info.containsKey(account_number))
		{
			System.out.println("Enter how much amount you want to deposit");
			
			double amount = sc.nextDouble();
			
			account_info.put(account_number, amount);
		}
		else
		{
			throw new AccountNotFoundException("Invalid Account Number");
		}
	}
}
