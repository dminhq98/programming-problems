import java.util.Scanner;

public class Bijele {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int k = s.nextInt(),
			q = s.nextInt(),
			r = s.nextInt(),
			b = s.nextInt(),
			kn = s.nextInt(),
			p = s.nextInt();

		System.out.printf("%d %d %d %d %d %d",
				1 - k,
				1 - q,
				2 - r,
				2 - b,
				2 - kn,
				8 - p);
	}

}
