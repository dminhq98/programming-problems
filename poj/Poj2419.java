import java.util.*;

public class Poj2419 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int P = s.nextInt(),
			T = s.nextInt();

		boolean[][] m = new boolean[P][T]; // m = "matrix"
		while (s.hasNext()) {
			int i = s.nextInt(),
				j = s.nextInt();
			
			m[i-1][j-1] = true;
		}

		/*
		int[] h = new int[P]; // h = "hashes"
		for(int i = 0; i < P; i++) {
			int hash = 17;
			for(int j = 0; j < T; j++) {
				if (m[i][j]) {
				hash = hash + 31 * (j+1);
				}
			}
			h[i] = hash;
		}
		*/

		Set<Integer> seen = new HashSet<Integer>(P);
		for(int i = 0; i < P; i++) {
			seen.add(Arrays.hashCode(m[i]));
		}
		System.out.println(seen.size());
	}
}

