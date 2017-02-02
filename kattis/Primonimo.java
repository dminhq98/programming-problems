/* Notes on this problem:
 * * The output specifies: 
 *     "If a winning sequence of at most p⋅m⋅n moves exists, 
 *     output an integer k≤p⋅m⋅n denoting the number of moves 
 *     in the sequence. Then output k moves as a sequence of 
 *     integers that numbers the board in row-major order, 
 *     starting with 1. If there are multiple such sequences, 
 *     you may output any one of them."
 *   This last sentence is our first clue: the solution is *any* solution to
 *   the problem. The output also specifies a maximum search depth of
 *   p*m*n; these two requirements point us towards a depth-limited search.
 *   A DLS, especially one informed by some heuristic, should be the fastest
 *   way to find a solution, since we don't need to exhaustively search
 *   (breadth-first) for an optimal solution.
 *   We store our board in row-major order to match this spec.
 * * An uninformed search takes a LONG TIME. The branching factor of our
 *   search tree is m*n, which is (at most) 400. Our max depth is p*m*n, which
 *   is (with p = 97, at most) 38800. This means that to explore the whole tree
 *   will take 400^38800 expansions, which is one of those "larger than the
 *   number of atoms in the universe" numbers.
 *   So, we need a good heuristic. Any optimistic heuristic (i.e. one that
 *   never overestimates) can be used to disqualify a bad search path: if the
 *   current depth (number of moves) plus the (optimistic) heuristic value
 *   exceeds the maximum depth, then we know it can't possibly work out.
 *   Our current heuristic is good, but not good enough. It handles boards 5x5,
 *   p < 10 just fine, but beyond that it still takes a long time.
 */
import java.util.*;

class Primonimo {

	private static class State {
		int board[][];
		int p, m, n;

		int depth;
		State parent;
		int lastMove;
		int differenceToGoal;

		public State(int board[][], int p) {
			this.n = board.length; // rows
			this.m = board[0].length; // columns
			this.p = p;
			this.board = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					this.board[i][j] = board[i][j];
					this.differenceToGoal += p - board[i][j];
				}
			}
		}

		public State createChildWithMove(int x, int y) {
			State s = new State(this.board, this.p);
			s.depth = this.depth + 1;
			s.parent = this;
			s.differenceToGoal = this.differenceToGoal - (m + n - 1);
			s.lastMove = y * m + x + 1;
			if (s.depth > p*m*n) 
				return null; // Exceeded max depth.

			s.board[y][x] -= 1; // Don't increment (x, y) twice.
			for (int i = 0; i < n; i++) {
				s.board[i][x] += 1;
				if (s.board[i][x] > s.p) {
					s.board[i][x] = 1;
					s.differenceToGoal += p;
				}
			}
			for (int i = 0; i < m; i++) {
					s.board[y][i] += 1;
				if (s.board[y][i] > s.p) {
					s.board[y][i] = 1;
					s.differenceToGoal += p;
				}
			}

			return s;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("p: %d, m: %d, n: %d\n", p, m, n));
			sb.append(String.format("depth: %d, lastMove: %d\n", depth, lastMove));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(board[i][j]).append(' ');
				}
				sb.append('\n');
			}
			return sb.toString();
		}
	}

	public static Collection<State> expandSuccessors(State state) {
		int n = state.n,
			m = state.m;
		List<State> result = new ArrayList<State>(n*m);
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				// Create successor resulting from 
				// a play at (x, y) = (col, row).
				State s = state.createChildWithMove(col, row);
				if (s != null) {
					// createChildWithMove returns null 
					// if the maximum depth is exceeded.
					result.add(s);
				}
			}
		}
		return result;
	}

	public static int h(State s) {
		return s.differenceToGoal / (s.m + s.n - 1);
	}

	public static boolean isGoal(State s) {
		return s.differenceToGoal == 0;
	}

	public static State search(Queue<State> frontier) {
		while(true) {
			if (frontier.isEmpty()) return null;
			State s = frontier.poll();
			if (isGoal(s)) return s;
			for (State n : expandSuccessors(s)) {
				frontier.add(n);
			}
		}
	}

	static class PredictedCumulativeCost implements Comparator<State> {
		public int compare(State o1, State o2) {
			int f1 = o1.depth + h(o1);
			int f2 = o2.depth + h(o2);
			return f1 - f2;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(),
			m = s.nextInt(),
			p = s.nextInt();

		int initialBoard[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				initialBoard[i][j] = s.nextInt();
			}
		}

		// Our frontier deque is used as a stack for a DFS.
		Queue<State> frontier = new PriorityQueue<State>(
				p*m*n, new PredictedCumulativeCost());
		frontier.add(new State(initialBoard, p));
		State solution = search(frontier);

		if (solution != null) {
			System.out.println(solution.depth);
			Deque<State> steps = new ArrayDeque<State>(solution.depth);
			while (solution != null) {
				steps.addFirst(solution);
				solution = solution.parent;
			}
			for (State step : steps) {
				if (step.lastMove != 0)
					System.out.printf("%d ", step.lastMove);
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	}
}

