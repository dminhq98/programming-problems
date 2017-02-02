import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Color {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int S = in.nextInt();
		long C = in.nextLong(),
			 K = in.nextLong();

		// Sort socks into buckets by color.
		SortedMap<Long, Integer> socks = new TreeMap<Long, Integer>();
		for (int i = 0; i < S; i++) {
			long color = in.nextLong();
			if (socks.containsKey(color)) {
				socks.put(color, socks.get(color) + 1);
			} else {
				socks.put(color, 1);
			}
		}

		int machinesRequired = 0;
		int load = 0;
		long colorOfFirstSock = socks.firstKey();
		// socks is a SortedMap, so keySet will be iterated in order.
		for (long color : socks.keySet()) {
			// If the color exceeds K, throw the partial load in.
			if (color - colorOfFirstSock > K) {
				machinesRequired++;
				load = 0;
				colorOfFirstSock = color;
			}

			// Add socks to our (possibly mixed) load.
			load += socks.get(color);
			while (load > C) {
				machinesRequired++;
				load -= C;
				colorOfFirstSock = color;
			}
		}
		if (load > 0) {
			machinesRequired++;
		}
		System.out.println(machinesRequired);
	}
}

