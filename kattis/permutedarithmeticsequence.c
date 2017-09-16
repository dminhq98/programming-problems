#include <stdio.h>
#include <stdlib.h>

int M[100];

int comp(const void *a, const void *b) {
	int A = *((int *)a);
	int B = *((int *)b);
	return A-B;
}

int main(void) {
	int n, i, m, j, d, arith;

	scanf("%d", &n);
	for(i = 0; i < n; i++) {
		scanf("%d", &m);
		for(j = 0; j < m; j++) {
			scanf("%d", &M[j]);
		}
		d = M[1] - M[0];
		arith = 1;
		for(j = 2; j < m; j++) {
			if ((M[j] - M[j-1]) != d) {
				arith = 0;
				break;
			}
		}
		if (arith) {
			puts("arithmetic");
			continue;
		}

		/* Not arithmetic, sort and try again for permuted arithmetic. */
		qsort(&M[0], m, sizeof(int), comp);

		d = M[1] - M[0];
		arith = 1;
		for(j = 2; j < m; j++) {
			if ((M[j] - M[j-1]) != d) {
				arith = 0;
				break;
			}
		}
		if (arith) {
			puts("permuted arithmetic");
		} else {
			puts("non-arithmetic");
		}
	}

	return 0;
}

