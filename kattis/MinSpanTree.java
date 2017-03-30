import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinSpanTree {

	static class Edge implements Comparable<Edge> {
		final int a, b, w;

		public Edge(int a, int b, int w) {
			int x, y;
			if (a <= b) {
				x = a;
				y = b;
			} else {
				x = b;
				y = a;
			}
			this.a = x;
			this.b = y;
			this.w = w;
		}

		public String toString() {
			return String.format("%d %d", a, b);
		}

		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}

	static class Lexicographic implements Comparator<Edge> {
		public int compare(Edge o1, Edge o2) {
			if (o1.a != o2.a) return o1.a - o2.a;
			return o1.b - o2.b;
		}
	}

	static class Vertex {
		Vertex parent;
		int rank;

		public Vertex() {
			parent = this;
			rank = 1;
		}

		public void union(Vertex v) {
			Vertex root = this.find();
			Vertex vRoot = v.find();
			if (root.rank < vRoot.rank) {
				root.parent = vRoot;
				root.rank = vRoot.rank;
			} else {
				vRoot.parent = root;
				if (vRoot.rank == root.rank) {
					root.rank++;
				}
			}
		}

		public Vertex find() {
			if (parent != this)
				this.parent = parent.find();
			return parent;
		}
	}

    static BufferedReader IN = new BufferedReader(
			new InputStreamReader(System.in));
	static StringTokenizer ST;
    static String next() throws Exception {
        while (!ST.hasMoreTokens()) ST = new StringTokenizer(IN.readLine());
        return ST.nextToken();
    }
    
    static int nextInt() throws Exception {
        return( Integer.parseInt(next()) );
    }
    
	public static void main(String[] args) throws Exception {
		ST = new StringTokenizer(IN.readLine());
		Vertex V[] = new Vertex[20000];
		Edge mst[] = new Edge[19999];
		Edge E[] = new Edge[30000];
		Comparator<Edge> c = new Lexicographic();
		while (true) {
			int n = nextInt();
			int m = nextInt();
			if (n == 0 && m == 0) break;

			if (m == 0) {
				System.out.println("Impossible");
				continue;
			}

			for (int i = 0; i < n; i++) {
				V[i] = new Vertex();
			}

			for (int i = 0; i < m; i++) {
				int a = nextInt();
				int b = nextInt();
				int w = nextInt();

				E[i] = new Edge(a, b, w);
			}

			int sumCost = 0,
				mstCount = 0;
			Arrays.sort(E, 0, m);
			for (int i = 0; i < m; i++) {
				Edge e = E[i];
				if (V[e.a].find() != V[e.b].find()) {
					mst[mstCount] = e;
					V[e.a].union(V[e.b]);
					sumCost += e.w;
					mstCount++;
				}
			}

			if (mstCount != n-1) {
				System.out.println("Impossible");
				continue;
			}

			System.out.println(sumCost);
			Arrays.sort(mst, 0, n-1, c);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n-1; i++) {
				sb.append(mst[i]).append('\n');
			}
			System.out.print(sb.toString());
		}
	}
}
