package wordl_OOP;


public class Main {

	public static void main(String[] args) {
	
		//Extension: Read the word list directly from the file when the application starts
//		String wordOfTheDay = new WordSelector().getRandomWord();
//		System.out.println(wordOfTheDay);
		
		Game newGame = new Game();
		newGame.setWordOfTheDay();
		System.out.println(newGame.getWordOfTheDay()); // This line is for debug/test only 
		newGame.gameGreeting("Welcome! Please enter a 5 letter word: ");
		newGame.setUserInput();
		newGame.compareWords();	
		newGame.printFinalMessage();
	}

}
