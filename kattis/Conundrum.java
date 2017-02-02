import java.util.Scanner;

public class Conundrum {
	public static void main(String[] args) {
		char key[] = {'P', 'E', 'R'};

		Scanner in = new Scanner(System.in);
		String s = in.next();
		int days = 0;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != key[i%3]) {
				days++;
			}
		}
		System.out.println(days);
	}
}
