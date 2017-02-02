import java.util.*;

public class Zamka {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt(),
			D = in.nextInt(),
			X = in.nextInt();

		int min = -1,
			max = -1;
		for (Integer i = L; i <= D; i++) {
			String s = i.toString();
			int sum = 0;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				sum += c - '0';
			}
			if (sum == X) {
				min = i;
				break;
			}
		}
		for (Integer i = D; i >= L; i--) {
			String s = i.toString();
			int sum = 0;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				sum += c - '0';
			}
			if (sum == X) {
				max = i;
				break;
			}
		}

		System.out.println(min);
		System.out.println(max);
	}
}

