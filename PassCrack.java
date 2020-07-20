import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/*
 * Password Cracker - Copyright 2020 Alex Weir. All Rights Reserved.
 */

public class PassCrack implements ActionListener {
	// Class level variable declaration
	
	// Base JFrame (GUI)
	JFrame myFrame;
	
	// GUI JButton
	JButton go;
	
	// Text field for input password
	JTextField target;
	
	// Text field for iteration count and other output
	JTextField output;
	
	// Check boxes for charset selection
	JCheckBox Lowercase;
	JCheckBox Uppercase;
	JCheckBox Numeric;
	JCheckBox Special;
	
	public static void main(String[] args) {
		
		// Start the program
		new PassCrack();
		
	} 
	public PassCrack() {
		
		// Initialize JFrame that was declared at the class level
	    myFrame = new JFrame(); 
	    
	    // Create the layout manager
	    FlowLayout myLayout = new FlowLayout();
	    
	    // Set the JFrame's layout manager
	    myFrame.setLayout(myLayout);  
	    
	    // Set the JFrame's default close operation to exit on close
	    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Create a main JPanel and set it to the JFrame's ContentPane, casted to a JPanel
	    JPanel mainPanel = (JPanel)myFrame.getContentPane();
	    
	    // Declare and initialize instruction label
	    JLabel setLabel = new JLabel("Character set options:");
	    
	    // Add instruction label to main JPanel
	    mainPanel.add(setLabel);
	    
	    // Initialize check boxes that were declared at the class level
	    Lowercase = new JCheckBox("Lowercase");
	    Uppercase = new JCheckBox("Uppercase");
	    Numeric = new JCheckBox("Numeric");
	    Special = new JCheckBox("Special");
	    
	    // Add check boxes to main JPanel
	    mainPanel.add(Lowercase);
	    mainPanel.add(Uppercase);
	    mainPanel.add(Numeric);
	    mainPanel.add(Special);
	    
	    // Declare and initialize instruction label
	    JLabel findLabel = new JLabel("Input:");
	    
	    // Add instruction label to main JPanel
	    mainPanel.add(findLabel);
	    
	    // Initialize input text field that was declared at the class level
	    target = new JTextField(20);
	    
	    // Add input text field to main JPanel
	    mainPanel.add(target);
	    
	    // Initialize GUI JButton that was declared at the class level
	    go = new JButton("Go");
	    
	    // Add action listener to the JButton so it can actually do something (see code below in actionPerformed method
	    go.addActionListener(this);
	    
	    // Add JButton to main JPanel
	    mainPanel.add(go);
	    
	    // Declare and initialize JLabel to tell the user what the second text field is for
	    JLabel outputLabel = new JLabel("Output:");
	    
	    // Add the label to main JPanel
	    mainPanel.add(outputLabel);
	    
	    // Initialize output text field that was declared at the class level
	    output = new JTextField(75);
	    
	    // Add output text field to main JPanel
	    mainPanel.add(output);
	    
	    // Set the size
	    myFrame.setSize(825, 100);
	    
	    // Self-explanatory
	    myFrame.setVisible(true);
	    
	    JOptionPane.showMessageDialog(null, "Welcome to my program!\nThis program takes an input string and a character set, and uses that character set to build guesses, which it then checks against the input string.\nPlease, start small! It can take many many guesses to guess the string, and the time it takes to crack the input increases exponentially with the length of the input,\neven though you can expect anywhere from 100K to 10M guesses per second.");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Finds what was pressed
		Object control = e.getSource();
		
		// Checks that the thing that was pressed was the button
		if(control == go) {
		
		// Declare and initialize an array list of strings that the program randomly chooses from
		ArrayList<String> charset = new ArrayList<String>();
		
		// Declare and initialize an array of strings that will be pulled from to fill charset
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","~","`","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",";",":","'","\"",",","<",".",">","/","?"," "};
		
		// Check if the lowercase checkbox is selected
		if(Lowercase.isSelected()) {
		
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 0, 26)));
		
		}
		
		// Check if the uppercase checkbox is selected
		if(Uppercase.isSelected()) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 26, 52)));
		
		}
		
		// Check if the numeric checkbox is selected
		if(Numeric.isSelected()) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 52, 62)));
		
		}
		
		// Check if the special checkbox is selected
		if(Special.isSelected()) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 62, alphabet.length)));
		
		}
		
		// If no character set check boxes are selected
		if(charset.isEmpty()) {
			
			// Display error message
			JOptionPane.showMessageDialog(null, "Please select your charset.");
			
			// Exit parent if statement
			return;
			
		}
		
		// If input field is empty
		if(target.getText().isEmpty()) {
			
			// Display error message
			JOptionPane.showMessageDialog(null, "Please fill input field.");
			
			// Exit parent if statement
			return;
			
		}
		
		// Declare and initialize a variable that holds the value that the user wants to find, by getting the text in the input text field
		String word = target.getText();
		
		//  Declare and initialize a variable that holds the current built word
		String foundword = "";
		
		// Declare and initialize Random variable. Not exactly sure what this actually does, just pulled it from the internet
		Random r = new Random();
		
		// Declare random integer
		int rand;
		
		// Iteration variable
		long j = 0;
		
		// Get all time information and store it
		Calendar c = Calendar.getInstance();
		
		// The time it is when the loop starts
		double tStart = c.getTimeInMillis();
		
		// This will hold the time when the loop ends
		double tEnd;
		
		// Total time it took, will be calculated at the end of the loop
		double tTotal;
		
		// Iterations per second. Yes. That is a long. This thing is fast.
        long per;
        
        // Keyspace percentage used
        double keyspace;
        
        // Run this loop forever
		while(true)
		{
				// Set that random variable!
				rand = r.nextInt(charset.size());
				
				// Add a random character to the foundword variable
				foundword += charset.get(rand);
				
				// If the found word is the same length
				if(word.length() == foundword.length()) 
				{
					// If it's the same word
					if(foundword.equals(word))
					{
						// Get time info again
						c = Calendar.getInstance();
						
						// Get time in milliseconds
						tEnd = c.getTimeInMillis();
						
						// Calculate total time
						tTotal = (tEnd - tStart)/1000;
						
						// Add 1 to the iteration variable
						j++;
						
						// Calculate iterations per second
						per = (long) (j/tTotal);
						
						keyspace = (j/Math.pow(charset.size(), word.length()))*100;
						
						// Set text on the output text field
						output.setText("Found input after " + j + " iterations, over " + tTotal + " seconds, (" + per + " iterations/sec) using " + keyspace + "% of the keyspace.");
						
						// Exit loop
						break;
					}
					
					// If it's not the right word
					else
					{
						// Add 1 to the iteration variable
						j++;
						
						// Empty foundword string
						foundword = "";
					}
				}
		}
		}
	}
}