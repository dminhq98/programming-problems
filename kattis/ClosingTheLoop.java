import java.util.*;

public class ClosingTheLoop {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		for(int caseN = 0; caseN < N; caseN++) {
			int[] B = new int[1000];
			int[] R = new int[1000];
			int S = Integer.parseInt(in.nextLine());
			int b = 0, r = 0;
			String[] segments = in.nextLine().trim().split(" ");
			for(int i = 0; i < S; i++) {
				int len = segments[i].length();
				char color = segments[i].charAt(len-1);
				if (color == 'B') 
					B[b++] = Integer.parseInt(segments[i].substring(0, len-1));
				else if (color == 'R')
					R[r++] = Integer.parseInt(segments[i].substring(0, len-1));
				else throw new RuntimeException();
			}
			Arrays.sort(B);
			Arrays.sort(R);
			if (Math.min(b, r) == 0) {
				System.out.printf("Case #%d: 0\n", caseN+1);
				continue;
			}
			int sum = 0;
			int i;
			for (i = 999; i > 999-Math.min(b, r); i--) {
				sum += B[i] - 1;
				sum += R[i] - 1;
			}
			System.out.printf("Case #%d: %d\n", caseN+1, sum);
		}
	}
}

