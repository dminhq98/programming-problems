#include <stdio.h>

int main(void) {
	unsigned int m, i, ww, wh, rh, rw;
	int w, h;

	for(;;) {
		scanf("%u", &m);
		if (m == 0) break;
		ww = 0; wh = 0; // total window width/height
		rw = 0; rh = 0; // row width/height
		for(;;) {
			scanf("%d %d", &w, &h);
			if (w == -1 && h == -1) {
				ww = (rw > ww) ? rw : ww; // window width is max(ww, rw)
				wh += rh; // row is over; add its height to the total
				break;
			}
			if (rw + w > m) {
				ww = (rw > ww) ? rw : ww; // window width is max(ww, rw)
				wh += rh; // row is over; add its height to the total
				
				rw = w; // start a new row with the current input
				rh = h;
			} else {
				rh = (h > rh) ? h : rh; // row height is that of tallest element
				rw += w;
			}
		}
		printf("%u x %u\n", ww, wh);
	}
}
			
