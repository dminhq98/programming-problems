import java.util.*;

public class ClosestSums {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int caseN = 1;
		while(in.hasNextInt()) {
			System.out.printf("Case %d:\n", caseN);
			int N = in.nextInt();
			List<Integer> nums = new ArrayList<Integer>(N);
			for(int i = 0; i < N; i++) {
				nums.add(in.nextInt());
			}
			Collections.sort(nums);

			int m = in.nextInt();
			for(int i = 0; i < m; i++) {
				int query = in.nextInt();
				int closest = -1;
				int closestDiff = Integer.MAX_VALUE;
				for(int n : nums) {
					for(int nn : nums) {
						if (n == nn) continue;
						int diff = Math.abs(query - (n + nn));
						if (diff < closestDiff) {
							closest = n + nn;
							closestDiff = diff;
						}
					}
				}
				System.out.printf("Closest sum to %d is %d.\n", query, closest);
			}
			caseN += 1;
		}
	}
}
