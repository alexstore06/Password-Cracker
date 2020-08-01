import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;
import javax.swing.*;

/*
 * Password Cracker Console - Copyright 2020 Alex Weir. All Rights Reserved.
 */

public class PassCrackc {
	// Class level variable declaration
	
	// Variables holding user input
	String lowercase;
	String uppercase;
	String numbers;
	String special;
	String input;
	
	// Declare and initialize an array of strings that will be pulled from to fill charset
	String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","~","`","!","@","#","$","%","^","&","*","(",")","-","_","=","+","[","]","{","}","\\","|",";",":","'","\"",",","<",".",">","/","?"," "};
	
	// Declare and initialize an array list of strings that the program randomly chooses from
	ArrayList<String> charset = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		
		// Start the program
		new PassCrackc();
		
	} 
	
	public PassCrackc() throws IOException {
		
		// Create input reader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		// Display instructions
		System.out.println("Welcome to my program!\nThis program takes an input string and a character set, and uses that character set to build guesses, which it then checks against the input string.\nPlease, start small! It can take many many guesses to guess the string, and the time it takes to crack the input increases exponentially with the\nlength of the input, even though you can expect anywhere from 1K to 10M guesses per second.");
		
		// Run this loop until break is called
		while(true) {
			
			// Display question
			System.out.println("Lowercase characters? (y/n)");
			
			// Read input and put into variable
			lowercase = reader.readLine();
			
			// If variable is valid, break, otherwise prompt to enter valid input
			if(lowercase.equals("y")) {
				
				break;
				
			}
			
			else if(lowercase.equals("n")) {
				
				break;
				
			}
			
			else {
				
				System.out.println("Please enter valid input.");
				
			}
			
		}
		
		// Run this loop until break is called
		while(true) {
			
			// Display question
			System.out.println("Uppercase characters? (y/n)");
			
			// Read input and put into variable
			uppercase = reader.readLine();
			
			// If variable is valid, break, otherwise prompt to enter valid input
			if(uppercase.equals("y")) {
				
				break;
				
			}
			
			else if(uppercase.equals("n")) {
				
				break;
				
			}
			
			else {
				
				System.out.println("Please enter valid input.");
				
			}
			
		}
		
		// Run this loop until break is called
		while(true) {
			
			// Display question
			System.out.println("Numbers? (y/n)");
			
			// Read input and put into variable
			numbers = reader.readLine();
			
			// If variable is valid, break, otherwise prompt to enter valid input
			if(numbers.equals("y")) {
				
				break;
				
			}
			
			else if(numbers.equals("n")) {
				
				break;
				
			}
			
			else {
				
				System.out.println("Please enter valid input.");
				
			}
			
		}
		
		// Run this loop until break is called
		while(true) {
			
			// Display question
			System.out.println("Special characters? (y/n)");
			
			// Read input and put into variable
			special = reader.readLine();
			
			// If variable is valid, break, otherwise prompt to enter valid input
			if(special.equals("y")) {
				
				break;
				
			}
			
			else if(special.equals("n")) {
				
				break;
				
			}
			
			else {
				
				System.out.println("Please enter valid input.");
				
			}
			
		}
		
		// If user wants lowercase characters
		if(lowercase.equals("y")) {
		
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 0, 26)));
		
		}
		
		// If user wants uppercase characters
		if(uppercase.equals("y")) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 26, 52)));
		
		}
		
		// If user wants numbers
		if(numbers.equals("y")) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 52, 62)));
		
		}
		
		// If user wants special characters
		if(special.equals("y")) {
			
			// Add characters to list
			charset.addAll(Arrays.asList(Arrays.copyOfRange(alphabet, 62, alphabet.length)));
		
		}
		
		// Run this loop until break is called
		while(true) {
			
			// Display prompt
			System.out.println("Enter input string:");
			
			// Read input and put into variable
			input = reader.readLine();
			
			// If input is empty, prompt for valid input, otherwise break
			if(input.isEmpty()) {
				
				System.out.println("Please do not leave input blank.");
				
			}
			
			else {
				
				break;
				
			}
			
		}
		
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
        
        // Run this loop until break is called
		while(true) {
			
			// Create guess of same length by adding a random character for each character the input is long
			for(int i = 0; i < input.length(); i++) {
			
				// Set that random variable!
				rand = r.nextInt(charset.size());
				
				// Add a random character to the foundword variable
				foundword += charset.get(rand);
			
			}

			// If it's the same word
			if(foundword.equals(input)) {
				
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
				
				// Calculate keyspace of input
				keyspace = (j/Math.pow(charset.size(), input.length()))*100;
				
				// Display info
				System.out.println("Found input after " + j + " iterations, over " + tTotal + " seconds, (" + per + " iterations/sec) using " + keyspace + "% of the keyspace.");
				
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