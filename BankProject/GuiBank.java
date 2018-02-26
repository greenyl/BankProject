package BankProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.sql.*;
public class GuiBank  extends JFrame {
	
	
	
	JPanel newAccountPanel;                         // a panel for account
	 JPanel transactionsPanel;                        // a panel for transaction
	 JButton createAccount;                          // button 
	 JRadioButton savingChoice;
	 JRadioButton checkingsChoice;
	 JRadioButton cdChoice;
	 JLabel openAccount;        
	 int id;
	           
	String name;
	JPanel bannerPanel;
	JPanel statusPanel;
	
	
	static JTextArea accountInfo;
	static JTextField nameInfo = new JTextField();
	static JTextField tAmountInfo = new JTextField();
	static JTextField idInfo = new JTextField();
	static JTextField tDateInfo = new JTextField();
	static JTextField chknmbr = new JTextField();
	static JScrollPane statusInfoScroll ;
	
	public GuiBank()
	{
		
		setTitle("JUDE Bank");                        
		setSize(250, 350);          
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setLayout(new BorderLayout());
		 buildBannerPanel();
			add(bannerPanel, BorderLayout.NORTH);
		buildAccountPanel();                                        // method to make panel
		add(newAccountPanel,BorderLayout.WEST);                // add account panel to the frame
		buildTransactionPanel();
		add(transactionsPanel, BorderLayout.EAST);
	     
		buildStatusPanel();
		add(statusPanel, BorderLayout.SOUTH);
		pack();
	   setLocationRelativeTo(null);
		setVisible(true);         
	}
	private void buildAccountPanel()               // how to make panel
	{
		
		openAccount = new JLabel("Open New Account");
		createAccount = new JButton("Create account");
		CreateAccountButtonListener accountCreator = new CreateAccountButtonListener();
		createAccount.addActionListener(accountCreator);
		
		
		savingChoice = new JRadioButton("Saving");
		checkingsChoice = new JRadioButton("Checking");
		cdChoice = new JRadioButton("Cd");
		ButtonGroup accountButtonGroup = new ButtonGroup();
		accountButtonGroup.add(savingChoice);
		accountButtonGroup.add(checkingsChoice); 
		accountButtonGroup.add(cdChoice); 
		newAccountPanel = new JPanel();
		newAccountPanel.setLayout(new GridLayout(5, 0));
		newAccountPanel.add(openAccount);
		newAccountPanel.add(savingChoice);
		newAccountPanel.add(checkingsChoice);
		newAccountPanel.add(cdChoice);
		newAccountPanel.add(createAccount);
		}
	public void buildTransactionPanel()
	{
	 JLabel	transactionLabel = new JLabel("Transactions");
	 
 
	 

	JTextField chknmbr = new JTextField();
	
	//String idnumber = GuiBank.idInfo.getText();
	 //int idnu = Integer.parseInt(idnumber);
	 //for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == idnu ) 
		// if(accnt.accountType.compareToIgnoreCase("Checking") == 0)
	
	chknmbr.setEditable(true); 
	
	JLabel checknum = new JLabel("Enter Checknumber");
	 
	JLabel  tAmount = new JLabel("Enter amount");
	 
	 tAmountInfo.setEditable(true);
	 JButton submitDeposit = new JButton("Deposit");
	 DepositButtonListener depositSubmiter = new DepositButtonListener();
		submitDeposit.addActionListener(depositSubmiter); 
		 JButton submitWithdrawal = new JButton("Withdrawal");
		 WithdrawalButtonListener withdrawalSubmiter = new WithdrawalButtonListener();
			submitWithdrawal.addActionListener(withdrawalSubmiter); 
		
		  transactionsPanel = new JPanel();
			transactionsPanel.setLayout(new GridLayout(7, 0));	
			transactionsPanel.add(transactionLabel);
			transactionsPanel.add(tAmount);
			transactionsPanel.add(tAmountInfo);
			transactionsPanel.add(checknum);
			transactionsPanel.add(chknmbr);
			transactionsPanel.add(submitDeposit);
			transactionsPanel.add(submitWithdrawal);
			
			
	}
	public void buildBannerPanel()
	{
		 bannerPanel = new JPanel();
		
		JLabel name = new JLabel("Enter name");
		
		nameInfo.setEditable(true);
		
		JLabel idNumber = new JLabel("Enter Account Id Number");
		idInfo.setEditable(true);
		
		 JLabel tDate = new JLabel("Enter date");
		  tDateInfo.setEditable(true);
	
		  bannerPanel.setLayout(new GridLayout(6, 0));	
	 bannerPanel.add(name);
		bannerPanel.add(nameInfo);
		 bannerPanel.add(idNumber);
		 bannerPanel.add(idInfo);
		 bannerPanel.add(tDate);
			bannerPanel.add(tDateInfo);
	}
	public void buildStatusPanel()
	{
		statusPanel = new JPanel();
		
		 accountInfo = new JTextArea(5,27);
		JScrollPane   statusInfoScroll = new JScrollPane(accountInfo);
		 accountInfo.setEditable(false);
		 accountInfo.setLineWrap(true);
		 accountInfo.setWrapStyleWord(true);
		// accountInfo.setFont(new Font("Monospaced", Font.PLAIN, 8));
		
		//statusInfoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 statusPanel.setLayout(new FlowLayout(  ));
		JButton statusButton = new JButton("Account status");
		StatusButtonListener statusInfo = new StatusButtonListener();
		statusButton.addActionListener(statusInfo);
		
		statusPanel.add(statusInfoScroll);
		statusPanel.add(statusButton);
	}
	private  class CreateAccountButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent w)
		{
			accountInfo.setText(" ");
			String name = null;
			 name = GuiBank.nameInfo.getText();
		String idNumber = null;
		idNumber = GuiBank.idInfo.getText();
		 int iD = Integer.parseInt(idNumber);
		 
		 AccountType accnttype = null;
			
				if (savingChoice.isSelected())
				{
					accnttype = AccountType.Saving;
			 Bank.openAccount(name, iD, accnttype );
				}
			 else if	
			 (checkingsChoice.isSelected())
			 {accnttype = AccountType.Checking;
			 Bank.openAccount(name, iD, accnttype);
				}
			 else if
		        (cdChoice.isSelected())
		 {
				 accnttype = AccountType.Cd;
		 
		 Bank.openAccount(name, iD, accnttype);	
		
		}   
				for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == iD ) 
		    		accountInfo.setText(accnt.toString());
			 
			                  System.out.println(Bank.myAccountlist);
		}
	}
	private class DepositButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent t)
		{     
			accountInfo.setText(" ");
		 String amount	= GuiBank.tAmountInfo.getText();
		 double amountDeposit = Double.parseDouble(amount);
		 String idNum	= GuiBank.idInfo.getText();
		 int iD = Integer.parseInt(idNum);
		 String input	= GuiBank.tDateInfo.getText();
		 long date = Long.parseLong(input);
			Bank.doDeposit(amountDeposit, iD,date);
			for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == iD ) 
	    		accountInfo.setText("your deposit was " + amountDeposit +" current balance is " + accnt.balance );//(accnt.toString());
		 
			System.out.println(Bank.myAccountlist);
		}   
			                  
		}
	
    private class WithdrawalButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent t)
		{     
			accountInfo.setText(" ");
			 String amount = GuiBank.tAmountInfo.getText();
			 double amountWithdrawal = Double.parseDouble(amount);
			String idNum = GuiBank.idInfo.getText();
			int iD = Integer.parseInt(idNum);
		 String input	= GuiBank.tDateInfo.getText();
		 long date = Long.parseLong(input);
		 
		 
		// String idnumber = GuiBank.idInfo.getText();
		 //int idnu = Integer.parseInt(idnumber);
		 
		for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == iD ) {
			 if(accnt.accountType.compareToIgnoreCase("Checking") == 0)
			 { String chkInfo = GuiBank.chknmbr.getText();
			 System.out.println(chkInfo);
		int  checknumber = Integer.parseInt(chkInfo);
				Bank.doWithdrawel(amountWithdrawal, iD,date,checknumber);
				} 
			 else
			 { int c = 0;
		Bank.doWithdrawel(amountWithdrawal, iD,date, c);}}
		 System.out.println(Bank.myAccountlist);
		 for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == iD ) 
	   accountInfo.setText("your withdrawal was " + amountWithdrawal +" current balance is " + accnt.balance);//accnt.toString());
		 
		}   
			                   
		}
	private class StatusButtonListener implements ActionListener
	{
		public void actionPerformed( ActionEvent h)
		{     
			 
			accountInfo.setText(" ");
	    	 String idNum	= GuiBank.idInfo.getText();
	    	 int iD = Integer.parseInt(idNum);
	    	
	    	for(Account accnt: Bank.myAccountlist) if (accnt.idNumber == iD ) 
	    		{
	    		accountInfo.setText(accnt.toString());
	    		
	    	
	    	accountInfo.append(String.format("%-12s %-12s %-10s %-10s %-8s \n", "Date", "Type", "Amount", "Number", "Chcknmbr  \n"));
	for (Transaction  trans : accnt.myTransactions)
accountInfo.append(String.format("%-10d %-10s  %-16.2f %-15d %-11d \n", trans.date, trans.type, trans.amount, +
		trans.numberTransaction, trans.checknmbr   )); //need work here
		}   
			                   
		}
          }
		public static void main (String [] args) throws SQLException
		
		
		
		{
			DataBase.fetch(); 
			 Runtime.getRuntime().addShutdownHook(new Thread(){
					
			     	public void run()  {
			     		try{
			     		DataBase.store();
			     		}
			     		catch ( Exception e)
			     		{
			     			
			     		}
			     	}
			     	}
						 );
						
						
					
			GuiBank myWindow = new GuiBank();
			System.err.println(Bank.myAccountlist);

}
}



