#include <stdio.h>
#include <string.h>

char A[11][101];
char B[11][101];
int used_a[11];
int used_b[11];
char s[11*101];
char seek_a[101];
char seek_b[101];

/* Returns the index of a string in the first k elements of arr which starts
 * with s. Returns -1 if it cannot be found. */
/*int find_match(const char arr[11][101], const char *s, const int k) {
	int i;
	for (i = 0; i < k; i++) {
		if (arr[i][0] == c) return i;
	}
	return -1;
}*/

int find_recursive(int K) {
	int i, j;
	size_t len_a, len_b, len_seek_a, len_seek_b;

	/* First, check if we're done. */
	for(i = 0; i < K; i++) {
		if (!used_a[i]) goto label_f;
	}
	return 1;

label_f:
	len_seek_a = strlen(seek_a);
	if (len_seek_a != 0) {
		/* Find in A a token starting with seek_a. */
		for(i = 0; i < K; i++) {
			if (used_a[i]) continue;
			

	} else if (strlen(seek_b) != 0) {
		/* Find in B a token starting with seek_b. */
	} else {
		/* For all unused pairs of tokens which begin with the same letter
		 * (i.e.  potential starting words), try to put a message together. */
		for(i = 0; i < K; i++) {
			if (used_a[i]) continue;
			len_a = strlen(A[i]);
			for(j = 0; j < K; j++) {
				if (used_b[j]) continue;
				len_b = strlen(B[j]);
				if (len_a < len_b) {
					if (strncmp(A[i], B[j], len_a)) {
						used_a[i] = 1; used_b[j] = 1;
						strncpy(&s[len_s], A[i], len_a);
						strncpy(seek_a, &B[j][len_a], len_b - len_a);
						if(find_recursive(K)) return 1;
						else 
					}
				} else /* len_a >= len_b */ {
					if (strncmp(A[i], B[j], len_b)) {
						used_a[i] = 1; used_b[j] = 1;
						strncpy(&s[len_s}, B[j], len_b);
						strncpy(seek_b, &A[j][len_b], len_a - len_b);
						if(find_recursive(K)) return 1;
					}
				}
			}
		}
	}
	/* Failed to find a permutation that works! */
	return 0;
}

int main(void) {
	int k, i, j, x;
	size_t len_a, len_b, shorter;
	while(scanf("%d", &k) != EOF) {
		for(i = 0; i < k; i++) {
			scanf("%s %s", A[i], B[i]);
		}
		
	}

	return 0;
}
