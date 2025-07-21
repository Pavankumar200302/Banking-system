package basic;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayDetails{
	static Scanner sc = new Scanner(System.in);
	static void displayAll(ArrayList<ArrayList> all_details,int account_count) throws NoAccountsException
	{
		if(account_count>=1)
		{
			System.out.println("Aadhar No Phone Number Holder Name Account Number");
			for(int i=0;i<account_count;i++)
			{
				System.out.println(all_details.get(i));
			}
		}
		else
		{
			throw new NoAccountsException("No Account Information");
		}
    }
	static boolean authorization(String user_name,String Password)
	{
		System.out.println("To display details information.Log in");
		System.out.println("Enter user name");
		String username=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		if(username.equals(user_name) && pass.equals(Password))
		{
			return true;
		}
		return false;
	}
}
