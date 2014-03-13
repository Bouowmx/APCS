import info.gridworld.actor.Bug;
import java.util.Arrays;

public class DancingBug extends Bug {
	private int index = 0;
	private int[] turns;
	
	public DancingBug(int[] turns) {this.turns = turns;}
	
	public void act() {
		if (index == turns.length) {index = 0;}
		setDirection(getDirection() + 45 * turns[index]);
		index++;
	}
	
	public int[] getTurns() {return turns;}
	
	public String getTurnsToString() {return Arrays.toString(turns);}
}
