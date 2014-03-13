import info.gridworld.actor.Bug;

public class ZBug extends Bug {
	private int length, step = 1, steps = 0;
	
	public ZBug(int length) {
		this.length = length;
		setDirection(90);
	}
	
	public void act() {
		if ((steps < length) && canMove()) {
			move();
			steps++;
		}
		else {
			if (step == 1) {setDirection(225);}
			if (step == 2) {setDirection(90);}
			if (canMove()) {step++;}
			steps = 0;
		}
	}
	
	public boolean canMove() {return (super.canMove() && (step <= 3));}
}
