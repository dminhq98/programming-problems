#include <cstdio>
#include <cstring>
#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

vector<int> suspicious[100000];
char color[100000];

bool dfs_coloring(int idx, char c) {
	bool success = true;
	for (vector<int>::iterator it = suspicious[idx].begin(); it != suspicious[idx].end(); ++it) {
		if (color[*it] == '\0') {
			color[*it] = c;
			if (!dfs_coloring(*it, (c == 'J' ? 'W' : 'J'))) {
				success = false;
				break;
			}
		} else if (color[*it] != c) return false;
	}
	return success;
}

int main() {
	int N, M, i, a, b;
	map<string, int> idx;
	char item1[21];
	char item2[21];
	string s;
	getline(cin, s);
	sscanf(s.c_str(), "%d\n", &N);
	for(i = 0; i < N; i++) {
		getline(cin, s);
		idx[s] = i;
	}
	getline(cin, s);
	sscanf(s.c_str(), "%d\n", &M);
	for(i = 0; i < M; i++) {
		getline(cin, s);
		sscanf(s.c_str(), "%s %s\n", item1, item2);
		string i1 = string(item1), 
			   i2 = string(item2);
		a = idx[i1];
		b = idx[i2];
		suspicious[a].push_back(b);
		suspicious[b].push_back(a);
	}
	bool possible = true;
	for(i = 0; i < N; i++) {
		if (color[i] == '\0' && !dfs_coloring(i, 'J')) {
			possible = false;
			break;
		}
	}
	if (!possible) puts("impossible");
	else {
		string Jesse = "";
		string Walter = "";
		for(map<string, int>::iterator it = idx.begin(); it != idx.end(); it++) {
			if (color[it->second] == 'W') Walter += it->first + " ";
			else Jesse += it->first + " ";
		}
		cout << Jesse << "\n" << Walter << "\n";
	}

	return 0;
}
