import java.util.*;

public class MovieCollection {
	static class Fenwick {
		int[] ft;

		Fenwick( int n ) { 
		   ft = new int[n+1];
		}

		int LSOne( int x ) { return( x & -x ); }

		int rsq( int b ) {
		   int sum = 0;
		   for (; b>0; b -= LSOne(b)) sum += ft[b];
		   return( sum );
		}

		int rsq( int a, int b ) { return( rsq(b) - (a==1 ? 0 : rsq(a-1))); }

		void adjust( int k, int v ) {
		   for (; k < ft.length; k += LSOne(k)) ft[k] += v;
		}

		void print() {
			for(int i = 1; i < ft.length; i++) {
				System.out.printf("%d ", ft[i]);
			}
			System.out.println();
		}

		void printRsq() {
			for(int i = 1; i < ft.length; i++) {
				System.out.printf("%d ", rsq(i));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();
		while(cases-- > 0) {
			int m = in.nextInt(),
				r = in.nextInt();

			Fenwick f = new Fenwick(r+m);
			for(int i = r+2; i <= r+m; i++) {
				f.adjust(i, 1);
			}

			int watched[] = new int[m+1];

			int top = r;
			for(int i = 0; i < r; i++) {
				int watching = in.nextInt();
				int oldWatching = watching;
				if (watched[watching] != 0) {
					// We've watching this movie before.
					// Find its new index.
					watching = watched[watching];
				}
				int above = f.rsq(r+watching);
				System.out.printf("%d ", above);
				
				// The movie we watched can now be found
				// "top" places from the initial top.
				watched[oldWatching] = top-(r+1);
				f.adjust(r+watching, -1);
				f.adjust(top--, 1);
			}
			System.out.println();
		}
	}
}

