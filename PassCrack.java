import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
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
	    JLabel wordLabel = new JLabel("Enter the word you want to find:");
	    
	    // Add instruction label to main JPanel
	    mainPanel.add(wordLabel);
	    
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
	    output = new JTextField(70);
	    
	    // Add output text field to main JPanel
	    mainPanel.add(output);
	    
	    // Set the size to fit all JComponents
	    myFrame.pack();
	    
	    // Self-explanatory
	    myFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Finds what was pressed
		Object control = e.getSource();
		
		// Checks that the thing that was pressed was the button, which is useless as it's the only thing you can press
		if(control == go) {
			
		// Declare and initialize an array of strings, that are really characters, that the program randomly chooses from
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","~","`","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",";",":","'","\"",",","<",".",">","/","?"};
		
		// Declare and initialize a variable that holds the value that the user wants to find, by getting the text in the input text field
		String word = target.getText();
		
		//  Declare and initialize a variable that holds the current built word
		String foundword = "";
		
		// Declare and initialize Random variable. Not exactly sure what this actually does, just pulled it from the internet
		Random r = new Random();
		
		// Declare random integer
		int rand;
		
		// Whether the target word has been found
		boolean found = false;
		
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
        
        // Run this loop while you have not found the word
		while(found == false)
		{
			// Loop until you've built a word of the same length of the target
			for(int i = 0; i<=word.length(); i++)
			{
				// Set that random variable!
				rand = r.nextInt(alphabet.length);
				
				// Add a random character to the foundword variable
				foundword += alphabet[rand];
				
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
						
						// Set text on the output text field
						output.setText("Found word after " + j + " iterations. It took " + tTotal + " seconds. (" + per + " iterations per second)");
						
						// The word has been found
						found = true;
						
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
}
