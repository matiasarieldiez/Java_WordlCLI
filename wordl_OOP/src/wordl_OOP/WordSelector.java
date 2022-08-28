package wordl_OOP;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class WordSelector {
	
	private String wordOfTheDay = "";
	
	public WordSelector() {
		
	}
	
	public String getRandomWord() {
		JSONParser parser = new JSONParser();
		
		try (Reader reader = new FileReader("C:\\Users\\matia\\eclipse-workspace\\wordl_OOP\\src\\word-list.json")) {

        JSONArray wordListArray = (JSONArray) parser.parse(reader);
   		this.wordOfTheDay = wordListArray.toArray()[(int)(Math.random() * (wordListArray.toArray().length - 1))].toString();;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		return this.wordOfTheDay;
	}
	
	public char[] convertStringToCharArray(String wordToConvert) {
		char[] charArray = new char[5];
		for (int i = 0; i < 5; i++) {
			charArray[i] = wordToConvert.charAt(i);
		}
		return charArray;
	}
	
}
