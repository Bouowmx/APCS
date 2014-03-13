import info.gridworld.actor.ActorWorld;

public class JumperRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		Jumper alice = new Jumper();
		world.add(alice);
		world.show();
	}
}
