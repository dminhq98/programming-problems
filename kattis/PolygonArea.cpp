#include <vector>
#include <cstdio>
#include <cmath>
using namespace std;

#define EPS 1e-9
#define PI acos(-1.0)

struct point {
	double x, y;
	point() { x = y = 0.0; }
	point(double _x, double _y) : x(_x), y(_y) {}
	bool operator == (point other) const {
		return (fabs(x - other.x) < EPS && (fabs(y - other.y) < EPS)); 
	}
};

// The area is half the determinant. Magic, I say!
// Positive if given in CCW order, negative if CW.
double area(const vector<point> &P) {
	double result = 0.0;
	for (int i = 0; i < (int)P.size()-1; i++) {
		result += (P[i].x * P[i+1].y - P[i].y * P[i+1].x);
	}
	return result / 2.0;
}

int main() {
	vector<point> P;

	for(;;) {
		P.clear();
		int m;
		scanf("%d", &m);
		if (m == 0) break;

		for(int j = 0; j < m; j++) {
			int x, y;
			scanf("%d %d", &x, &y);
			P.push_back(point(x, y));
		}
		P.push_back(P[0]); // loop back

		double a = area(P);
		printf("%s %.1lf\n", ((a > 0) ? "CCW" : "CW"), fabs(a));
	}
}

