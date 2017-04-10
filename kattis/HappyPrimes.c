#include <stdio.h>
#include <stdbool.h>

bool notPrime[10001] = { false };
bool happyPrime[10001] = { false };

void sieve() {
	notPrime[0] = true;
	notPrime[1] = true;
	for(int i = 2; i < 10001; i++) {
		if (!notPrime[i]) {
			for(int j = 2; i*j < 10001; j++) {
				notPrime[i*j] = true;
			}
		}
	}
}

int getSumOfSquaredDigits(int n) {
	int sum = 0;
	while(n > 0) {
		int digit = n % 10;
		sum += digit*digit;
		n /= 10;
	}
	return sum;
}

bool isHappyPrime(int n) {
	if (notPrime[n]) return false;

	int tortoise = n, hare = getSumOfSquaredDigits(n);
	while(true) {
		tortoise = getSumOfSquaredDigits(tortoise);
		hare = getSumOfSquaredDigits(hare);
		if (hare == 1) return true;
		if (tortoise == hare) return false;
		// Second move:
		hare = getSumOfSquaredDigits(hare);
		if (hare == 1) return true;
		if (tortoise == hare) return false;
	}
}

int main(void) {
	sieve();
	for(int i = 0; i < 10001; i++) {
		happyPrime[i] = isHappyPrime(i);
	}
	int P, K, m;
	scanf("%d", &P);
	while(P-- > 0) {
		scanf("%d %d", &K, &m);
		printf("%d %d %s\n", K, m, happyPrime[m] ? "YES" : "NO");
	}
}

