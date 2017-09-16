#include <stdio.h>

int p[200001];

int find(int i) {
	if (p[i] == i) return i;
	p[i] = find(p[i]);
	return p[i];
}

int main(void) {
	int N, M, i, a, b, pa, pb, connected;
	scanf("%d %d", &N, &M);

	for(i = 1; i <= N; i++) {
		// Each house is a root to start.
		p[i] = i;
	}
	
	for(i = 0; i < M; i++) {
		scanf("%d %d", &a, &b);
		// Union: parent of both is now smallest parent between the two.
		pa = find(a);
		pb = find(b);
		p[pa] = (pa < pb) ? pa : pb;
		p[pb] = (pa < pb) ? pa : pb;
	}

	for(i = 1; i <= N; i++) {
		find(i);
	}

	connected = 1;
	for(i = 1; i <= N; i++) {
		if (p[i] != 1) {
			printf("%d\n", i);
			connected = 0;
		}
	}
	if (connected) puts("Connected");

	return 0;
}
