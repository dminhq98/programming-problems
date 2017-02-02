import java.util.*;

public class Guess {
	private static class LargestFirst implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while(in.hasNext()) {
			int n = in.nextInt();
			Deque<Integer> s = new ArrayDeque<Integer>(n);
			Deque<Integer> q = new ArrayDeque<Integer>(n);
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, new LargestFirst());
			boolean isStack = true,
					isQueue = true,
					isPQ = true;
			for(int i = 0; i < n; i++) {
				int type = in.nextInt(),
					x = in.nextInt();
				if(type == 1) {
					s.push(x);
					q.add(x);
					pq.add(x);
				} else {
					if (s.peek() == null || s.pop() != x) {
						// System.out.println("not a stack");
						isStack = false;
					}
					if (q.peek() == null || q.poll() != x) {
						isQueue = false;
						// System.out.println("not a queue");
					}
					if (pq.peek() == null || pq.poll() != x) {
						isPQ = false;
						// System.out.println("not a pq");
					}
				}
			}
			if ((isStack && isQueue) || 
					(isStack && isPQ) || 
					(isQueue && isPQ)) {
				System.out.println("not sure");
			} else if (isStack) {
				System.out.println("stack");
			} else if (isQueue) {
				System.out.println("queue");
			} else if (isPQ) {
				System.out.println("priority queue");
			} else {
				System.out.println("impossible");
			}
		}
	}
}

