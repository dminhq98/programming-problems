public class HoneyHelper {

	static int walk(int x, int y, int n) {
		if (n == 0) {
			// Did we make it back to the origin?
			if (x == 0 && y == 0) return 1;
			return 0;
		}

		// Short-circuit: are we too far away to make it back in n steps?
		if (x > n || -x > n || y > n || -y > n) return 0;

		int sum = 0;
		if (y % 2 == 0) { // even-numbered honeycomb row
			// We can travel up, down, left, right, AND up-right and down-right.
			sum += walk(x, y+1, n-1); // up
			sum += walk(x, y-1, n-1); // down
			sum += walk(x-1, y, n-1); // left
			sum += walk(x+1, y, n-1); // right
			sum += walk(x+1, y+1, n-1); // up-right
			sum += walk(x+1, y-1, n-1); // down-right
		} else { // odd-numbered honeycomb row
			// We can travel up, down, left, right, AND up-left and down-left.
			sum += walk(x, y+1, n-1); // up
			sum += walk(x, y-1, n-1); // down
			sum += walk(x-1, y, n-1); // left
			sum += walk(x+1, y, n-1); // right
			sum += walk(x-1, y+1, n-1); // up-left
			sum += walk(x-1, y-1, n-1); // down-left
		}
		return sum;
	}

	public static void main(String[] args) {
		for(int i = 1; i < 15; i++) {
			System.out.printf("%d, ", walk(0, 0, i));
		}
		System.out.println();
	}
}

