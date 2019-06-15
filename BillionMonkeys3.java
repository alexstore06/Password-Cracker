import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class BillionMonkeys3 implements ActionListener {
	JFrame myFrame;
	JButton go;
	JTextField target;
	JTextField output;
	public static void main(String[] args) {
		new BillionMonkeys3();
	} 
	public BillionMonkeys3() {
	      myFrame = new JFrame(); 
	      FlowLayout myLayout = new FlowLayout(); // create a layout manager
	      myFrame.setLayout(myLayout);  
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      JPanel mainPanel = (JPanel)myFrame.getContentPane();
	      JLabel wordLabel = new JLabel("Enter the word you want to find:");
	      mainPanel.add(wordLabel);
	      target = new JTextField(20);
	      mainPanel.add(target);
	      go = new JButton("Go");
	      go.addActionListener(this);
	      mainPanel.add(go);
	      JLabel outputLabel = new JLabel("Output:");
	      mainPanel.add(outputLabel);
	      output = new JTextField(50);
	      mainPanel.add(output);
	      myFrame.pack();
	      myFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object control = e.getSource();
		if(control == go) {
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","~","`","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",";",":","'","\"",",","<",".",">","/","?"};
		String word = target.getText();
		String foundword = "";
		Random r=new Random();
		int rand;
		boolean found = false;
		long j = 0;
		Calendar c = Calendar.getInstance();
		double tStart = c.getTimeInMillis();
		double tEnd;
		double tTotal;
        long per;
		while(found == false) {
			for(int i = 0; i<=word.length(); i++) {
			rand = r.nextInt(alphabet.length);
			foundword += alphabet[rand];
			if(foundword.equals(word)) {
				c = Calendar.getInstance();
				tEnd = c.getTimeInMillis();
				tTotal = (tEnd - tStart)/1000;
				while(tTotal == 0.0) {
					c = Calendar.getInstance();
					tEnd = c.getTimeInMillis();
					tTotal = (tEnd - tStart)/1000;
				}
				j++;
				per = (long) (j/tTotal);
				output.setText("Found word after " + j + " iterations. It took " + tTotal + " seconds. (" + per + " iterations per second)");
				found = true;
				break;
			}
			else if(word.length() == foundword.length()) {
				j++;
				foundword = "";
			}
			}
		}
		}
	}
}
