import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This class handles the combat of the game
 * @author Alex Blair
 *
 */
public final class Combat {
	/**
	 * This creates a Combat object for use in the application
	 * 
	 * It passes 
	 * @param character
	 * @param enemy
	 * and it throws
	 * @throws IOException
	 */
	public Combat(Character character, Enemy enemy) throws IOException{
		System.out.println("A wild " + enemy + " appears! :" + enemy.getDescription() + "\n");
		System.out.println("Let the battle with the " + enemy + " begin! (" + character.getStatus() + " / " + enemy.getStatus() + ")" );
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		/**
		 * This loop is for combat. 
		 * As long as each entity is alive then combat continues.
		 * Else the combat ends with the enemy's death or the character's.
		 */
		while (character.Alive() && enemy.Alive()){
			 System.out.print("Attack (a) or heal (h)? ");
	           String action = in.readLine();
	            if (action.equals("h")) {
	                character.heal();
	            } else {
	                enemy.defend(character);
	            }
	            if (enemy.Alive()) {
	                character.defend(enemy);
	            }
	            
		}
	}

}
