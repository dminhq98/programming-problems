#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define QUEUE_SIZE 2000

bool is_prime[10000];
int parent[10000];
int q[QUEUE_SIZE];

void sieve() {
	int i, j;
	is_prime[0] = false;
	is_prime[1] = false;
	for(i = 2; i < 10000; i++) {
		is_prime[i] = true;
	}
	for(i = 2; i < 10000; i++) {
		if (is_prime[i]) {
			for(j = 2; j*i < 10000; j++) {
				is_prime[i*j] = false;
			}
		}
	}
}

int main(void) {
	int i, u, v, dist, cases, start, goal, q_len, q_head;
	char j;
	char s[5], t[5];
	s[4] = '\0';
	t[4] = '\0';
	sieve();

	scanf("%d", &cases);
	while(cases-- > 0) {
		scanf("%d %d", &start, &goal);
		for(i = 1000; i < 10000; i++) {
			parent[i] = 0;
		}
		parent[start] = start;
		q_len = 1;
		q[0] = start;
		q_head = 0;
		while(q_len > 0) {
			u = q[q_head % QUEUE_SIZE];
			q_len -= 1;
			q_head = (q_head + 1) % QUEUE_SIZE;

			if (u == goal) break;

			sprintf(s, "%d", u);
			strcpy(t, s);
			printf("u: %d\n", u);
			for(i = 0; i < 4; i++) {
				for(j = '1'; j <= '9'; j++) {
					if (j == s[i]) continue;
					t[i] = j;
					sscanf(t, "%d", &v);
					if (is_prime[v]) {
						if (parent[v]) continue; // Seen this prime before.
						parent[v] = u;
						printf("v: %d, u: %d\n", v, u);
						q[(q_head + q_len++) % QUEUE_SIZE] = v;
					}
				}
				t[i] = s[i]; // Set it back to what it was.
			}
		}
		dist = 0;
		v = goal;
		while(parent[v] != v) {
			printf("v: %d, parent: %d\n", v, parent[v]);
			v = parent[v];
			dist += 1;
		}
		printf("%d\n", dist);
	}
}

