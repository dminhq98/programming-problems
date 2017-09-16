#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char buf[1000];

typedef struct {
	char *s;
	size_t len;
} str;
str sortme[100];

int sort_rev_alpha(const void *a, const void *b) {
	int i, slen;
	char c1, c2;
	str *s1 = (str *)a;
	str *s2 = (str *)b;
	slen = (s1->len < s2->len) ? s1->len : s2->len;
	for(i = 1; i <= slen; i++) {
		c1 = s1->s[(s1->len)-i]; c2 = s2->s[(s2->len)-i];
		if (c1 != c2) return c1 - c2;
	}
	return s1->len - s2->len;
}

int main(void) {
	ssize_t len, longest = 0, padding;
	int i, j, n = 0;
	char *in_buf = &buf[0];
	size_t longest_line = 1000;
	for(;;) {
		len = getline(&in_buf, &longest_line, stdin);
		if (len == -1) break;
		if (len > 1) {
			sortme[n].s = malloc(sizeof(char)*len);
			strncpy(sortme[n].s, buf, len);
			// Chomp newline, adjust len.
			sortme[n].s[--len] = '\0';
			sortme[n].len = len;
			if (len > longest) longest = len;
			n++;
		} else {
			qsort(sortme, n, sizeof(str), sort_rev_alpha);
			for(i = 0; i < n; i++) {
				padding = longest - sortme[i].len;
				for(j = 0; j < padding; buf[j++] = ' ');
				strncpy(&buf[padding], sortme[i].s, longest_line-padding);
				printf("%s\n", buf);
				free(sortme[i].s);
			}
			n = 0; longest = 0;
			puts("");
		}
	}
	// One more time, in case input not terminated by an empty line.
	qsort(sortme, n, sizeof(str), sort_rev_alpha);
	for(i = 0; i < n; i++) {
		padding = longest - sortme[i].len;
		for(j = 0; j < padding; buf[j++] = ' ');
		strncpy(&buf[padding], sortme[i].s, longest_line-padding);
		printf("%s\n", buf);
		free(sortme[i].s);
	}
}


