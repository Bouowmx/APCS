import info.gridworld.actor.ActorWorld;

public class ZBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		ZBug alice = new ZBug(5);
		world.add(alice);
		world.show();
	}
}
