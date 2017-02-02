import java.util.*;

public class DotsBoxes {

	static class Cell {
		boolean n,e,s,w; // true = line, false = no line.
	}

	// A vertex can have at most 4 neighbours, so we represent it as an array
	// of fixed size. We use these N, E, S, W constants to consistently order a
	// vertex's neighbours.
	static final int N = 0,
				     E = 1,
					 S = 2,
					 W = 3;
	static class Vertex {
		int id;
		Vertex neighbours[];
		int degree;

		public Vertex(int id) {
			neighbours = new Vertex[4];
			this.id = id;
		}

		public void addNeighbour(Vertex v, int direction) {
			neighbours[direction] = v;
			degree++;
		}

		public Vertex removeNeighbour(int direction) {
			Vertex v = neighbours[direction];
			neighbours[direction] = null;
			degree--;
			return v;
		}

		public int hashCode() {
			return id;
		}

		public boolean equals(Object o) {
			Vertex v = (Vertex) o;
			return v.id == this.id;
		}
	}

	public static List<Vertex> verticesFromBoard(Cell board[][]) {
		ArrayList<Vertex> result = new ArrayList<Vertex>(board.length * board.length);
		for (int i = 0; i < board.length * board.length; i++) {
				v = new Vertex(i);
				result.add(v);
		}
		for (int i = 0; i < result.size(); i++) {
			Cell c = board[i/board.length][i%board.length];
			Vertex v = result.get(i);
			if (!c.n && i >= board.length) {
				// Connected to cell above.
				Vertex other = result.get(i-board.length);
				v.addNeighbour(other, N);
				other.addNeighbour(v, S);
			}
			if (!c.w && (i % board.length != 0)) {
				Vertex other = result.get(i-1);
				v.addNeighbour(other, W);
				other.addNeighbour(
				
	}

	public static void printBoard(Cell board[][]) {
		for (Cell row[] : board) {
			for (Cell c : row) {
				System.out.printf("*%c", c.n ? '-' : '.');
			}
			System.out.println('*');
			Cell last = null;
			for (Cell c : row) {
				System.out.printf("%c.", c.w ? '|' : '.');
				last = c;
			}
			System.out.println(last.e ? '|' : '.');
		}
		for (Cell c : board[board.length-1]) {
			System.out.printf("*%c", c.s ? '-' : '.');
		}
		System.out.println('*');
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(s.nextLine());

		Cell board[][] = new Cell[N-1][N-1];

		for (int i = 0; i < N; i++) {
			// Odd-numbered lines contain horizontal lines.
			String line = s.nextLine();
			for (int j = 0; j < N-1; j++) {
				if (i != N-1)
					board[i][j] = new Cell();
				// char star = line.charAt(j*2);
				char bar = line.charAt(j*2+1);
				if (bar == '-') {
					if (i != N-1)
						board[i][j].n = true;
					if (i != 0)
						board[i-1][j].s = true;
				}
			}

			// Even-numbered lines contain vertical lines.
			if (i == N-1) break; // There are only N*2-1 lines total.
			line = s.nextLine();
			for (int j = 0; j < N; j++) {
				char bar = line.charAt(j*2);
				// char dot = line[j*2+1];
				if (bar == '|') {
					if (j != N-1)
						board[i][j].w = true;
					if (j != 0) 
						board[i][j-1].e = true;
				}
			}
		}
		// printBoard(board);
	}
}
