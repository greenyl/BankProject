package BankProject;

public class CheckTransaction extends Transaction {
 
  
 public CheckTransaction( long date, double amount,  String tt ,int idnbr,  int nmbrtrans,int chknm  )
  {
	  super(date,amount ,  tt, idnbr, nmbrtrans , chknm);
	  
	  
  }
  public CheckTransaction (long dt, double a, String t, int cn){
	  super(dt,a ,  t, cn );
	 
  }
}
