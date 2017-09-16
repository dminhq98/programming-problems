#include <stdio.h>

int f(unsigned long x) {
	int i = 0;
	while (x != 1) {
		if ((x & 0x01) == 0) x = x >> 1;
		else x = x+1;
		i++;
	}
	return i;
}

unsigned long S(unsigned long L, unsigned long R) {
	if (L == R) return f(L);
	if (L == 1) return S(L+1, R);
	if ((L & 0x01) == 0) return S(L+1, R) + f(L);
	if ((R & 0x01) == 1) return S(L, R-1), + f(R);
	return 2*S((L+1)>>1, R>>1) + (3*(R-L+1)>>1);
}

int main(void) {
	unsigned long L, R;
	scanf("%lu %lu", &L, &R);
	printf("%lu\n", S(L, R));
}
