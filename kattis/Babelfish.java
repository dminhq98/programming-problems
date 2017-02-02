import java.util.*;

public class Babelfish {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, String> dict = new HashMap<String, String>(200000);
		for(;;) {
			String[] s = in.nextLine().trim().split(" ");
			if (s.length < 2) break;
			dict.put(s[1], s[0]);
		}
		while(in.hasNext()) {
			String s = in.nextLine().trim();
			if (dict.containsKey(s)) {
				System.out.println(dict.get(s));
			} else {
				System.out.println("eh");
			}
		}
	}
}

