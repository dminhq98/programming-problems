import java.util.*;

public class Fenwick {
	// Returns the integer represented by only 
	// the least significant set bit (1) in n.
	private static int LSOne(int n) {
		return n & -n;
	}

	private int[] ft;
	public Fenwick(int n) {
		ft = new int[n+2];
	}

	int rsq(int b) {
		int sum = 0;
		for(; b != 0; b -= LSOne(b))
			sum += ft[b];
		return sum;
	}

	int rsq(int a, int b) {
		return rsq(b) - (a == 1 ? 0 : rsq(a-1));
	}

	void adjust(int k , int v) {
		for(; k < ft.length; k += LSOne(k))
			ft[k] += v;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(),
			Q = in.nextInt();
		in.nextLine();

		Fenwick fen = new Fenwick(N+1);
		for (int i = 0; i < Q; i++) {
			String[] tokens = in.nextLine().split(" ");
			if (tokens[0].equals("+")) {
				fen.adjust(Integer.parseInt(tokens[1]) + 1, Integer.parseInt(tokens[2]));
			} else if (tokens[0].equals("?")) {
				System.out.println(fen.rsq(Integer.parseInt(tokens[1])));
			} else throw new RuntimeException();
		}
	}
}

