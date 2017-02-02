import java.util.*;

public class PermutationEncryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		for(;;) {
			int n = in.nextInt();
			if (n == 0) break;
			int permutation[] = new int[n];
			String[] perms = in.nextLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				permutation[i] = Integer.parseInt(perms[i]);
			}
			String s = in.nextLine();

			int offset = 0;
			StringBuilder out = new StringBuilder();
			out.append('\'');
			while(offset + n <= s.length()) {
				String sub = s.substring(offset, offset + n);
				for(int i = 0; i < n; i++) {
					out.append(sub.charAt(permutation[i] - 1));
				}
				offset += n;
			}
			if (offset != s.length()) {
				// Not at the end yet.
				String sub = s.substring(offset);
				// Pad it with spaces.
				for (int i = sub.length(); i <= n; i++) {
					sub = sub + ' ';
				}
				// Continue as usual.
				for(int i = 0; i < n; i++) {
					out.append(sub.charAt(permutation[i] - 1));
				}
			}
			out.append('\'');

			System.out.println(out);
		}
	}
}

