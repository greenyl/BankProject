package BankProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;





public class Bank {
public static ArrayList<Account>  myAccountlist = new ArrayList<Account>() ;
    
    public Bank()
    {
    }
    
    public static void openAccount(String name,int idNumber, AccountType accnttype  )
    {
        switch (accnttype)
        {
        case Saving:
        	Saving s =  new Saving(name, idNumber);
        	
        	myAccountlist.add(s);
        	
          break;
        case Checking:
         Checkings ch =	new Checkings(name, idNumber);
        	myAccountlist.add(ch);
        	break;
        case  Cd:
        	Cd c =  new Cd(name, idNumber);
        	myAccountlist.add(c);
        	break;
        	default:
        		System.out.println("not valid"); 
        		break;
        }
    	
    
    }
    
   
    public static void doDeposit(double a,  int n, long dte  )
	{
    	 
    	
    	for(Account accnt: myAccountlist) if (accnt.idNumber == n) 
    	{ 
    		accnt.creditBalance(a);
    		String tp = "credit";
    		int ch = 0;
             Transaction t = new Transaction(dte,a,  tp, ch);
             
             accnt.addTransaction(t);
    	
    	}
    
    	}
	public static void doWithdrawel(double a, int n, long dte,  int chnmbr  )
	{   
		for (Account act: myAccountlist) if(act.idNumber == n )

		
			act.debitBalance(a, dte,  chnmbr);
			
			
		
	} 
}  
	
	
	
			



