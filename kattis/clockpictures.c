#include <stdio.h>
#include <stdlib.h>

int hands1[200000];
int hands2[200000];
int T[200001];

int cmp (const void *a, const void *b) {
	return *(int*)a - *(int*)b;
}

int kmp(int n) {
	int i, j;

	// Build table.
	i = 0; j = -1; T[0] = -1;
	while (i < n) {
		while (j >= 0 && hands1[i] != hands1[j]) 
			j = T[j]; // if different, reset j using T
		i++; j++; // if same, advance both pointers
		T[i] = j;
	}

	// Do search.
	i = 0; j = 0;
	while (i < 2*n) {
		while (j >= 0 && hands2[i%n] != hands1[j]) {
			j = T[j];
		}
		i++; j++;
		if (j == n) return 1;
	}
	return 0;
}

int main() {
	int n, i;
	scanf("%d", &n);
	for(i = 0; i < n; i++) {
		scanf("%d", &hands1[i]);
	}
	for(i = 0; i < n; i++) {
		scanf("%d", &hands2[i]);
	}
	qsort(hands1, n, sizeof(int), cmp);
	qsort(hands2, n, sizeof(int), cmp);

	// Compute differences.
	int first1 = hands1[0],
	    first2 = hands2[0];
	for(i = 0; i < n-1; i++) {
		hands1[i] = hands1[i+1] - hands1[i]; 
		hands2[i] = hands2[i+1] - hands2[i]; 
	}
	hands1[n-1] = first1 + 360000 - hands1[n-1];
	hands2[n-1] = first2 + 360000 - hands2[n-1];

	puts(kmp(n) ? "possible" : "impossible");

	return 0;
}

