import java.util.Scanner;
import java.math.BigDecimal;

public class Poj1001 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) {
			BigDecimal r = s.nextBigDecimal();
			int n = s.nextInt();

			String str = r.pow(n).stripTrailingZeros().toPlainString();
			if (str.startsWith("0."))
				str = str.substring(1);
			System.out.println(str);
		}
	}
}
