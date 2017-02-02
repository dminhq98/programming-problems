import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Poj1308 {

	static boolean isConnectedAndAcyclic(
			Map<Integer, List<Integer>> adj, int root) {
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> seen = new ArrayList<Integer>();
		q.offer(root);

		Integer v;
		while((v = q.poll()) != null) {
			seen.add(v);
			for (int child : adj.get(v)) {
				if (seen.contains(child)) {
					return false;
				}
				q.offer(child);
			}
		}

		if (seen.size() != adj.keySet().size()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int ncase = 1;

		// An adjacency list for all vertices.
		Map<Integer, List<Integer>> adj = 
			new HashMap<Integer, List<Integer>>();
		List<Integer> verticesWithParents =
			new ArrayList<Integer>();

		boolean isTree = true;
		while(true) {
			int a = s.nextInt();
			int b = s.nextInt();

			if ((a | b) < 0)
				break; // End of all input.

			if (!((a | b) == 0)) {
				// a -> b is an edge. Store it.
				if (a == b) {
					isTree = false;
				}
				if (!adj.containsKey(a)) {
					adj.put(a, new ArrayList<Integer>());
				}
				if (!adj.containsKey(b)) {
					adj.put(b, new ArrayList<Integer>());
				}
				adj.get(a).add(b);

				// Also check for multiple parents.
				if (verticesWithParents.contains(b)) {
					isTree = false;
				} else {
					verticesWithParents.add(b);
				}
			} else {
				// End of input for this test case.
				// First find the root. There should be exactly one
				// vertex without a parent.
				int root = -1;
				List<Integer> allVertices =
					new ArrayList<Integer>(adj.keySet());
				allVertices.removeAll(verticesWithParents);
				if (allVertices.size() != 1) {
					isTree = false;
				} else {
					root = allVertices.get(0);
				}

				// Check for connectedness and cycles.
				if (root != -1 && !isConnectedAndAcyclic(adj, root)) {
					isTree = false;
				}
				if (isTree) {
					System.out.printf("Case %d is a tree.\n", ncase++);
				} else {
					System.out.printf("Case %d is not a tree.\n", ncase++);
				}

				// Reset for next test case.
				adj.clear();
				verticesWithParents.clear();
				isTree = true;
			}
		}
	}
}
