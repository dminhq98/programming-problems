import java.util.*;

public class Collatz {

	private static void populate(Map<Long, Long> next, Map<Long, Integer> steps, long x) {
		if (x == 1) return;
		long n = x%2==0 ? x/2 : x*3+1;
		if (!next.containsKey(x)) {
			next.put(x, n);
			populate(next, steps, n);
		}
		steps.put(x, steps.get(n) + 1);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Map<Long, Long> next = new HashMap<Long, Long>();
		Map<Long, Integer> stepsFromOne = new HashMap<Long, Integer>();
		next.put(8l, 4l);
		next.put(4l, 2l);
		next.put(2l, 1l);
		stepsFromOne.put(1l, 0);
		stepsFromOne.put(2l, 1);
		stepsFromOne.put(4l, 2);
		stepsFromOne.put(8l, 3);
		long A = in.nextLong(),
			 B = in.nextLong();
		while(A != 0 && B != 0) {
			populate(next, stepsFromOne, A);
			populate(next, stepsFromOne, B);
			
			long a = A,
				 b = B;
			int aSteps = 0,
				bSteps = 0;
			int diff = Math.abs(stepsFromOne.get(A) - stepsFromOne.get(B));
			if (stepsFromOne.get(A) >= stepsFromOne.get(B)) {
				for (int i = 0; i < diff; i++) {
					a = next.get(a);
					aSteps++;
				}
			} else {
				for (int i = 0; i < diff; i++) {
					b = next.get(b);
					bSteps++;
				}
			}
			int extra = 0;
			while (a != b) {
				a = next.get(a);
				b = next.get(b);
				extra++;
			}

			System.out.printf("%d needs %d steps, %d needs %d steps, they meet at %d\n",
					A, aSteps + extra, B, bSteps + extra, a /* or b */);

			A = in.nextInt();
			B = in.nextInt();
		}
	}
}
