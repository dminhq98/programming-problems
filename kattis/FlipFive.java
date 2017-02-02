import java.util.*;

public class FlipFive {
	static short board, goal;

	static boolean isGoal() {
		return board == goal;
	}

	// NB: Making the same move twice takes back that move.
	static void makeMove(int i, int j) {
		board ^= 1 << i*3+j;
		if (i > 0) board ^= 1 << (i-1)*3+j;
		if (i < 2) board ^= 1 << (i+1)*3+j;
		if (j > 0) board ^= 1 << i*3+(j-1);
		if (j < 2) board ^= 1 << i*3+(j+1);
	}

	static boolean ids(int depth) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				makeMove(i, j);
				if (depth > 1) {
					if (ids(depth-1)) return true;
				} else if (isGoal()) return true;
				makeMove(i, j);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int P = Integer.parseInt(in.nextLine());
		while(P-- > 0) {
			board = 0;
			goal = 0;
			for(int i = 0; i < 3; i++) {
				String line = in.nextLine().trim();
				for(int j = 0; j < 3; j++) {
					if (line.charAt(j) == '*') {
						goal |= 1 << (i*3)+j;
					}
				}
			}
			
			if (isGoal()) System.out.println(0);
			else for(int depth = 1; ; depth++) {
				if (ids(depth)) {
					System.out.println(depth);
					break;
				}
			}
		}
	}
}

