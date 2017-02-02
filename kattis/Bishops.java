import java.util.*;

public class Bishops {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()) {
			int N = in.nextInt();
			if (N > 2) System.out.println(N + (N-2));
			else System.out.println(N);
		}
	}
}

