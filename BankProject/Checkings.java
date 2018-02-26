package BankProject;



public class Checkings extends Account{
	int overDraftFee = 50;	
	double checkingInterestRate = 0.0;
	static String  acntype = "Checking";
	public Checkings(String nme, int idn )
		{
		super(nme, idn, acntype );
	
		
		}
public void  debitBalance(double b, long date, int chknr)
{
		if (b > balance ) b = overDraftFee;
	
		String tp = "debit";
		CheckTransaction t = new CheckTransaction(date, b, tp,chknr);
		addTransaction(t);
		

super.debitBalance(b, date, chknr );		
}
}