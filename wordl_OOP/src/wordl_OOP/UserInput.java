package wordl_OOP;

import java.util.Scanner;

public class UserInput {
	
	public String userInput;
	public Scanner scanner = new Scanner(System.in);

	public UserInput() {
		
	}

	public String setUserInput() {
		this.userInput = scanner.next().toLowerCase().trim();
		while (this.userInput.length() != 5) {
			System.out.println("I'm sorry. You've entered a " + this.userInput.length() + " letters word. It must be a 5 letters word. Try again");
			this.userInput = scanner.next().toLowerCase().trim();
		}
		return this.userInput;
	}
	
	public char[] convertStringToCharArray(String wordToConvert) {
		char[] charArray = new char[5];
		for (int i = 0; i < 5; i++) {
			charArray[i] = wordToConvert.charAt(i);
		}
		return charArray;
	}
}
	


