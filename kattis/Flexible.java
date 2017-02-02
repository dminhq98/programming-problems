import java.util.*;

public class Flexible {

	static boolean[] widths;
	static boolean[] placement;

	private static void placePartitionsAndRecord(int[] partitions) {
		for(int p : partitions) {
			placement[p] = true;
			width = 0;
			for (boolean wall : placement) {
				if (wall) {
					widths[width] = true;
					width = 0;
				} else {
					width += 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int W = in.nextInt(),
			P = in.nextInt();
		widths = new int[W+1];
		widths[0] = true;
		widths[W] = true;
		int[] partitions = new int[P];
		for (int i = 0; i < P; i++) {
			partitions[i] = in.nextInt();
		}


