import java.util.*;

public class PlantingTrees {
	private static class ReverseOrder implements Comparator<Integer> {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(N, new ReverseOrder());
		for(int i = 0; i < N; i++) {
			heap.add(in.nextInt());
		}
		int daysElapsed;
		int daysToParty = -1;
		for(daysElapsed = 1;;daysElapsed++) {
			Integer tree = heap.poll();
			if (tree != null) {
				if (tree > daysToParty) 
					daysToParty = tree;
			}
			if (daysToParty-- == 0) {
				break;
			}
		}
		System.out.println(daysElapsed+1);
	}
}

