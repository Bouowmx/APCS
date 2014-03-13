import info.gridworld.actor.ActorWorld;
import java.util.Random;

public class DancingBugRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		int[] turns = new int[10];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {turns[i] = random.nextInt(11);}
		DancingBug alice = new DancingBug(turns);
		world.add(alice);
		world.show();
	}
}
