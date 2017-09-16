/* About this problem: Inputs to f(X) are [1, 10000000000000000000] = [0x01,
 * 0xDE0B6B3A7640000]. This fits within a 64-bit long int. Notice that every
 * other operation that f does is a division by 2, euivalent to a bit shift one
 * to the right. An example:
 * 10011 -> 10100 -> 1010 -> 101 -> 110 -> 11 -> 100 -> 10 -> 1. 
 * What is the pattern? It may depend on the number of 1s, and their clustering
 * in a binary number. For example, 1111 -> 10000 -> 1000 -> 100 -> 10 -> 1 (5),
 * while 1011 -> 1100 -> 110 -> 11 -> 100 -> 10 -> 1 (6).
 *
 * Now the next problem: how to quickly count the value of f(X) for a range
 * of numbers. 
 */
#include <cstdio>
#include <unordered_map>

unsigned int f(long int X) {
	unsigned int i = 0;
	for (i = 0; X > 1; X = X >> 1) i += 1 + (X & 0x01);
	return i;
}

int main(void) {
	unsigned int i, q;
	for(i = 1; i != 0x000000FF; i++) {
		q = f(i);
		printf("%x: %u\n", i, q);
	}
	return 0;
}

