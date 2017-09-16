import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;

public class WalkForest {
	private static final int START = 1;
	private static final int GOAL = 2;
	private static int[] best;
	private static ArrayList<ArrayList<Edge>> adj;
	private static Deque<Integer> s;
	private static class Edge {
		int v, d;
		public Edge(int to, int distance) {
			v = to;
			d = distance;
		}
	}

	private static class PathComp<Integer> implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			java.lang.Integer one = (java.lang.Integer)o1;
			java.lang.Integer two = (java.lang.Integer)o2;
			return best[one.intValue()] - best[two.intValue()];
		}
	}

	public static void main(String[] args) throws Exception {
		best = new int[1001];
		s = new ArrayDeque<Integer>(1001);
		adj = new ArrayList<ArrayList<Edge>>(1001);
		for(int i = 0; i < 1001; i++) {
			adj.add(new ArrayList<Edge>(1001));
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] line;
		for(;;) {
			line = in.readLine().trim().split(" ");
			int N = Integer.parseInt(line[0]);
			if (N == 0) break;
			int M = Integer.parseInt(line[1]);

			for(int i = 1; i <= N; i++) 
				adj.get(i).clear();

			while(M-- > 0) {
				line = in.readLine().trim().split(" ");
				int a = Integer.parseInt(line[0]),
				    b = Integer.parseInt(line[1]),
				    d = Integer.parseInt(line[2]);
				adj.get(a).add(new Edge(b, d));
				adj.get(b).add(new Edge(a, d));
			}

			// First, get the shortest path from the goal to every vertex.
			// If we must reconstruct the path later, we will also need a "prev"
			// array to store parents. This problem only requires distances.
			Arrays.fill(best, Integer.MAX_VALUE);
			best[START] = 0;

			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(N, 
					new PathComp<Integer>());
			pq.add(START);
			while(!pq.isEmpty()) {
				int u = pq.poll();

				for(Edge e : adj.get(u)) {
					int alt = best[u] + e.d;
					if (alt < best[e.v]) {
						best[e.v] = alt;
						pq.add(e.v);
					}
				}
			}

			// Now "best" should contain the length of the shortest path from
			// Jimmy's office (START) to each intersection (vertex).
			// Do a DFS from the office to Jimmy's house, only taking paths
			// which would take us closer to home (GOAL).
			int routes = 0;
			s.clear();
			s.push(GOAL);
			while(!s.isEmpty()) {
				int u = s.pop();
				for(Edge e : adj.get(u)) {
					// Only take paths which take us closer to home.
					if (best[e.v] >= best[u])
						continue;

					// If this path led us home, that's one more route.
					if (e.v == START) routes += 1;
					// Otherwise, explore that path.
					else s.push(e.v);
				}
			}
			System.out.println(routes);
		}
	}
}

