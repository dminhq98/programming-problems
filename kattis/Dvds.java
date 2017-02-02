import java.util.*;

public class Dvds {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int k = Integer.parseInt(in.nextLine());
		for(int instance = 0; instance < k; instance++) {
			int n = Integer.parseInt(in.nextLine());
			Deque<Integer> stack = new ArrayDeque<Integer>(n);

			String line = in.nextLine();
			for(String dvd : line.split(" ")) {
				stack.add(Integer.parseInt(dvd));
			}

			int seeking = 1;
			int moves = 0;
			for (int i : stack) {
				if (i == seeking) seeking++;
				else moves++;
			}

			System.out.println(moves);
		}
	}
}

