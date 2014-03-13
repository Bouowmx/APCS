import info.gridworld.actor.Bug;

public class CircleBug extends Bug {
	private int length, steps = 0;
	
	public CircleBug(int length) {this.length = length;}
	
	public void act() {
		if ((steps < length) && canMove()) {
			move();
			steps++;
		}
		else {
			turn();
			steps = 0;
		}
	}
}
