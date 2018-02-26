package BankProject;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class DataBase {
public  DataBase(){}
 public static String DB_URL = "jdbc:derby:D:\\JavaDataBase\\Bank;create=true;";

public static void fetch() throws SQLException {
	Connection conn = DriverManager.getConnection(DB_URL);
	 Statement stat = conn.createStatement();
	 String sqlAccStatement = "select * from Accounts ";
	// String sglTransStatement = "'select from Transactions where ac.idNumber=Transaction.accountidnumber'";
	// System.err.println(sqlAccStatement);
	 ResultSet  rs = stat.executeQuery(sqlAccStatement);
	 while (rs.next())
	 {
	 	Bank.myAccountlist.add(
	 			new Account
	 			(
	 					rs.getString(1),
	 					rs.getInt(2),
	 					rs.getString(3),
	 					rs.getDouble(4)
	 			));		
	 			
	 }
	 for (Account ac : Bank.myAccountlist)
		 {String sqlTransStatement = "select * from Transactions where  accountidnumber = " + ac.idNumber +" order by numbertransaction ";
	 ResultSet  rs2 = stat.executeQuery(sqlTransStatement);
	 while (rs2.next())
	 {
		 int a  = rs2.getInt(6);
	if(a == 0)
		 
	    ac.myTransactions.add(
	 			new Transaction
	 			(
	 					rs2.getLong(1),
	 					rs2.getDouble(2),
	 					rs2.getString(3),
	 					rs2.getInt(4),
	 					rs2.getInt(5),
	 					rs2.getInt(6)  )
	 			);
	 
	else if(a > 0)  ac.myTransactions.add(
 			new CheckTransaction
 			(
 					rs2.getLong(1),
 					rs2.getDouble(2),
 					rs2.getString(3),
 					rs2.getInt(4),
 					rs2.getInt(5),
 					rs2.getInt(6)
 					)
 			);
		 } }
	 stat.close();
	 }
       
public static void insertRow(String sql) throws SQLException {
Connection conn = DriverManager.getConnection(DB_URL);
			 Statement stat = conn.createStatement(); 
		System.err.println("about to do execute update");
		


stat.executeUpdate(sql);
stat.close() ;
conn.close();
}


public static void store() throws SQLException {         
	Connection conn = DriverManager.getConnection(DB_URL);
	 Statement stt = conn.createStatement(); 
	stt.executeUpdate("delete from Accounts");
	stt.executeUpdate("delete from Transactions");
	stt.close();
	conn.close();
	for(Account a : Bank.myAccountlist)
	{
String sqlAccntInfo = "insert into Accounts(name, idnumber,accounttype,balance ) values(" +  "'" + a.name +"', " +  a.idNumber + ", '" +a.accountType +"', " + a.balance + ") " ;
System.err.println("insert into Accounts(name, idnumber,accounttype,balance ) values(" +  "'" + a.name +"', " +  a.idNumber + ", '" +a.accountType +"', " + a.balance + ") ") ;

DataBase.insertRow(sqlAccntInfo);
for (Transaction tr : a.myTransactions)
{
String sqlTransInfo = " insert into Transactions ( date, amount, transactiontype, accountidnumber, checknumber  ) values (" + tr.date +" , "+ tr.amount +" , '"+ tr.type+ "' , " + tr.accountIdNumber + " , " + tr.checknmbr + ")";
System.err.println(" insert into Transactions ( date, amount, transactiontype, accountidnumber, checknumber  ) values (" +
tr.date +" , "+ tr.amount +" , ' "+ tr.type+ "' , " + tr.accountIdNumber+" , " + tr.checknmbr + ")");
DataBase.insertRow(sqlTransInfo);
	
}
}
	}
}




    






