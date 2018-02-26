package BankProject;



public class Saving 
	extends Account  {
		
		
		double interestRate;
		public static String  acnttype = "Saving";
		 public Saving(String nme, int idn  )	                        
		 {     
			 super(nme, idn, acnttype);
		  
		 }
		
		
}
