import java.util.*;

public class Beekeeper {

	static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || 
				c == 'o' || c == 'u' || c == 'y');
	}
			

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		for(;;) {
			int N = in.nextInt();
			if (N == 0) break;

			int best = -1;
			String favorite = "";
			for(int i = 0; i < N; i++) {
				String job = in.next();
				char last = job.charAt(0);
				int vowelCount = 0;
				for(int j = 1; j < job.length(); j++) {
					char c = job.charAt(j);
					if (c == last && isVowel(c)) {
						vowelCount += 1;
					}
					last = c;
				}
				if (vowelCount > best) {
					best = vowelCount;
					favorite = job;
				}
			}
			System.out.println(favorite);
		}
	}
}

