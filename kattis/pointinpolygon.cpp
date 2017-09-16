#include <algorithm>
#include <cstdio>
#include <cmath>
#include <vector>
using namespace std;

#define EPS 1e-6
#define PI acos(-1.0)

struct point { double x, y;   // only used if more precision is needed
    point() { x = y = 0.0; }                      // default constructor
    point(double _x, double _y) : x(_x), y(_y) {}        // user-defined
    bool operator == (point other) const {
        return (fabs(x - other.x) < EPS && (fabs(y - other.y) < EPS)); } };

struct vec { double x, y;  // name: `vec' is different from STL vector
    vec(double _x, double _y) : x(_x), y(_y) {} };

vec toVec(point a, point b) {       // convert 2 points to vector a->b
    return vec(b.x - a.x, b.y - a.y); }

double dot(vec a, vec b) { return (a.x * b.x + a.y * b.y); }

double norm_sq(vec v) { return v.x * v.x + v.y * v.y; }

double angle(point a, point o, point b) {  // returns angle aob in rad
    vec oa = toVec(o, a), ob = toVec(o, b);
    return acos(dot(oa, ob) / sqrt(norm_sq(oa) * norm_sq(ob))); }

double cross(vec a, vec b) { return a.x * b.y - a.y * b.x; }

// note: to accept collinear points, we have to change the `> 0'
// returns true if point r is on the left side of line pq
bool ccw(point p, point q, point r) {
    return cross(toVec(p, q), toVec(p, r)) > 0; }

// returns true if point r is on the same line as the line pq
bool collinear(point p, point q, point r) {
    return fabs(cross(toVec(p, q), toVec(p, r))) < EPS; }

// returns true if point p is in either convex/concave polygon P
bool inPolygon(point pt, const vector<point> &P) {
    if ((int)P.size() == 0) return false;
    double sum = 0;    // assume the first vertex is equal to the last vertex
    for (int i = 0; i < (int)P.size()-1; i++) {
        if (ccw(pt, P[i], P[i+1]))
            sum += angle(P[i], pt, P[i+1]);                   // left turn/ccw
        else sum -= angle(P[i], pt, P[i+1]); }                 // right turn/cw
    return fabs(fabs(sum) - 2*PI) < EPS; }

int main() {
    vector<point> P;
    point p, q, r;
    int i, j, n, m, x, y;
    while(1) {
        P.clear();
        scanf("%d", &n);
        if (n == 0) break;
        
        for(i = 0; i < n; i++) {
            scanf("%d %d", &x, &y);
            P.push_back(point(x, y));
        }
        P.push_back(P[0]);
        
        scanf("%d", &m);
        for(i = 0; i < m; i++) {
            scanf("%d %d", &x, &y);
            p = point(x, y);
            
            if (inPolygon(p, P)) {
                puts("in");
                continue;
            }
            // else: point is either outside polygon, or on a line segment.
            bool on_line = false;
            for(j = 0; j < m-1; j++) {
                q = P[j], r = P[j+1];
                if (collinear(q, r, p)) {
                    // p is colinear to qr, but is it ON that line?
                    if (((p.x <= q.x && p.x >= r.x) || (p.x >= q.x && p.x <= r.x)) &&
                        ((p.y <= q.y && p.y >= r.y) || (p.y >= q.y && p.y <= r.y))) {
                        on_line = true;
                        break;
                    }
                }
            }
            if (on_line) puts("on");
            else puts("out");
        }
    }
}
