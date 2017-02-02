import java.util.Scanner;

public class Poj1504 {

	private static int reverse(int x) {
		String s = String.format("%d", x);
		String rev = new StringBuilder(s).reverse().toString();
		return Integer.parseInt(rev);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ncases = s.nextInt();

		for (int i = 0; i < ncases; i++) {
			int a = s.nextInt();
			int b = s.nextInt();

			System.out.printf("%d\n", reverse(reverse(a) + reverse(b)));
		}
	}
}
