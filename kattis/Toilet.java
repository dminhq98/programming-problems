import java.util.*;

public class Toilet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();

		int up = 0,
			down = 0,
			pref = 0;
		
		char state = s.charAt(0);
		char first = s.charAt(1);
		if (state != first) {
			up += 1;
			down += 1;
			pref += 1;
		}
		if (first == 'U') {
			down += 1;
		} else {
			up += 1;
		}
		state = first;

		for(int i = 2; i < s.length(); i++) {
			char c = s.charAt(i);
			if (state != c) {
				pref += 1;
			}
			if (c == 'U') {
				down += 2;
			} else if (c == 'D') {
				up += 2;
			}
			state = c;
		}

		System.out.println(up);
		System.out.println(down);
		System.out.println(pref);
	}
}

