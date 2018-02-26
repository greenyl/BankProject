package BankProject;



public class Cd extends Account {
	long maturityDate = 0;
	double CdInterestRate = 0;
	public static String  acntyp = "Cd";
	public Cd(String nme, int idn)
	{
		super(nme, idn, acntyp);
		

	}
	


}
