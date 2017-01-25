import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public final class Main {
	
	private final Character character = Character.newInstance();
	
	public void play() throws IOException{
		//System.out.println("Please enter your name, and a small description, as well as max health, min damage, max damage, and number of potions.");
		System.out.println("You are " + character + " " + character.getDescription());
		Dungeon.newInstance().startQuest(character);
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