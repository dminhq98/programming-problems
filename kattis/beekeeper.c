#include <stdio.h>
#include <string.h>

char *vowels = "aeiouy";
int isVowel(char c) {
	for(int i = 0; i < 6; i++) {
		if (c == vowels[i]) return 1;
	}
	return 0;
}

int main() {
	int N, i, j, curr, best;
	char c, last;
	char fav[81];
	char job[81];
	for(;;) {
		scanf("%d", &N);
		if (N == 0) break;

		*fav = '\0';
		for(i = 0; i < N; i++) {
			scanf("%s", job);
			curr = 0;
			last = '\0';
			j = 0;
			for(c = job[0]; c != '\0'; c = job[++j]) {
				if (c == last && isVowel(c)) 
					curr++;
				last = c;
			}
			if (curr >= best) {
				strcpy(fav, job);
			}
		}

		printf("%s\n", fav);
	}
}

