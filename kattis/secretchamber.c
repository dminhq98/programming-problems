#include <stdio.h>
#include <stdbool.h>

bool tr[26][26];
bool seen[26];

/* starting at s1, try to transform a string to s2.
 * true on success, false on failure. */
bool find_char(char c1, char c2) {
	if (c1 == c2) return true;
	while(c1 != c2 && seen[c1] != true) {
		seen[c1] = true;
		c1 = tr[c1];
	}

	

int main(void) {
	int n, m, i, j, k;
	char c1, c2;

	scanf("%d %d", &n, &m);
	for (i = 0; i < n; i++) {
		scanf(" %c %c", c1, c2);
		tr['a'-c1]['a'-c2] = true;
	}

	char s1[51], s2[51];
	bool yes;
	for (i = 0; i < m; i++) {
		scanf("%s %s", s1, s2);
		yes = false;
		for(j = 0; s1[j] != '\0' && s2[j] != '\0'; j++) {
			
			if (s1[j] == s2[j]) continue;
			if (!tr[s1[j]][s2[j]]) {
				for (k = 0; k < 26; seen[k++] = false);
				if (!find_char(s1[j], s2[j]))
			}
		}
		puts(yes ? "yes" : "no");
	}
}

