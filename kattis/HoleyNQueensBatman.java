class HoleyNQueensBatman {

static int n;
static int count=0;
static int[] x = new int[64];
static boolean[] a;
static boolean[] b;
static boolean[] c;

static void gen ( int col ) {
   for ( int row = 1; row <= n; ++row ) 
      if (a[row] && b[row+col] && c[row-col+n]) { 
         x[col] = row;
         a[row] = b[row+col] = c[row-col+n] = false;
         if (col < n) gen( col+1 ); else count++;
         a[row] = b[row+col] = c[row-col+n] = true;
      }
}

public static void main ( String[] args ) {
	Scanner in = new Scanner(System.in);
	for(;;) {
		int N = in.nextInt(),
			M = in.nextInt();
		if (N == 0 && M == 0) break;

		n = N;
		a = new boolean[N];
		b = new boolean[N];
		c = new boolean[N];
   		for (int i=0; i<64; ++i) a[i]=b[i]=c[i]=true;

		for(; M > 0; M--) {

   System.out.println( "n-Queens for n = "+n );
   gen( 1 );
   System.out.println( "Solutions = "+count );
}

}
