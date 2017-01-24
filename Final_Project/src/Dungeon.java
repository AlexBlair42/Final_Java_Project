import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
// This class should be done!!!
public final class Dungeon {
	
	private final Map<Integer, Map<Integer,Chamber>> map = new HashMap<Integer, Map<Integer,Chamber>>();
	private Chamber currChamb;
	private int currX = 0;
	private int currY = 0;
	
	
	private Dungeon(){}
	
	private void putChamb(int x, int y, Chamber chamb){
		if(!map.containsKey(x)){
			map.put(x, new HashMap<Integer,Chamber>());
		}
		map.get(x).put(y, chamb);
	}
	
	private Chamber getChamber(int x, int y){
		return map.get(x).get(y);
	}
	
	private boolean chambExists(int x, int y){
		if (!map.containsKey(x)){
			return false;
		}
		return map.get(x).containsKey(y);
	}
	
	private boolean isDone(){
		return currChamb.isBossRoom() && currChamb.isComplete();
	}
	
	public void moveCharacter(Character character) throws IOException{
		boolean northPossible = chambExists(currX, currY + 1);
        boolean southPossible = chambExists(currX, currY - 1);
        boolean eastPossible = chambExists(currX + 1, currY);
        boolean westPossible = chambExists(currX - 1, currY);
        System.out.print("Where would you like to go: ");
        if (northPossible) {
            System.out.print(" North (n) ");
        }
        if (eastPossible) {
            System.out.print(" East (e) ");
        }
        if (southPossible) {
            System.out.print(" South (s) ");
        }
        if (westPossible) {
            System.out.print(" West (w) ");
        }
        System.out.print(" ?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String direction = in.readLine();
        if (direction.equals(" n") && northPossible) {
            currY++;
        } else if (direction.equals(" s") && southPossible) {
            currY--;
        } else if (direction.equals(" e") && eastPossible) {
            currX++;
        } else if (direction.equals(" w") && westPossible) {
            currX--;
        }
        currChamb = getChamber(currX, currY);
        currChamb.enter(character);
    }

    public void startQuest(Character character) throws IOException {
        while (character.Alive() && !isDone()) {
            moveCharacter(character);
        }
        if (character.Alive()) {
            System.out.println("A crown");
        } else {
            System.out.println("A Reaper");
        }
    }
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
