import java.util.Random;
import java.io.*;
import java.util.regex.*;

public final class Character {
	private final String name;
	private final String description;
	private final int maxHP;
	private int hitP;
	private int numPots;
	private final int mindmg;
	private final int maxdmg;
	private final Random rand = new Random();
	
	/**
	 * This class creates a character object with the above traits
	 * @author Alex Blair
	 * 
	 * 
	 * @param name
	 * @param description
	 * @param maxHP
	 * @param mindmg
	 * @param maxdmg
	 * @param numPots
	 * 
	 * The constructor has the paramaters listed above.
	 */

	private Character(String name, String description, int maxHP, int mindmg, int maxdmg, int numPots){
		this.name = name;
		this.description = description;
		this.maxHP = maxHP;
		this.mindmg = mindmg;
		this.maxdmg = maxdmg;
		this.numPots = numPots;
		this.hitP = maxHP;
	}
	
	/**
	 * This function is for the player to attack
	 * @return a random amount of damage
	 */
	public int attack(){
		return rand.nextInt(maxdmg - mindmg +1)+ mindmg;
	}
	
	/**
	 * This function is for the defense from the enemy
	 * It also checks for if the player is dead
	 * @param enemy
	 */
	public void defend(Enemy enemy){
		int attackStr = enemy.attack();
		hitP = (hitP > attackStr) ? hitP - attackStr : 0;
		System.out.printf(name + " is hit for %d HP of damage. (%s)\n" , attackStr, getStatus());
		if(hitP == 0)
		{
			System.out.println(name + " is Dead!\n");
		}
	}
	
	/**
	 * This function is for healing the player when a potion is used.
	 * It checks the number of potions to make sure that healing can be done
	 * and then it applies that potion's healing effect if applicable.
	 */
	public void heal()
	{
		if (numPots > 0){
			hitP = Math.min(maxHP, hitP + 50);
			System.out.printf("%s drinks a life saving red portion! (%s, %d potions left)\n", name, getStatus(), --numPots );
		}else {
			System.out.println("Uh-oh! You have run out of potions.\n ");
		}
	}
	
	/**
	 * This function checks to see if the player is still alive.
	 * @return true or false if HP > 0
	 */
	public boolean Alive(){
		return hitP > 0;
	}
	
	/**
	 * This checks the status of the player.
	 * @return Current HP.
	 */
	public String getStatus(){
		return "Character HP: " + hitP;
	}
	
	/**
	 * This is used to transfer any reference to the character's name into a string of that name.
	 */
	@Override
	public String toString(){
		return name;
	}
	
	/**
	 * This function gets the description of the character so that it can be iterated to the user.
	 * @return
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * This creates a new instance of the Character object
	 * @return new instance of Character.
	 */
	public static Character newInstance(){
		return new Character("Sam", "a 25 year old adventurer!",800,30,100,20);
	}
	
}
