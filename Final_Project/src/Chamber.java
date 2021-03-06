import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/**
 * This is the class for the individual rooms in the dungeon.
 * @author Alex Blair
 *
 */
public final class Chamber {
	
	private final String description;
	private final Enemy enemy;
	private final Boolean isBoss;
	private final static Random rand = new Random();
	private final static Set<Integer> roomdone = new HashSet<Integer>();
	private final static int Num_Room = 7;
	
	
	/** 
	 * This creates a chamber object to be placed in the dungeon.
	 * @param description
	 * @param enemy
	 * @param isBoss
	 */
	
	private Chamber(String description, Enemy enemy, Boolean isBoss){
		this.description = description;
		this.enemy = enemy;
		this.isBoss = isBoss;
		
	}
	
	/**
	 * This creates a new instance of the current room and checks to see what random number it is assigned.
	 * @return new room
	 */
	public static Chamber newRegularInstance(){
		if (roomdone.size() == Num_Room){
			roomdone.clear();
		}
		int i; 
		do{
			i = rand.nextInt(Num_Room);
		}while (roomdone.contains(i));
		roomdone.add(i);
	
		/**
		 * This is where the rooms are given a description based on the random int i.
		 */
		String roomDesc = null;
		if (i == 0){
			roomDesc = "A dragon's lair that is dark and full of horrors.";
		}else if (i == 1){
			roomDesc = "An undead bog infested with Ghouls and all sorts of evil beings. ";
		}else if (i == 2){
			roomDesc = "A dark cave filled with horrors. ";
		}else if (i == 3){
			roomDesc = "A prison with rotting corpses and celestial beeings. ";
		}else if (i == 4){
			roomDesc = "A spider infested forest that is dark and full of webs. ";
		}else if (i == 5){
			roomDesc = "The edge of a cliff with the sea bashing against the rock ";
		}else if (i == 6){
			roomDesc = "A shadowy room where water drops can be heard in the distance. ";
		}else {
		}
		return new Chamber(roomDesc, Enemy.newRandomInstance(), false); 
		
		}
	
	/**
	 * This creates a new boss room with a description.
	 * @return new boss room
	 */
	public static Chamber newBoss(){
		return new Chamber("A very large and open room with a very large door. ", Enemy.newBossInstance(), true);
	}
	
	/**
	 * This checks to see if the current room is a boss room.
	 * @return true or false
	 */
	public boolean isBossRoom(){
		return isBoss;
	}
	
	/**
	 * This checks to see if all of the rooms have been completed.
	 * @return true or false
	 */
	public boolean isComplete(){
		return !enemy.Alive();
	}
	/**
	 * This formats all descriptions in String format.
	 */
	@Override
	public String toString(){
		return description;
	}
	
	public void enter(Character character) throws IOException{
		System.out.println("You are (in/on) " + description);
		if(enemy.Alive()){
			new Combat(character, enemy);
		}
	}

}
