import info.gridworld.actor.ActorWorld;

public class SpiralBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		SpiralBug alice = new SpiralBug();
		world.add(alice);
		world.show();
	}
}
