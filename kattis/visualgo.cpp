#include <cstdio>
#include <queue>
#include <vector>

typedef struct {
	int v;
	int w;
} edge;

typedef struct {
	int idx;
	std::vector<edge> neighbours;
} vertex;

vertex V[10000];
int dist[10000];

struct cmp {
	bool operator()(const vertex& u, const vertex& v) {
		return dist[u.idx] < dist[v.idx];
	}
};

/* Dijkstra's shortest path algorithm, modified to 
 * count the number of shortest paths from s to t. */
int dij(int s, int t) {
	int count = 0;
	std::priority_queue<vertex, std::vector<vertex>, cmp> q;
	q.push(V[s]);
	while(!q.empty()) {
		vertex u = q.top(); q.pop();
		for (edge e : V[u.idx].neighbours) {
			// less than OR EQUAL: important for getting
			// a correct count of all paths.
			if (dist[u.idx] + e.w <= dist[e.v]) {
				dist[e.v] = dist[u.idx] + e.w;
				if (e.v == t) count++;
				else q.push(V[e.v]);
			} else if (e.v == t && count > 0) goto ret;
		}
	}
ret:
	return count;
}

int main(void) {
	int Vcnt, Ecnt, i, u, v, w, s, t, npaths;
	scanf("%d %d", &Vcnt, &Ecnt);
	for(i = 0; i < Ecnt; i++) {
		scanf("%d %d %d", &u, &v, &w);
		edge e; e.v = v; e.w = w;
		V[u].neighbours.push_back(e);
	}
	// Unknown (infinite) distance to all vertices.
	for(i = 0; i < Vcnt; i++) {
		dist[i] = 0x7FFFFFFF;
	}
	scanf("%d %d", &s, &t);
	dist[s] = 0;
	printf("%d\n", dij(s, t));
}
