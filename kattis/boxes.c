#include <stdio.h>

// a box is its own parent if it is contained by no other box. (a root)
int parent[200001];
// count of children a box has.
int children[200001];
// holds the current query.
int query[20];

int is_parent(int p, int c) {
	if (p == 0) return 0;
	while(parent[c] != 0) {
		if (parent[c] == p) return 1;
		c = parent[c];
	}
	return 0;
}

int main(void) {
	int N, Q, M, i, b, j, k, sum;

	// Read in parents.
	scanf("%d", &N);
	for(i = 1; i <= N; i++) {
		scanf("%d", &parent[i]);
	}

	// Once all parent relationships are known, count the children.
	for(i = 1; i <= N; i++) {
		b = i;
		while (parent[b] != 0) {
			children[parent[b]] += 1;
			b = parent[b];
		}
	}

	// Answer queries.
	scanf("%d", &Q);
	for(i = 0; i < Q; i++) {
		// Read in the query.
		scanf("%d", &M);
		for(j = 0; j < M; j++) {
			scanf("%d", &query[j]);
		}
		// Find out which boxes contain which by comparing pairs in query.
		// If a box contains another box, then delete the child box by setting
		// it to 0 in query.
		for(j = 0; j < M; j++) {
			if (query[j] == 0) continue;
			for(k = 0; k < M; k++) {
				if (query[k] == 0) continue;
				if (is_parent(query[j], query[k])) {
					//printf("%d is the parent of %d\n", query[j], query[k]);
					query[k] = 0;
				} else if (is_parent(query[k], query[j])) {
					//printf("%d is the parent of %d\n", query[k], query[j]);
					query[j] = 0; break;
				}
			}
		}
		// Count the number of boxes contained in all "root" boxes found.
		sum = 0;
		for(j = 0; j < M; j++) {
			if (query[j] != 0) sum += children[query[j]] + 1;
		}
		printf("%d\n", sum);
	}

	return 0;
}
