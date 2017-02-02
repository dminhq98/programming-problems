#include <stdio.h>

int global_sum = 0;

/* Call this function from other functions with (weights, N, 0, -1). */
void gen_baskets(int *weights, int size, int sum, int last_added) {
	for(int i = last_added + 1; i < size; i++) {
		if (sum + weights[i] >= 200)
			global_sum += sum + weights[i];
		gen_baskets(weights, size, sum + weights[i], i);
	}
}

int main(int argc, char **argv) {
	int weights[40];
	int N;
	scanf("%d", &N);
	int i;
	for(i = 0; i < N; scanf("%d", weights + i++));
	weights[i] = 0;

	gen_baskets(weights, N, 0, -1);
	printf("%d\n", global_sum);

	return 0;
}
