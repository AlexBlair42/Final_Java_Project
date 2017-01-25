import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * This class lays out the parameters for enemies in the game and also their functionality.
 * @author Alex Blair
 * 
 * 
 *
 */
public final class Enemy {

	private final String name;
	private final String description;
	private int hitP;
	private final int mindmg;
	private final int maxdmg;
	private final static Random rand = new Random();
	private final static Set<Integer> enemySeen = new HashSet<Integer>();
	private final static int NUM_ENEMY = 4;
	
	/**
	 * This creates a new random instance of enemy
	 * @return a type of enemy object
	 */
	public static Enemy newRandomInstance(){
		if(enemySeen.size() == NUM_ENEMY){
			enemySeen.clear();
		}
		int i;
		do{
			i = rand.nextInt(NUM_ENEMY);
		}while (enemySeen.contains(i));
		enemySeen.add(i);
		
		if(i == 0){
			return new Enemy("Dragon ", " A large fire breathing lizard. ", 600, 30, 65);
		}else if (i == 1){
			return new Enemy("Ghoul ", " An undead wanderer. ", 300, 20, 30);
		}else if(i==2){
			return new Enemy ("Spectre", " Shade like appearance", 250,25,50);
		}else {
			return new Enemy("Horror ", " A large beast with tentacles and four arms. ", 500, 35, 75);
		}
	}
	
	/**
	 * When all of the enemies have been beaten then a new boss instance is created.
	 * @return new Boss
	 */
	public static Enemy newBossInstance(){
		return new Enemy("Minetour ", " A half breed between a Bull and a Human!. ", 800, 50, 150);
	}
	
	/**
	 * This is a constructor for enemy
	 * @param name
	 * @param description
	 * @param hitP
	 * @param mindmg
	 * @param maxdmg
	 */
	private Enemy(String name, String description, int hitP, int mindmg, int maxdmg){
		this.name = name;
		this.description = description;
		this.mindmg = mindmg;
		this.maxdmg = maxdmg;
		this.hitP = hitP;
	}
	
	/**
	 * This returns the name of the enemy in string format
	 * @return name
	 */
	public String toString(){
		return name;
	}
	
	/**
	 * This gets the description of the enemy.
	 * @return description
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * This gets the current HP of the enemy.
	 * @return current HP
	 */
	public String getStatus(){
		return "Enemy HP: " + hitP;
	}
	
	/**
	 * This is the function that allocates a random number to represent damage done to the player by the enemy.
	 * @return damage done
	 */
	public int attack(){
		return rand.nextInt(maxdmg - mindmg + 1 ) + mindmg;
	}
	
	/**
	 * This is the function that resists damage done by the player.
	 * @param character
	 */
	public void defend(Character character){
		int attackStr = character.attack();
		hitP = (hitP > attackStr) ? hitP - attackStr : 0;
		System.out.printf("%s hits %s for %d HP of damage (%s)\n" , character, name, attackStr, getStatus());
		if (hitP == 0){
			System.out.println( character + " defeats the " + name + "!\n ");
		}
	}
	
	/**
	 * This function checks to see if the enemy is alive.
	 * @return true or false.
	 */
	public boolean Alive(){
		return hitP > 0;
	}	
	
}
