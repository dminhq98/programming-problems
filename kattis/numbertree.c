#include <stdio.h>

char seq[31];

int main(void) {
	int H;
	scanf("%d %[^\n]s\n", &H, seq);
	int root = 1;
	for(int i = 0; i < H; i++) {
		if (seq[i] == '\0') break;
		root = root << 1;
		if (seq[i] == 'R') root += 1;
	}
	printf("%d\n", (2 << H) - root);
}

