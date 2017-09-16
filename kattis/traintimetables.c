#include <stdio.h>

/* These arrays represent the schedules at each minute of the day. A -1
 * represents one train departing from the station. A 1 represents a train
 * having arrived and finished its turnaround (and thus becoming available).
 */
int A[1440];
int B[1440];

int main(void) {
	int S, T, NA, NB, dHH, dMM, aHH, aMM, i, 
		case_n, min_a, min_b, curr_a, curr_b;
	
	scanf("%d", &S);
	for(case_n = 1; case_n <= S; case_n++) {
		/* Clear out the schedule arrays. */
		for(i = 0; i < 1440; i++) {
			A[i] = 0; B[i] = 0;
		}

		/* Read in the day's schedule. */
		scanf("%d", &T);
		scanf("%d %d", &NA, &NB);
		for(i = 0; i < NA; i++) {
			scanf("%d:%d %d:%d", &dHH, &dMM, &aHH, &aMM);
			dMM += 60*dHH;
			aMM += 60*aHH;
			A[dMM] -= 1;
			if (aMM+T < 1440) B[aMM+T] += 1;
		}
		for(i = 0; i < NB; i++) {
			scanf("%d:%d %d:%d", &dHH, &dMM, &aHH, &aMM);
			dMM += 60*dHH;
			aMM += 60*aHH;
			B[dMM] -= 1;
			if (aMM+T < 1440) A[aMM+T] += 1;
		}

		/* Simulate the day's train trips. */
		min_a = 0; min_b = 0;
		curr_a = 0; curr_b = 0;
		for(i = 0; i < 1440; i++) {
			curr_a += A[i]; curr_b += B[i];
			if (curr_a < min_a) min_a = curr_a;
			if (curr_b < min_b) min_b = curr_b;
		}

		printf("Case #%d: %d %d\n", case_n, -min_a, -min_b);
	}

	return 0;
}

