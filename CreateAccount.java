package basic;

import java.util.ArrayList;
public class CreateAccount {
	private long aadhar;
private long phone;
private String name;
public long account_number;

	public CreateAccount(long aadhar, long phone, String name) {
    this.aadhar = aadhar;
    this.phone = phone;
    this.name = name;
}

	public ArrayList<String> add_details() {
    ArrayList<String> a = new ArrayList<>();
    a.add(this.name);
    a.add(String.valueOf(this.aadhar));
    a.add(String.valueOf(this.phone));
    a.add(String.valueOf(this.account_number));
    return a;
}

	
}
