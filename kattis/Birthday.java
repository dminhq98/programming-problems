import java.util.*;

public class Birthday {
	
	private static class Edge {
		public final int a, b;
		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	private static boolean checkConnectedness(ArrayList neighbours[]) {
		boolean seen[] = new boolean[neighbours.length];
		seen[0] = true;
		Deque<Integer> next = new ArrayDeque<Integer>();
		next.addAll(neighbours[0]);
		while(!next.isEmpty()) {
			int n = next.poll();
			if (!seen[n]) {
				seen[n] = true;
				next.addAll(neighbours[n]);
			}
		}

		for (int i = 0; i < seen.length; i++) {
			if (!seen[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(true) {
			int p = in.nextInt(),
				c = in.nextInt();
			if (p == 0 && c == 0) return;

			ArrayList<Integer> neighbours[] = new ArrayList[p];
			for (int i = 0; i < p; i++) {
				neighbours[i] = new ArrayList<Integer>();
			}
			Edge edges[] = new Edge[c];
			for (int i = 0; i < c; i++) {
				int a = in.nextInt(),
					b = in.nextInt();

				neighbours[a].add(b);
				neighbours[b].add(a);
				edges[i] = new Edge(a, b);
			}

			// Check connectedness.
			boolean isConnected = checkConnectedness(neighbours);
			
			for (Edge e : edges) {	
				// Remove one edge.
				neighbours[e.a].remove((Integer)e.b);
				neighbours[e.b].remove((Integer)e.a);
				// Check connectedness again.
				isConnected = checkConnectedness(neighbours);
				if (!isConnected) break;
				// Replace the edge.
				neighbours[e.a].add(e.b);
				neighbours[e.b].add(e.a);
			}
			
			if (isConnected)
				System.out.println("No");
			else
				System.out.println("Yes");
		}
	}
}

