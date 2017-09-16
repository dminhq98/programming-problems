import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int caseN = 1;
		while(in.hasNextInt()) {
			int n = in.nextInt();
			double digits = Math.log10(Math.pow(3, n+1) >> n);
			System.out.printf("Case %d: %d\n", caseN++, (int)digits + 1);
		}
	}
}

