#include <stdio.h>

long sum_of_small_baskets;

void weigh_small_baskets(int *weights, int size, int cur, int sum) {
	for(int i = cur+1; i < size; i++) {
		if (sum + weights[i] >= 200) continue;
		sum_of_small_baskets += sum + weights[i];
		weigh_small_baskets(weights, size, i, sum + weights[i]);
	}
}

int main(int argc, char **argv) {
	int N;
	int weights[40];
	if (scanf("%d", &N) != 1) return -1;

	long sum = 0;
	for(int i = 0; i < N; i++) {
		if (scanf("%d", weights + i) != 1) return -1;
		sum += weights[i];
	}

	long universe = (1l << (N-1)) * sum;
	sum_of_small_baskets = 0;
	weigh_small_baskets(weights, N, -1, 0);
	printf("%ld\n", universe - sum_of_small_baskets);

	return 0;
}

