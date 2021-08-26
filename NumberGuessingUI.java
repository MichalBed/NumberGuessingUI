// Author: Michal Bednarek
// Number guessing game using Java Swing 
// 26/08/2021

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class NumberGuessingUI implements ActionListener{

	// UI Components Initialisation
	private JFrame frame;
	private JPanel panel;
	private JLabel titleLabel;
	private JTextField numberField;
	private JButton submitButton;
	private JButton newNumButton;
	private JLabel resultLabel;
	
	// The number that the player has to guess
	private int targetNum;
	
	// Number of attempts before a correct answer is reached
	private int numOfGuesses;
	
	// Create the User Interface
	NumberGuessingUI() {
		targetNum = new Random().nextInt(100);
		numOfGuesses = 0;
		System.out.println("Number is: "+targetNum);
		
		frame = new JFrame();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		titleLabel = new JLabel("Guess the number between 0 and 100");
		titleLabel.setBounds(20,15,250,10);
		panel.add(titleLabel);
		
		numberField = new JTextField();
		numberField.setBounds(100,40,50,20);
		panel.add(numberField);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(20,70,75,20);
		submitButton.addActionListener(this);
		panel.add(submitButton);
		
		newNumButton = new JButton("New Number");
		newNumButton.setBounds(100,70,120,20);
		newNumButton.addActionListener(this);
		panel.add(newNumButton);
		
		resultLabel = new JLabel("");
		resultLabel.setBounds(20,90,300,50);
		panel.add(resultLabel);
		
		frame.setTitle("Number Guessing");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
	}
	
	
	public static void main(String[] args) {
		new NumberGuessingUI();
	}

	@Override
	// When button is pressed
	public void actionPerformed(ActionEvent arg0) {
		
		// Submit Button
		if (arg0.getActionCommand() == "Submit") {
			System.out.println("JSubmit");
			if (isNumeric(numberField.getText())) { // If it's a valid number
				int Guess = Integer.parseInt(numberField.getText());
				numOfGuesses++;
				
				if (Guess == targetNum) { // If correct guess
					resultLabel.setText("Correct in "+numOfGuesses+"!");
				} else if (Guess < targetNum){ // Too low
					resultLabel.setText("Your guess of "+Guess+" is too low");
					numberField.setText("");
				} else { // Too high
					resultLabel.setText("Your guess of "+Guess+" is too high");
					numberField.setText("");
				}
				
			} else { // Invalid format
				resultLabel.setText("Invalid format, input a number");
				numberField.setText("");
			}
			
		// New Number Button
		} else if (arg0.getActionCommand() == "New Number") {
			targetNum = new Random().nextInt(100);
			resultLabel.setText("");
			numberField.setText("");
			numOfGuesses = 0;
		}
		
	}
	
	
	
	// Source: https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	// Checks if a string is a valid integer
	public static boolean isNumeric(String str) { 
	  try {  
	    Integer.parseInt(str);  
	    return true;
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
	}
	
}
