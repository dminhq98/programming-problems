#include <stdio.h>

char output[41]; // M <= 40, plus null-terminator.
int dist[40];

int max(const int a, const int b) {
	return (a > b) ? a : b;
}

int min(const int a, const int b) {
	return (a < b) ? a : b;
}

int find_path() {
	//TODO TODO
	return 0;
}

int main(void) {
	unsigned int N, i, M, path_found;
	int j;
	scanf("%u", &N);
	while(N--) {
		scanf("%u", &M);
		for(i = 0; i < M; i++) {
			scanf("%d", &dist[i]);
		}

		path_found = find_path();
		if (path_found) {
			puts(output);
		} else {
			// No path made it back to 0.
			puts("IMPOSSIBLE");
		}
	}
	return 0;
}

