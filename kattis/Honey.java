import java.util.Scanner;

public class Honey {
	static int answers[] = { 1, 0, 6, 12, 90, 360, 2040, 10080, 54810, 290640, 1588356, 8676360, 47977776, 266378112, 1488801600 };
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nCases = in.nextInt();
		while(nCases-- > 0) {
			System.out.println(answers[in.nextInt()]);
		}
	}
}
