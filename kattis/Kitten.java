import java.util.Scanner;

public class Kitten {
	public static int[] tree = new int[101];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int K = Integer.parseInt(in.nextLine());
		while (true) {
			String[] branches = in.nextLine().split(" ");
			int a = Integer.parseInt(branches[0]);
			if (a == -1) break;
			for(int i = 1; i < branches.length; i++) {
				int b = Integer.parseInt(branches[i]);
				tree[b] = a; // parent of b is a.
			}
		}
		// The parent of the root will be left as 0.
		while(K != 0) {
			System.out.printf("%d ", K);
			K = tree[K];
		}
		System.out.println();
	}
}

