import java.util.Scanner;
import java.math.BigInteger;

public class AnotherCandies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int nCases = Integer.parseInt(in.nextLine());
		while(nCases-- > 0) {
			BigInteger sum = new BigInteger("0");
			in.nextLine();
			int N = Integer.parseInt(in.nextLine());
			for(int i = 0; i < N; i++) {
				long candies = Long.parseLong(in.nextLine());
				sum = sum.add(BigInteger.valueOf(candies));
			}
			if (sum.mod(BigInteger.valueOf(N)).equals(BigInteger.ZERO)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
