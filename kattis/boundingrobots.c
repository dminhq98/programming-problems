#include <stdio.h>

int main() {
	unsigned int w, l, n, dist, i;
	int rx, ry, ax, ay;
	char dir;
	for(;;) {
		scanf("%u %u", &w, &l);
		if (w == 0 && l == 0) {
			break;
		}
		rx = 0; ry = 0; // Robot's presumed position.
		ax = 0; ay = 0; // Robot's actual position.
		scanf("%u", &n);
		for(i = 0; i < n; i++) {
			/* "Up and down move along the length of the room, left and right
			 * along the width. Up and right are in the positive direction,
			 * down and left are in the negative direction." */
			scanf(" %c %u", &dir, &dist);
			switch(dir) {
				case 'u':
					ry += dist;
					ay += dist;
					if (ay >= l) ay = l-1;
					break;
				case 'd':
					ry -= dist;
					ay -= dist;
					if (ay < 0) ay = 0;
					break;
				case 'r':
					rx += dist;
					ax += dist;
					if (ax >= w) ax = w-1;
					break;
				case 'l':
					rx -= dist;
					ax -= dist;
					if (ax < 0) ax = 0;
					break;
			}
		}
		printf("Robot thinks %d %d\n", rx, ry);
		printf("Actually at %d %d\n", ax, ay);
		puts("");
	}

	return 0;
}

