#include <stdio.h>

int f(int x) {
	int c = 0;
	while(x != 1) {
		c++;
		if ((x & 0x01) == 0) x = x >> 1;
		else x++;
	}
	return c;
}

int main(void) {
	int i, s, last;
	/*
	for(i = 0x01; i <= 0x100; i++) {
		printf("%x: %d\n", i, f(i));
	}
	puts("");
	for(i = 0x0101; i <= 0xFF01; i += 0x0100) {
		printf("%x: %d\n", i, f(i)-16);
	}
	*/
	s = 0; last = 0;
	for(i = 0x0001; i <= 0x11; i += 0x001) {
		s += f(i);
		//if ((i & 0xF) == 1) {
			printf("%x: %d - %d = %d\n", i, s, last, s - last);
			last = s;
		//}
	}
	return 0;
}

