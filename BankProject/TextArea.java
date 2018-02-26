package BankProject;
import java.awt.Font;
import javax.swing.*;
public class TextArea extends JFrame {
	public static void main(String[] args) {
		JTextArea tArea = new JTextArea (3, 40) ;
		tArea.setFont(new Font ("Monospaced" , Font.BOLD , 48));
      tArea.setEditable(false);
      
      tArea.append(String.format("%-10s %5.2f \n", "Minyan", 10.));
      tArea.append( String.format("%-10s %5.2f \n", "Mzumin", 3.));
      tArea.insert( String.format("%-10s %5.2f \n", "Aydim", 2.) ,36);
      tArea.insert( String.format("%-10s %-10s \n", "Group", "QTY"), 0 );
      
      JScrollPane sPane = new JScrollPane( tArea );
      
      TextArea frame = new TextArea();
      frame.setSize(500, 400);
      frame.add(sPane);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.setVisible(true);
	}  
}
