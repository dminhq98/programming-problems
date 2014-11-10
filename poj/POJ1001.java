import java.util.Scanner;
import java.math.BigDecimal;

public class POJ1001 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNext()) {
			String R = in.next();
			int n = in.nextInt();

			BigDecimal bd = new BigDecimal(R);

			StringBuilder sb = new StringBuilder(
					bd.pow(n).stripTrailingZeros().toPlainString());

			if(sb.charAt(0) == '0')
				sb.deleteCharAt(0);

			System.out.println(sb);
		}

		in.close();
	}
}
