#include <math.h>
#include <stdio.h>
#include <stdlib.h>

#define PI 3.141592653589793238462643383
#define EPS 0.000005

typedef struct {
	double x;
	double y;
} point;

point V[10000]; // v="vegetables"
point ch[10000]; // convex hull

int cmp_angle(const void *A, const void *B) {
	point a = *(point *)A;
	point b = *(point *)B;

	// We stash the lowest point in V[0]. Get angle based on that.
	return (a.x-V[0].x)/(a.y-V[0].y) - (b.x-V[0].x)/(b.y-V[0].y);
}

point rotate(double theta, point p) {
	point o;
	o.x = cos(theta)*p.x - sin(theta)*p.y;
	o.y = sin(theta)*p.x + cos(theta)*p.y;

	// printf("rotated (%lf, %lf) %lf degrees to (%lf, %lf)\n", p.x, p.y, theta*360/PI, o.x, o.y);
	return o;
}

int main(void) {
	int N, i, lowest, h;
	double best;
	point p, u, v, uv, up;

	for(;;) {
		if (scanf("%d", &N) == EOF) break;
		lowest = 0;
		for(i = 0; i < N; i++) {
			scanf("%lf %lf", &V[i].x, &V[i].y);
			if ((V[i].y - V[lowest].y) < -EPS) lowest = i;
			else if (fabs(V[i].y - V[lowest].y) < EPS &&
					(V[i].x - V[lowest].x) < -EPS) lowest = i;
		}
		// Put the lowest in v[0]; swap out whatever is there.
		p = V[0];
		V[0] = V[lowest];
		V[lowest] = p;

		// Get the convex hull.
		qsort(&V[1], N-1, sizeof(point), cmp_angle);
		ch[0] = V[0];
		ch[1] = V[1];
		ch[2] = V[2];
		h = 3; // h is the number of points in the hull.
			   // You can also think of it like h = head of the stack.
		for(i = 2; i < N; i++) {
			p = V[i];
			while(h > 3) {
				v = ch[h-1];
				u = ch[h-2];
				uv.x = v.x - u.x; uv.y = v.y - u.y;
				up.x = p.x - u.x; up.y = p.y - u.y;
				// Take cross product to find if we turn left or right.
				if((uv.x*up.y - uv.y*up.x) < -EPS) break;
				h--; // pop from the stack.
			}
			ch[h++] = p;
		}
		for(i = 0; i < h; i++) {
			printf("%lf, %lf\n", ch[i].x, ch[i].y);
		}

		best = INFINITY;
		for(/* pairs of adjacent points in the convex hull */;;) {
			break;
		}
		printf("%lf\n", best);
	}

	return 0;
}

