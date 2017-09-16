import java.util.Scanner;

public class T9Spelling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		int n = Integer.parseInt(line);
		for(int i = 1; i <= n; i++) {
			line = in.nextLine();
			int prev = -1;
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				int num = (c == ' ') ? 0 : ((c - 'a') / 3) + 2;
				int times = (c == ' ') ? 1 : ((c - 'a') % 3) + 1;
				// 7 is 'pqrs', not just 'pqr'; compensate for this.
				if (num == 8) {
					if (c == 's') {
						num = 7;
						times = 4;
					} else { times -= 1; }
				} else if (num == 9) {
					// v is also offset by 7->'pqrs'
					if (c == 'v') {
						num = 8;
						times = 3;
					} else { times -= 1; }
				} else if (num > 9) {
					// y and z will naturally map to 10.
					num = 9;
					times = (c - 'w' + 1);
				}
				if (num == prev) sb.append(' ');
				prev = num;
				while(times-- != 0) {
					sb.append(num);
				}
			}
			System.out.printf("Case #%d: %s\n", i, sb.toString());
		}
	}
}

