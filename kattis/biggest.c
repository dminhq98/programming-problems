#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int degrees;
	int minutes;
	int seconds;
} angle;

angle cuts[100000000];

int cmp_angle(const void *a, const void *b) {
	const angle *A = (const angle *)a;
	const angle *B = (const angle *)b;
	if (A->degrees != B->degrees) return A->degrees - B->degrees;
	if (A->minutes != B->minutes) return A->minutes - B->minutes;
	return A->seconds - B->seconds;
}

int main(void) {
	int m, r, n, td, tm, ts, i, j;
	angle theta, rotation, biggest, diff;
	double biggest_angle;

	scanf("%d", &m);
	for(i = 0; i < m; i++) {
		scanf("%d %d %d %d %d", &r, &n, &td, &tm, &ts);
		theta.degrees = td;
		theta.minutes = tm;
		theta.seconds = ts;
		rotation.degrees = 0;
		rotation.minutes = 0;
		rotation.seconds = 0;
		for(j = 0; j < n; j++) {
			cuts[j] = rotation;
			rotation.degrees += theta.degrees;
			rotation.minutes += theta.minutes;
			rotation.seconds += theta.seconds;
			while (rotation.seconds >= 60) {
				rotation.seconds -= 60;
				rotation.minutes += 1;
			}
			while (rotation.minutes >= 60) {
				rotation.minutes -= 60;
				rotation.degrees += 1;
			}
			rotation.degrees = rotation.degrees % 360;
		}
		qsort(cuts, n, sizeof(angle), cmp_angle);

		biggest.degrees = 0;
		biggest.minutes = 0;
		biggest.seconds = 0;
		for(j = 0; j < n; j++) {
			diff.degrees = cuts[j+1%n].degrees - cuts[j].degrees;
			diff.minutes = cuts[j+1%n].minutes - cuts[j].minutes;
			diff.seconds = cuts[j+1%n].seconds - cuts[j].seconds;
			if (diff.seconds < 0) {
				diff.seconds += 60;
				diff.minutes -= 1;
			}
			if (diff.minutes < 0) {
				diff.minutes += 60;
				diff.degrees -= 1;
			}
			if (diff.degrees < 0) diff.degrees += 360;
			if (cmp_angle(&diff, &biggest) > 0)
				biggest = diff;
		}
		biggest_angle = (double)biggest.degrees + 
			(double)biggest.minutes/60 + (double)biggest.seconds/(60*60);
		printf("%lf\n", 3.14159265358979323846*r*r*(biggest_angle/360.0));
	}
	return 0;
}

