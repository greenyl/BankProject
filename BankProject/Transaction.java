package BankProject;



public class Transaction {
	long date;
	  double amount;
TransactionType type;		
int accountIdNumber;
int numberTransaction;
String c = "credit";
String d = "debit";
int checknmbr;
public Transaction(long de, double a,  String t, int chk ){
	date = de;
	amount = a;
	if(t.equalsIgnoreCase(c ))
		type = TransactionType.Credit;
		else if(t.equalsIgnoreCase(d ))
				type = TransactionType.Debit;
	checknmbr = chk;
}

public Transaction( long dte,double amnt, String tt ,int antid,  int numtrans , int cn )
{ amount = amnt;
date = dte;
if(tt.equalsIgnoreCase(c ))
type = TransactionType.Credit;
else if(tt.equalsIgnoreCase(d ))
		type = TransactionType.Debit;
accountIdNumber = antid;
 numberTransaction = numtrans;
checknmbr = cn;
}
public String toString()
{
return " date is " + date +  ", transaction type is " + type + ", amount is " + amount ;
}
}
 enum TransactionType { Credit, Debit};