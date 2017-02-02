import java.util.*;

public class Horror {

	public static void renumberFrom(int i, int[] movies, ArrayList[] edges) {
		int horrorIndex = movies[i];
		ArrayList<Integer> neighbours = edges[i];
		for (int neighbour : neighbours) {
			if (movies[neighbour] > horrorIndex + 1) {
				movies[neighbour] = horrorIndex + 1;
				renumberFrom(neighbour, movies, edges);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(),
			H = in.nextInt(),
			L = in.nextInt();
		int movies[] = new int[N];
		int horrors[] = new int[H];
		ArrayList edges[] = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			movies[i] = N;
			edges[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < H; i++) {
			int h = in.nextInt();
			movies[h] = 0;
			horrors[i] = h;
		}
		for(int i = 0; i < L; i++) {
			int a = in.nextInt(),
				b = in.nextInt();
			edges[a].add(b);
			edges[b].add(a);
		}

		// Now we have an array of movies where the horrors bear their
		// horror index (0), and all other movies' HIs are set to N.
		// Note that in this problem, an HI > (N-1) ~= +∞.
		// We also have all bidirectional "edges" in adjacency lists.
		// We want to number all the movies properly, so we do a search:
		for(int h : horrors) {
			renumberFrom(h, movies, edges);
		}

		int highest = 0;
		int highestIdx = 0;
		for(int i = 0; i < N; i++) {
			if (movies[i] > highest) {
				highest = movies[i];
				highestIdx = i;
			}
		}

		System.out.println(highestIdx);
	}
}

