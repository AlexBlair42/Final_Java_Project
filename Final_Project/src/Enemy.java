import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.*;
// This class should be finished!!!!!
public final class Enemy {

	private final String name;
	private final String description;
	private int hitP;
	private final int mindmg;
	private final int maxdmg;
	private final static Random rand = new Random();
	private final static Set<Integer> enemySeen = new HashSet<Integer>();
	private final static int NUM_ENEMY = 3;
	
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
			return new Enemy("Dragon ", " A large fire breathing lizard. ", 600, 30, 80);
		}else if (i == 1){
			return new Enemy("Ghoul ", " An undead wanderer. ", 300, 10, 25);
		}else {
			return new Enemy("Horror ", " Unknown appearance. ", 450, 20, 50);
		}
	}
	public static Enemy newBossInstance(){
		return new Enemy("Large Bat ", " A very large cave bat. ", 250, 25, 40);
	}
	private Enemy(String name, String description, int hitP, int mindmg, int maxdmg){
		this.name = name;
		this.description = description;
		this.mindmg = mindmg;
		this.maxdmg = maxdmg;
		this.hitP = hitP;
	}
	public String toString(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public String getStatus(){
		return "Enemy HP: " + hitP;
	}
	public int attack(){
		return rand.nextInt(maxdmg - mindmg + 1 ) + mindmg;
	}
	
	public void defend(Character character){
		int attackStr = character.attack();
		hitP = (hitP > attackStr) ? hitP - attackStr : 0;
		System.out.printf("%s hits %s for %d HP of damage (%s)\n" , character, name, attackStr, getStatus());
		if (hitP == 0){
			System.out.println( character + " defeats " + name + "!\n ");
		}
	}
	
	public boolean Alive(){
		return hitP > 0;
	}	
	
}
