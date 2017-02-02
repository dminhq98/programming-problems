import java.util.*;

public class MoneyMatters {
	static int[] owed,
				 friends;
	
	static int find(int x) {
		// System.out.printf("%d's parent is %d.\n", x, friends[x]);
		if (friends[x] != x) friends[x] = find(friends[x]);
		return friends[x];
	}
	
	static void union(int x, int y) {
		friends[y] = find(x);
	}

	static void printArr(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),
			m = in.nextInt();

		owed = new int[n];
		friends = new int[n];
		for(int i = 0; i < n; i++) {
			owed[i] = in.nextInt();
			friends[i] = i;
		}

		for(int i = 0; i < m; i++) {
			int x = in.nextInt(),
				y = in.nextInt();
			union(x, y);
		}
		
		for(int i = n-1; i >= 0; i--) {
			if (friends[i] == i) continue;
			int parent = find(i);
			owed[parent] += owed[i];
			owed[i] = 0;
		}
		
		boolean possible = true;
		for(int i = 0; i < n; i++) {
			if (owed[i] != 0) possible = false;
		}
		if (possible) 
			System.out.println("POSSIBLE");
		else
			System.out.println("IMPOSSIBLE");
	}
}

