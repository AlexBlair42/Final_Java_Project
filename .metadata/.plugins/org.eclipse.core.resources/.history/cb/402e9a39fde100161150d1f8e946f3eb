import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public final class Main {
	
	private final Character character = Character.newInstance();
	
	public void play() throws IOException{
		System.out.println("You are " + character + " " + character.getDescription());
		Dungeon.newInstance().startQuest(character);
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.play();

	}

}
