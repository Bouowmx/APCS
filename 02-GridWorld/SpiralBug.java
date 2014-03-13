import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
	private int length = 1, steps = 0;
	
	public SpiralBug() {}
	
	public void act() {
		if ((steps < length) && canMove()) {
			move();
			steps++;
		}
		else {
			turn();
			turn();
			if (canMove()) {length++;}
			steps = 0;
		}
	}
}
