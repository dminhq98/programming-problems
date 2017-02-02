import java.util.*;

public class Orders {

    static String solution;
    static void dfs(int[] items,int order,List<Integer> last,int sum) {
        if (sum == order) {
            if (solution.equals("Impossible")) {
                StringBuilder sb = new StringBuilder();
                for(Integer n : last) {
                    sb.append(n+1).append(' ');
                }
                solution = sb.substring(0, sb.length()-1);
            } else solution = "Ambiguous";
            return;
        }
        int init = (last.isEmpty()) ? 0 : last.get(last.size()-1);
        for(int i = init; i < items.length; i++) {
            if (sum + items[i] <= order) {
                last.add(i);
                dfs(items, order, last, sum + items[i]);
                last.remove(last.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] items = new int[n];
        for(int i = 0; i < n; i++) {
            items[i] = in.nextInt();
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i++) {
            int order = in.nextInt();
            solution = "Impossible";
            dfs(items, order, new ArrayList<Integer>(), 0);
            System.out.println(solution);
        }
    }
}

