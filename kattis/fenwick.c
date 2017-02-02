#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

int LSOne(int n) {
	return n & -n;
}

int *ft;
int ft_size;
void create_ft(int n) {
	ft = calloc(n+1, sizeof(int));
	ft_size = n;
}

/*
void print_ft() {
	for(int i = 0; i < ft_size; i++) {
		printf("%d ", ft[i]);
	}
	puts("");
}
*/

int rsq(int b) {
	int sum = 0;
	for(; b != 0; b -= LSOne(b))
		sum += ft[b];
	return sum;
}

void adjust(int k, int v) {
	for(; k < ft_size; k += LSOne(k))
		ft[k] += v;
}

int main() {
	char c; 
	int k, v;
	int N, Q;
	scanf("%d %d\n", &N, &Q);
	create_ft(N+1);
	char *buf = malloc(64);
	for(int i = 0; i < Q; i++) {
		fgets(buf, 64, stdin);
		c = buf[0];
		if (c == '+') {
			sscanf(buf + 2, "%d %d", &k, &v);
			adjust(k+1, v);
		} else if (c == '?') {
			sscanf(buf + 2, "%d", &k);
			printf("%d\n", rsq(k));
		} else assert(0);
	}
	return 0;
}

