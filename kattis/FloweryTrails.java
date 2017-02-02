import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class FloweryTrails {

	static class Point {
		int n;
		List<Trail> trails;
		int dist;
		List<Trail> prev;

		public Point(int n) {
			this.n = n;
			this.dist = Integer.MAX_VALUE;
			trails = new ArrayList<Trail>();
		}
	}

	static class PointComparator implements Comparator<Point> {
		public int compare(Point o1, Point o2) {
			return o1.dist - o2.dist;
		}
	}

	static class Trail {
		int l;
		Point p1, p2;

		public Trail(Point p1, Point p2, int l) {
			this.p1 = p1;
			this.p2 = p2;
			this.l = l;
		}
	}

	static void addPrev(Set<Trail> s, Point p) {
		if (p.prev.isEmpty())
			return;
		s.addAll(p.prev);
		for (Trail t : p.prev) {
			System.out.printf("%d -> %d, l: %d\n", t.p1.n, t.p2.n, t.l);
			Point o = (p != t.p1) ? t.p1 : t.p2;
			addPrev(s, o);
		}
		return;
	}

	static Set<Trail> hike(PriorityQueue<Point> q, Point goal) {
		Set<Trail> popular = new HashSet<Trail>();

		while (!q.isEmpty()) {
			Point curr = q.poll();
			if (curr == goal) {
				// All paths shorter than the shortest path
				// to the goal have been explored.
				break;
			}

			for (Trail t : curr.trails) {
				Point other = (t.p1 != curr) ? t.p1 : t.p2;
				if (other.dist >= curr.dist + t.l) {
					if (other.dist > curr.dist + t.l) {
						other.prev.clear();
						other.dist = curr.dist + t.l;
					}
					q.add(other);
					other.prev.add(t);
				}
			}
		}

		addPrev(popular, goal);
	
		return popular;	
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int P = in.nextInt(),
			T = in.nextInt();

		Point points[] = new Point[P];
		for (int i = 0; i < P; i++) {
			points[i] = new Point(i);
		}

		for (int i = 0; i < T; i++) {
			int one = in.nextInt(),
				two = in.nextInt(),
				l = in.nextInt();
			Point p1 = points[one],
			      p2 = points[two];
			Trail trail = new Trail(p1, p2, l);
			p1.trails.add(trail);
			p2.trails.add(trail);
		}
		for (int i = 0; i < P; i++) {
			points[i].prev = new ArrayList<Trail>(points[i].trails.size());
		}

		PriorityQueue<Point> q = new PriorityQueue<Point>(P, new PointComparator());
		points[0].dist = 0;
		q.add(points[0]);

		Set<Trail> popular = hike(q, points[P-1]);

		int sum = 0;
		for (Trail t : popular) {
			sum += t.l * 2;
		}
		System.out.println(sum);
	}
}

