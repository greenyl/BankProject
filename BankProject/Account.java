package BankProject;


import java.util.ArrayList;



public class Account {
	String name;
	double balance  ;
	int idNumber;
	String accountType ;
   public  ArrayList< Transaction> myTransactions = new ArrayList<Transaction> ();
	
	public Account(String nm, int idnumber , String accttype, double blnce){
		name = nm;
		idNumber = idnumber;
		balance = blnce;
		accountType = accttype;
		}
	public Account(String nme, int idn , String at){
		name = nme;
		idNumber = idn;
	
		accountType = at;
	}
	public void creditBalance(double a)
	{balance += a;
 
	}
	public void debitBalance(double b , long date,  int cknmbr)
	{balance -= b;
	

		String tp = "debit";
		
		if(cknmbr == 0)
		{	
		Transaction t = new Transaction(date,b, tp, cknmbr);
	addTransaction(t);}
	}
	
	
		
	
	
	public String toString()
	{
		return "Name is " + name + "   " + "Id Number is " + idNumber + " " + "Balance is " + balance + "\n" ;
	}
public void addTransaction(Transaction b){
	myTransactions.add(b);
}
 }
enum AccountType{Saving,Checking,Cd}