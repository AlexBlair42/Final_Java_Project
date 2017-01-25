/**
 * This is a text based Dungeon crawler that I made for Java applications.
 * @version 1.0
 * @author Alex Blair
 * 
 * In it's current state it is just a console application.
 * I have plans to add a graphical user interface as well as file IO for the text prompts.
 * 
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main class that holds the function main and the commands to create a player object and to play the game.
 *
 */
public final class Main {
	
	private final Character character = Character.newInstance();
	
	/**
	 * This function sets the character and creates a Dungeon in which the quest is started.
	 * @throws IOException
	 */
	public void play() throws IOException{
		System.out.println("You are " + character + " " + character.getDescription());
		Dungeon.newInstance().Adventure(character);
	}

	public static void main(String[] args) {
		Main main = new Main();
		try {
			main.play();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}