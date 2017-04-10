#include <stdio.h>
// #include <stdlib.h>

// Sort in decreasing order.
// int cmp (const void *a, const void *b) {
// 	return *(unsigned int *)b - *(unsigned int *)a;
// }

int main(void) {
	unsigned int N, i, t, max;
	unsigned long int sum;
	int ai, gi; // Index of ante and goran in times array.
	// unsigned int *times;
	scanf("%u", &N);
	// times = malloc(sizeof(unsigned int) * N);
	sum = 0; max = 0;
	for (i = 0; i < N; i++) {
		scanf("%u", &t);
		sum += t;
		if (t > max) max = t;
	}
	// qsort(times, N, sizeof(unsigned int), cmp);
	printf("%lu\n", max*2 > sum ? max*2 : sum);

	// free(times);
	return 0;
}
