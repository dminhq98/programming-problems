import java.util.*;

public class SecretMessage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		for (int k = 0; k < N; k++) {
			String s = in.nextLine();

			int size;
			for(size = 0; size <= 100; size++) {
				if (s.length() <= size*size) {
					break;
				}
			}

			char table[][] = new char[size][size];
			for(int i = 0; i < s.length(); i++) {
				table[i/size][i%size] = s.charAt(i);
			}

			for(int i = 0; i < size; i++) {
				for(int j = size - 1; j >= 0; j--) {
					if (table[j][i] == 0)
						continue;
					System.out.print(table[j][i]);
				}
			}
			System.out.println();
		}
	}
}
