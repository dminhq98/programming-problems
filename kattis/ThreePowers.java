import java.util.*;
import java.math.BigInteger;

public class ThreePowers {
	private static final BigInteger three = new BigInteger("3");

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		for(;;) {
			BigInteger n = in.nextBigInteger();
			if (n.equals(BigInteger.ZERO)) break;

			n = n.subtract(BigInteger.ONE);

			List<BigInteger> set = new ArrayList<BigInteger>(65);
			// 2^65 > 10^19.
			for(int i = 0; i < 65; i++) {
				if(n.testBit(i)) {
					set.add(three.pow(i));
				}
			}
			StringBuilder out = new StringBuilder("{ ");
			for(BigInteger bi : set) {
				out.append(bi.toString())
				   .append(", ");
			}
			// Remove trailing comma.
			if (!set.isEmpty()) out.deleteCharAt(out.length()-2);
			out.append("}");

			System.out.println(out);
		}
	}
}

