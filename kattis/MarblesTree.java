import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

public class MarblesTree {
	private static class Vertex {
		int m; // Number of marbles here. Defaults to 0.
		Vertex parent;
		ArrayList<Vertex> children;
		public Vertex() {
			this.children = new ArrayList<Vertex>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Vertex[] vertices = new Vertex[10000];
		while (n != 0) {
			// Populate the list of vertices.
			for(int i = 0; i < n; i++) {
				vertices[i] = new Vertex();
			}
			// Read in the problem.
			for(int i = 0; i < n; i++) {
				String[] line = in.readLine().split(" ");
				int num = Integer.parseInt(line[0])-1;
				int m = Integer.parseInt(line[1]);
				int d = Integer.parseInt(line[2]);
				Vertex vertex = vertices[num];
				vertex.m = m;
				for(int j = 0; j < d; j++) {
					int c = Integer.parseInt(line[3+j])-1;
					Vertex child = vertices[c];
					child.parent = vertex;
					vertex.children.add(child);
				}
			}

			// Bubble all extra marbles up from the leaves toward the root.
			Deque<Vertex> leaves = new ArrayDeque<Vertex>();
			for(int i = 0; i < n; i++) {
				Vertex v = vertices[i];
				if (v.children.size() == 0) leaves.add(v);
				if (v.parent == null) {
					// Set the root's parent to itself.
					v.parent = v;
				}
			}
			int moves = 0;
			while(leaves.size() > 0) {
				// Grab the first leaf from the queue.
				Vertex leaf = leaves.remove();
				// Blindly give or steal from the parent. It's OK if we dip
				// temporarily below 0; it should work out in the end.
				if (leaf.m != 1) {
					moves += Math.abs(leaf.m-1);
					leaf.parent.m += leaf.m-1;
					leaf.m = 1;
				}
				leaf.parent.children.remove(leaf);
				// Put the parent in the queue if it's not the root and is now
				// a leaf. 
				if (leaf.parent.parent != leaf.parent && 
						leaf.parent.children.size() == 0)
					leaves.add(leaf.parent);
			}
			System.out.println(moves);

			// Check if another problem exists. (0 if end of input).
			n = Integer.parseInt(in.readLine());
		}
	}
}

