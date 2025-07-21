package basic;

import java.util.Random;
import java.util.Scanner;



import java.util.ArrayList;
import java.util.HashMap;
import basic.CreateAccount;
import basic.CheckBalance;
public class MainClass {
	public static void main(String[] args) throws Exception {
		ArrayList<ArrayList> all_details = new ArrayList();
		Random random = new Random();
		int flag=0;
		int account_count=0;
		String user_name="PavanKumarreddy";
		String Password="Pavan@2003";
		HashMap<Long,Double> account_info = new HashMap<Long,Double>();
		System.out.println("Welcome...");
		
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Create Account\n2.Check Balance\n3.Deposit Money\n4.Transferring Money\n5.Withdraw\n6.Display Details");
			System.out.println("Select option 1-6");
			int choice= sc.nextInt();
			ArrayList details = new ArrayList();
			switch(choice)
			{
			case 1:
				System.out.println("Enter holder name");
				String holder_Name = sc.next();
				System.out.println("Enter your aadhar number");
				long aadharNo = sc.nextLong();
				System.out.println("Enter your phone number");
				long PhoneNo = sc.nextLong();
				CreateAccount ca = new CreateAccount(aadharNo,PhoneNo,holder_Name);
				long min=10000000000000L;
				long max=99999999999999L;
				long acc_no = min+(int)(random.nextDouble()*(max-min));
				if(acc_no<0)
				{
					acc_no*=-1;	
				}
				account_info.put(acc_no,0.0);
			    System.out.println("Your generated Account Number is "+acc_no);
			    ca.account_number=acc_no;
			    account_count++;
			    //System.out.println(account_info);
			    all_details.add(ca.add_details());
			    //System.out.println(all_details);
			    details.clear();
			    break;  
			    
			case 2:
				//Check Balance
				System.out.println("Enter your 14-digit Account number");
				long account_number = sc.nextLong();
				try
				{
					CheckBalance.checkBalance(account_number,account_info);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e);
				}
				break;
				
			case 3:
				//Deposit Money
				System.out.println("Enter your 14-digit Account number");
				account_number = sc.nextLong();
				try
				{
					DepositMoney.depositMoney(account_number,account_info);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e);
				}
				break;
			case 4:
				//Transfer Money
				System.out.println("Enter your 14-digit Account number");
				
				account_number = sc.nextLong();
				try {
					TransferringMoney.transaction(account_number,account_info);
				}
				catch(InsufficientBalanceException e)
				{
					System.out.println(e);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e);
				}
				break;
				
			case 5:
				//Withdraw
				System.out.println("Enter your 14-digit Account number");
				account_number = sc.nextLong();
				try {
					Withdraw.withdraw(account_number,account_info);
				}
				catch(InsufficientBalanceException e)
				{
					System.out.println(e);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println(e);
				}
				break;
				
			case 6:
				try
				{
					if(DisplayDetails.authorization(user_name, Password))
					{
						DisplayDetails.displayAll(all_details,account_count);
					}
					else
					{
						System.out.println("You are unable to log in");
					}
				}
				catch(NoAccountsException e)
				{
					System.out.println(e);
				}
				break;
			}
			System.out.println("Enter 1 to Continue");
			flag=sc.nextInt();
			if(flag!=1)
			{
				break;
			}
		}while(flag==1);	
	}
}
