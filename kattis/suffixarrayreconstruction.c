#include <stdio.h>
#include <string.h>

char str[10001];
char re[10001];

int match_from_back(char *s, char *p, size_t p_len) {
	int i;
	for(i = p_len-1; i >= 0; i++) {
		if (p[i] == '*') return 1;
		if (s[i] == '\0') s[i] = p[i];
		else if (s[i] != p[i]) return 0;
	}
	/* Should never reach here. */
	return 0;
}

/* Looks at each char in s, makes sure it is the same as in p or \0.
 * If a char in s is \0, it acquires the value at the same position in p.
 * If a char in p is *, then this function calls match_from_back to check
 * the other side of the string, ensuring that both sides around the * match. */
int match_from_front(char *s, char *p, size_t p_len) {
	int i;
	for(i = 0; i < p_len; i++) {
		if (p[i] == '*') return match_from_back(s, p, p_len);
		if (s[i] == '\0') s[i] = p[i];
		else if (s[i] != p[i]) return 0;
	}
	return 1;
}

int main(void) {
	int t, i, j, l, s, p, len, possible;
	scanf("%d", &t);
	while(t-- > 0) {
		scanf("%d %d", &l, &s);
		/* str is l chars long. */
		for(i = 0; i <= s; i++) {
			str[i] = '\0';
		}
		possible = 1;
		for(i = 0; i < s; i++) {
			scanf("%d %s", &p, &re[0]);
			len = strlen(re);
			possible = match_from_front(&str[p-1], &re[0], len);
		}
		if (possible) puts(str);
		else puts("IMPOSSIBLE");
	}
	return 0;
}
