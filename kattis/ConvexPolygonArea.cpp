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
double area(const vector<point> &P) {
	double result = 0.0;
	for (int i = 0; i < (int)P.size()-1; i++) {
		result += (P[i].x * P[i+1].y - P[i].y * P[i+1].x);
	}
	return fabs(result) / 2.0;
}

int main() {
	vector<point> P;

	int n;
	scanf("%d", &n);

	for(int i = 0; i < n; i++) {
		P.clear();
		int m;
		scanf("%d", &m);

		for(int j = 0; j < m; j++) {
			int x, y;
			scanf("%d %d", &x, &y);
			P.push_back(point(x, y));
		}
		P.push_back(P[0]); // loop back

		printf("%lf\n", area(P));
	}
}

