#include <algorithm>
#include <vector>
#include <cmath>
#include <cstdio>

using namespace std;

struct rect {
	int a, b, c, d;
	rect() {}
	rect(int _a, int _b, int _c, int _d) : a(_a), b(_b), c(_c), d(_d) {}
	bool operator == (rect o) const {
		return (a == o.a && b == o.b && c == o.c && d == o.d); }
};

// Sort by left side.
bool cmpLeft(rect r1, rect r2) {
	return (r1.a - r2.a);
}

// Sort by right side.
bool cmpRight(rect r1, rect r2) {
	return (r1.c - r2.c);
}

int main() {
	int n, a, b, c, d;
	rect r, rr, rl;
	vector<rect> rectL;
	vector<rect> rectR;
	vector<rect> curRects;
	while(1) {
		scanf("%d", &n);
		if (n == 0) break;
		scanf("%d %d %d %d", &a, &b, &c, &d);
		r = rect(a, b, c, d);
		rectR.push_back(r);
		rectL.push_back(r);
		sort(rectR.begin(), rectR.end(), cmpRight);
		sort(rectL.begin(), rectL.end(), cmpLeft);
		int ir = 0, il = 0;
		int newx, lastx = 0;
		int total_area = 0;
		int top, bottom;
		for(int i = 0; i < n*2; i++) {
			// rr is the next right side, rl is the next left side.
			if (ir == n) {
				curRects.push_back(rl);
				newx = rl.a;
				il++;
			} else if (il == n) {
				curRects.erase(remove(curRects.begin(), curRects.end(), rr), curRects.end());
				newx = rr.c;
				ir++;
			} else {
				rr = rectR[ir];
				rl = rectL[il];
				if (rl.a - rr.c >= 0) {
					curRects.erase(remove(curRects.begin(), curRects.end(), rr), curRects.end());
					newx = rr.c;
					ir++;
				} else {
					curRects.push_back(rl);
					newx = rl.a;
					il++;
				}
			}
			top = highest(curRects);
			bottom = lowest(curRects);
			total_area += (top - bottom + 1) * (newx - lastx);
			lastx = newx;
		}
		printf("%d\n", total_area);
	}
}

