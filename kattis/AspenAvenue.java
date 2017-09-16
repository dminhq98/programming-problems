import java.util.*;

public class AspenAvenue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt(),
			L = in.nextInt(),
			W = in.nextInt();

		int[] trees = new int[N];
		for(int i = 0; i < N; i++) {
			trees[i] = in.nextInt();
		}

		Arrays.sort(trees);

		double d = ((double)L)/(N/2-1); // distance between trees

	}
}

