import java.util.*;

public class Poj2418 {
	static HashMap<String, Integer> map;

	private static List<String> toSortedList(Set<String> set) {
		List<String> l = new ArrayList<String>(set);
		Collections.sort(l);
		return l;
	}

	public static void main(String[] args) {
		map = new HashMap<String, Integer>();
		Scanner s = new Scanner(System.in);
		int nTrees = 0;

		while(s.hasNext()) {
			String name = s.nextLine();
			Integer n = map.get(name);
			if (n == null)
				n = 0;
			map.put(name, n + 1);
			nTrees++;
		}
		for(String name : toSortedList(map.keySet())) {
			System.out.printf("%s %.4f\n", name, ((float)map.get(name)/nTrees) * 100);
		}
	}

}

