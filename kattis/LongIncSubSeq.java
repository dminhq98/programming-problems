import java.util.Arrays;
import java.util.Scanner;

public class LongIncSubSeq {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int len = in.nextInt();
			int[] L = new int[len]; // Holds LIS
			int[] idx = new int[len]; // Holds indices of LIS
			int[] parent = new int[len]; // Holds index of previous number in L when that number was inserted into L.
			int first = in.nextInt();
			L[0] = first;
			int best = 1;
			// parent[0] = 0; idx[0] = 0;

			for(int j = 1; j < len; j++) {
				int n = in.nextInt();
				if (n > L[best-1]) {
					L[best] = n;
					idx[best] = j;
					parent[j] = idx[best-1];
					best += 1;
					continue;
				}

				// If we get here, then the number is lower than the end of our
				// current increasing subsequence. Find where to insert it.
				int i = Arrays.binarySearch(L, n);
				if (i < 0)
					i = -(i + 1);
				if (i >= len)
					i = len-1;
				L[i] = n;
				idx[i] = j;
				parent[j] = idx[i-1];
			}

			System.out.println(best);
			int index = idx[best-1];
			StringBuilder sb = new StringBuilder();
			for(int i = best; i > 0; i--) {
				sb.insert(0, " ");
				sb.insert(0, index);
				index = parent[index];
			}
			System.out.println(sb);
		}
	}
}

