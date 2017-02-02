import java.util.*;

public class SSSP {

	private static class Comp implements Comparator<Long>{
		public int compare(Long o1, Long o2) {
			// We use the lower-order bits for weight.
			return (int)(o2 & 0xFFFFFFFF) - (int)(o1 & 0xFFFFFFFF);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		for(;;) {
			int n = in.nextInt(),
			m = in.nextInt(),
			qn = in.nextInt(),
			s = in.nextInt();
			if (n == 0 && m == 0 && qn == 0 && s == 0)
				break;

			List<Long> adj[] = new ArrayList[n];
			int dist[] = new int[n];
			for(int i = 0; i < n; i++) {
				adj[i] = new ArrayList<Long>(64);
				dist[i] = Integer.MAX_VALUE;
			}
			for(int i = 0; i < m; i++) {
				int a = in.nextInt(),
					b = in.nextInt(),
					d = in.nextInt();
				long e = ((long)b << 32) + d;
				adj[a].add(e);
			}

			dist[s] = 0;
			PriorityQueue<Long> q = new PriorityQueue<Long>(n, new Comp());
			q.add(((long)s) << 32);
			while(!q.isEmpty()) {
				long aa = q.poll();
				int v = (int)(aa >> 32);
				int d = (int)(aa & 0xFFFFFFFF);
				if (d > dist[v]) continue;
				for(Long ee : adj[v]) {
					int u = (int)(ee >> 32);
					int w = (int)(ee & 0xFFFFFFFF);
					if (d + w < dist[u]) {
						dist[u] = d + w;
						q.add((((long)u) << 32) + (d + w));
					}
				}
			}

			for(int i = 0; i < qn; i++) {
				int query = in.nextInt();
				if (dist[query] == Integer.MAX_VALUE)
					System.out.println("Impossible");
				else System.out.println(dist[query]);
			}
			System.out.println();
		}
	}
}

