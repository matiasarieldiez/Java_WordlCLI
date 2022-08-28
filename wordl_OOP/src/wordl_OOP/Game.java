package wordl_OOP;

public class Game {
	final String ANSI_RESET = "\u001B[0m"; // Color Grey
    final String ANSI_YELLOW = "\u001B[33m"; // Color Yellow
    final String ANSI_GREEN = "\u001B[32m"; // Color Green
	private String wordOfTheDay;
	private boolean hasWon;
	private int numberOfAttempts;
	private int maxNumberOfAttempts;
	private String userInput;

	public Game() {
		this.hasWon = false;
		this.numberOfAttempts = 0;
		this.maxNumberOfAttempts = 6;
	}
	
	public String getWordOfTheDay() {
		return this.wordOfTheDay;
	}
	
	public void gameGreeting(String string) {
		System.out.println(string);
	}
	
	public void setWordOfTheDay() {
		this.wordOfTheDay = new WordSelector().getRandomWord();	
	}
	
	public void setUserInput() {
		this.userInput = new UserInput().setUserInput();
		this.numberOfAttempts = this.numberOfAttempts + 1;
	}
	
	public void compareWords() {
		
		while (this.hasWon == false && this.numberOfAttempts <= this.maxNumberOfAttempts){
			if (this.userInput.equals(this.wordOfTheDay)) {
				System.out.println(ANSI_GREEN + this.userInput + ANSI_RESET);
				this.hasWon = true;
			} else {
			
		        char[] wordOfTheDayArray = this.wordOfTheDay.toCharArray();
		        char[] userInputArray = this.userInput.toCharArray();

		        // Compare user input array against random reference word array, print colored result and set the hasWon to true or false
				this.hasWon = true;
		        char[] tempArray = wordOfTheDayArray;
			    int[] colorForLetter = new int[5]; //0 is grey, yellow is 1, green is 2
			        
			      // Check for any correct positioned letter and assign color green
			        for (int i = 0; i < 5; i++) { 
			            if (userInputArray[i] == tempArray[i]) {
			            	tempArray[i] = '-'; // In case the word contains duplicated characters
			                colorForLetter[i] = 2;
			            } else this.hasWon = false;
			        }
			        
			     // Check for any letter that exists in a different position and assign color yellow
			        for (int i = 0; i < 5; i++) { 
			            for (int j = 0; j < 5; j++){
			                if (userInputArray[i] == tempArray[j] && colorForLetter[i] != 2) {
			                    //if that letter is not already green and matches some other letter
			                    tempArray[j] = '-';// In case the word contains duplicated characters
			                    colorForLetter[i] = 1;
			                }
			            }
			        }
			        
			     // Print each char in the userInputArray with the corresponding color
			        for (int i = 0; i < 5; i++) {
			            if (colorForLetter[i] == 0) System.out.print(userInputArray[i]);
			            if (colorForLetter[i] == 1) System.out.print(ANSI_YELLOW + userInputArray[i] + ANSI_RESET);
			            if (colorForLetter[i] == 2) System.out.print(ANSI_GREEN + userInputArray[i] + ANSI_RESET);
			        }
		        System.out.println("");
				this.numberOfAttempts = this.numberOfAttempts + 1;
				
				if (this.numberOfAttempts <= 6) {
					this.userInput = new UserInput().setUserInput();
				}

			    }
		    }
		}
	
	public void printFinalMessage() {
		if (this.hasWon == true) {
			System.out.println("Congrtulations, You've guessed in " + this.numberOfAttempts + " attempts");
		} else {
			System.out.println("You've lost. The word was: "+ this.wordOfTheDay.toUpperCase() + ". Better Luck Next Time");
		}
	}
}
