import java.util.Scanner;

public class Geppetto {
	private static boolean[][] prohib;
	
	static boolean prohibited(int a, int b) {
		return prohib[a][b];
	}

	static boolean hasOnlyOneBitSet(int n) {
		boolean bitSet = false;
		for(int i = 1; i < (1<<21); i = i<<1) {
			if ((n & i) != 0) {
				if(bitSet) return false;
				bitSet = true;
			}
		}
		return bitSet;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(),
			M = in.nextInt();
		prohib = new boolean[N][N];
		for(int i = 0; i < M; i++) {
			int a = in.nextInt() - 1,
				b = in.nextInt() - 1;
			prohib[a][b] = true;
			prohib[b][a] = true;
		}

		int count = 1; // We can always make pizza 0, the one with no toppings.
		for(int pizza = 1; pizza < (1<<N); pizza++) {
			if (hasOnlyOneBitSet(pizza)) {
				count++;
				continue;
			}
			boolean allowed = true;
outerLoop:	for(int i = 0; i < 20; i++) {
				if ((pizza & (1<<i)) != 0) {
					for(int j = i+1; j < 20; j++) {
						if ((pizza & (1<<j)) != 0) {
							// Found a bit pair.
							if (prohibited(i, j)) {
								allowed = false;
								break outerLoop;
							}
						}
					}
				}
			}
			if (allowed) count++;
		}
		System.out.println(count);
	}
}

