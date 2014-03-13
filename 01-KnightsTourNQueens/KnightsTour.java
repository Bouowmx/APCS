import java.util.Arrays;
import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class KnightsTour {
	private int[][] board;
	private final int FINAL_MOVE;
	
	public KnightsTour(int n) {
		board = new int[n][n];
		FINAL_MOVE = n * n;
	}
	
	private boolean move(int x, int y, int move) {
		if (((x < 0) || (x >= board.length) || (y < 0) || (y >= board.length)) || (board[x][y] != 0)) {return false;}
		if (move == FINAL_MOVE) {
			board[x][y] = move;
			for (int r = 0; r < board.length; r++) {out.println(Arrays.toString(board[r]));}
			return true;
		}
		board[x][y] = move;
		boolean result = false;
		result = result || move(x + 2, y + 1, move + 1);
		result = result || move(x + 2, y - 1, move + 1);
		result = result || move(x - 2, y + 1, move + 1);
		result = result || move(x - 2, y - 1, move + 1);
		result = result || move(x + 1, y + 2, move + 1);
		result = result || move(x + 1, y - 2, move + 1);
		result = result || move(x - 1, y + 2, move + 1);
		result = result || move(x - 1, y - 2, move + 1);
		if (result) {return true;}
		else {
			board[x][y] = 0;
			return false;
		}
	}
	
	public boolean solve(int x, int y) {return move(x, y, 1);} //The solution is printed in reverse order.
	
	public static void main(String[] args) {
		if (args.length != 1) {out.println("Usage:  java KnightsTour n");}
		KnightsTour knightstour = new KnightsTour(Integer.parseInt(args[0]));
		long t1 = nanoTime();
		knightstour.solve(0, 0);
		long t2 = nanoTime();
		out.println("\nTime: " + (t2 - t1) + " ns / " + ((double) (t2 - t1) / 1000000) + " ms / " + ((double) (t2 - t1) / 1000000000) + " s");
	}
}
