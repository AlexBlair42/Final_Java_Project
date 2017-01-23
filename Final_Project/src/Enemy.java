import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.*;

public final class Enemy {

	private final String name;
	private final String description;
	private int hitP;
	private final int mindmg;
	private final int maxdmg;
	private final static Random rand = new Random();
	private final static Set<Integer> enemySeen = new HashSet<Integer>();
	private final static int NUM_ENEMY = 3;
	
}
