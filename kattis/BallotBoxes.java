import java.util.*;

public class BallotBoxes {
	private static class City {
		int population;
		int boxes;
		public City(int pop) {
			population = pop;
			boxes = 1;
		}
	}
	private static class CityComparator implements Comparator<City> {
		public int compare(City o1, City o2) {
			if (o2.population/o2.boxes == o1.population/o1.boxes) {
				return (o2.population % o2.boxes - o1.population/o1.boxes);
			} else return (o2.population/o2.boxes)-(o1.population/o1.boxes);
		}
	}

	private static PriorityQueue<City> heap;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		for(;;) {
			int N = in.nextInt(),
				B = in.nextInt();
			if (N == -1 && B == -1) break;
			B -= N;

			heap = new PriorityQueue<City>(N, new CityComparator());
			for(int i = 0; i < N; i++) {
				City c = new City(in.nextInt());
				heap.add(c);
			}
			for(int i = 0; i < B; i++) {
				City city = heap.poll();
				city.boxes++;
				heap.add(city);
			}
			City head = heap.peek();
			System.out.println(head.population % head.boxes == 0
					? head.population/head.boxes
					: head.population/head.boxes + 1);
		}
	}
}

