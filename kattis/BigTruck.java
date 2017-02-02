import java.util.*;

public class BigTruck {
	private static class Edge {
		final int u, v, w;
		public Edge(int from, int to, int weight) {
			u = from;
			v = to;
			w = weight;
		}
	}

	private static class Pair implements Comparable<Pair>{
		final int v, d;
		public Pair(int vertex, int distance) {
			v = vertex;
			d = distance;
		}

		public int compareTo(Pair o) {
			return d - o.d;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int items[] = new int[n];
		int best[] = new int[n];
		List<Edge> adj[] = new ArrayList[n];
		int dist[] = new int[n];
		for(int i = 0; i < n; i++) {
			items[i] = in.nextInt();
			adj[i] = new ArrayList<Edge>();
			dist[i] = Integer.MAX_VALUE;
		}
		int m = in.nextInt();
		for(int i = 0; i < m; i++) {
			int a = in.nextInt() - 1,
				b = in.nextInt() - 1,
				d = in.nextInt();
			Edge e = new Edge(a, b, d);
			adj[a].add(e);
			adj[b].add(e);
		}

		dist[0] = 0;
		best[0] = items[0];
		PriorityQueue<Pair> q = new PriorityQueue<Pair>(n, Collections.reverseOrder());
		q.add(new Pair(0, 0));
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if (p.d > dist[p.v]) continue;
			for(Edge e : adj[p.v]) {
				int u = (e.v == p.v) ? e.u : e.v;
				if (p.d + e.w < dist[u]) {
					dist[u] = p.d + e.w;
					q.add(new Pair(u, p.d + e.w));
					best[u] = best[p.v] + items[u];
				} else if (p.d + e.w == dist[u] && 
						   best[u] < best[p.v] + items[u]) {
					q.add(new Pair(u, p.d + e.w));
					best[u] = best[p.v] + items[u];
				}
			}
		}
		if (dist[n-1] == Integer.MAX_VALUE) {
			System.out.println("impossible");
		} else {
			System.out.printf("%d %d\n", dist[n-1], best[n-1]);
		}
	}
}

