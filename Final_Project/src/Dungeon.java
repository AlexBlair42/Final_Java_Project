import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class Dungeon {
	/**
	 * This is the class that creates a Dungeon Object and stores it's instances in a map.
	 * @author Alex Blair
	 * @version 1.0
	 * 
	 */
	private final Map<Integer, Map<Integer,Chamber>> map = new HashMap<Integer, Map<Integer,Chamber>>();
	private Chamber currChamb;
	private int currX = 0;
	private int currY = 0;
	
	/**
	 * Creates a Dungeon object
	 */
	private Dungeon(){}
	
	/**
	 * This puts the rooms in the map with the given coordinates and descriptor.
	 * @param x
	 * @param y
	 * @param chamber
	 */
	private void putChamb(int x, int y, Chamber chamber){
		if(!map.containsKey(x)){
			map.put(x, new HashMap<Integer,Chamber>());
		}
		map.get(x).put(y, chamber);
	}
	
	/**
	 * This retrieves the information about the different rooms from the map
	 * @param x
	 * @param y
	 * @return
	 */
	private Chamber getChamber(int x, int y){
		return map.get(x).get(y);
	}
	
	/**
	 * This checks to see if the room exists in the map.
	 * @param x
	 * @param y
	 * @return true or false
	 */
	private boolean chambExists(int x, int y){
		if (!map.containsKey(x)){
			return false;
		}
		return map.get(x).containsKey(y);
	}
	
	/**
	 * This checks to see if all of the rooms have been visited for the creation of a boss instance.
	 * @return true or false
	 */
	private boolean isDone(){
		return currChamb.isBossRoom() && currChamb.isComplete();
	}
	
	/**
	 * This is the function for character movement.
	 * The character starts by moving north and then the function keeps track of where the character is in relation to other rooms in the map.
	 * @param character
	 * @throws IOException
	 */
	public void moveCharacter(Character character) throws IOException{
		boolean northPoss = chambExists(currX, currY + 1);
		
        boolean southPoss = chambExists(currX, currY - 1);
        
        boolean eastPoss = chambExists(currX + 1, currY);
        
        boolean westPoss = chambExists(currX - 1, currY);
        
        System.out.print("You set out on your epic quest! \n");
        System.out.println("Where would you like to go :");
       
        if (northPoss) {
            System.out.print("North (n)");
        }
        if (eastPoss) {
            System.out.print("East (e)");
        }
        if (southPoss) {
            System.out.print("South (s)");
        }
        if (westPoss) {
            System.out.print("West (w)");
        }
        System.out.print(" ? ");
        
        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));
        String direction = rdr.readLine();
       
        if (direction.equals("n") && northPoss) {
            currY++;
            System.out.println("You have chosen North! ");
        } 
        if (direction.equals("s") && southPoss) {
        	System.out.println("You have chosen South! ");
        	currY--;
        } 
        if (direction.equals("e") && eastPoss) {
           currX++;
           System.out.println("You have chosen East! ");
        }
        if (direction.equals("w") && westPoss) {
            currX--;
            System.out.println("You have chosen West!");
        }
        if(direction.equals("n")|| direction.equals("w")|| direction.equals("s")|| direction.equals("e")){
        currChamb = getChamber(currX, currY);
        currChamb.enter(character);
        }else 
        	System.out.println("That character is not a valid input. Please select another direction.");
    }

	/**
	 * This is the start function for the Dungeon. It is called in main to begin the game.
	 * @param character
	 */
    public void Adventure(Character character) {
        while (character.Alive() && !isDone()) {
            try {
				moveCharacter(character);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
        }
        if (character.Alive()) {
            System.out.println("A HERO!");
        } else {
            System.out.println("RIP");
        }
    }
    
    /**
     * This creates new rooms in the dungeon and places them in the map with the coordinates as keys.
     * @return new Dungeon
     */
    public static Dungeon newInstance() {
        Dungeon dungeon = new Dungeon();
        dungeon.putChamb(0, 0, Chamber.newRegularInstance());
        
        dungeon.putChamb(-1, 1, Chamber.newRegularInstance());
        
        dungeon.putChamb(0, 1, Chamber.newRegularInstance());
        
        dungeon.putChamb(1, 1, Chamber.newRegularInstance());
        
        dungeon.putChamb(-1, 2, Chamber.newRegularInstance());
        
        dungeon.putChamb(1, 2, Chamber.newRegularInstance());
        
        dungeon.putChamb(-1, 3, Chamber.newRegularInstance());
        
        dungeon.putChamb(0, 3, Chamber.newRegularInstance());
        
        dungeon.putChamb(1, 3, Chamber.newRegularInstance());
        
        dungeon.putChamb(0, 4, Chamber.newBoss());
        dungeon.currChamb = dungeon.getChamber(0, 0);
        return dungeon;
	}

}
