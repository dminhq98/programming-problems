import java.util.Scanner;

public class Poj1003 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while(s.hasNext()) {
			float c = s.nextFloat(),
				  sum = 0;

			if (c == 0.0)
				break;

			int i;
			for (i = 1; sum < c; sum += 1.0/((i++) + 1));
			System.out.printf("%d card(s)\n", i - 1);
		}
	}
}
