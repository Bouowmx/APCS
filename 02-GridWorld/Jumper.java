import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Actor {
	public Jumper() {}
	
	public void act() {
		if (canMove()) {move();}
		else {turn();}
	}
	
	public boolean canMove() {
		Grid<Actor> grid = getGrid();
		if (grid == null) {return false;}
		Location destination = getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if (!(grid.isValid(destination))) {return false;}
		Actor actors = grid.get(destination);
		return ((actors == null) || (actors instanceof Flower));
	}
	
	public void move() {
		Grid<Actor> grid = getGrid();
		if (grid == null) {return;}
		Location destination = getLocation().getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if (grid.isValid(destination)) {moveTo(destination);}
		else {removeSelfFromGrid();}
	}
	
	public void turn() {setDirection(getDirection() + 45);}
}
