#include <cstdio>
#include <cstring>
#include <string>
#include <iostream>
using namespace std;

char board[4][4];
bool used[4][4]; // Keeps track of used letters on board.

// Up to 300,000 words of length 8.
char dict[300000][9];

bool word_from_idx(const char *s, int i, int j, char (b)[4][4]) {
	used[i][j] = true;
	if (s[0] == 0) return true; // Got to end of string.
	if (i > 0 && !used[i-1][j] && b[i-1][j] == s[0]) {
		if(word_from_idx(s+1, i-1, j, b)) return true;
	}
	if (i > 0 && j > 0 && !used[i-1][j-1] && b[i-1][j-1] == s[0]) {
		if(word_from_idx(s+1, i-1, j-1, b)) return true;
	}
	if (i > 0 && j < 3 && !used[i-1][j+1] && b[i-1][j+1] == s[0]) {
		if(word_from_idx(s+1, i-1, j+1, b)) return true;
	}
	if (j > 0 && !used[i][j-1] && b[i][j-1] == s[0]) {
		if(word_from_idx(s+1, i, j-1, b)) return true;
	}
	if (j < 3 && !used[i][j+1] && b[i][j+1] == s[0]) {
		if(word_from_idx(s+1, i, j+1, b)) return true;
	}
	if (i < 3 && !used[i+1][j] && b[i+1][j] == s[0]) {
		if(word_from_idx(s+1, i+1, j, b)) return true;
	}
	if (i < 3 && j > 0 && !used[i+1][j-1] && b[i+1][j-1] == s[0]) {
		if(word_from_idx(s+1, i+1, j-1, b)) return true;
	}
	if (i < 3 && j < 3 && !used[i+1][j+1] && b[i+1][j+1] == s[0]) {
		if(word_from_idx(s+1, i+1, j+1, b)) return true;
	}
	used[i][j] = false;
	return false;
}

bool word_in_board(string s, char (b)[4][4]) {
	int i, j;
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			used[i][j] = false;
		}
	}
	for(i = 0; i < 4; i++) {
		for(j = 0; j < 4; j++) {
			if (b[i][j] == s[0]) {
				if (word_from_idx(s.c_str()+1, i, j, b)) return true;
			}
		}
	}
	return false;
}

int main() {
	int w, b, i, j, score, word_count;
	string s, longest_word;

	getline(cin, s);
	sscanf(s.c_str(), "%d\n", &w);
	for(i = 0; i < w; i++) {
		getline(cin, s);
		strncpy(dict[i], s.c_str(), 9);
	}
	getline(cin, s); // Empty line.
	getline(cin, s); // Number of boards.
	sscanf(s.c_str(), "%d", &b);
	for(i = 0; i < b; i++) {
		for (j = 0; j < 4; j++) {
			getline(cin, s);
			sscanf(s.c_str(), "%c%c%c%c\n", &board[j][0], &board[j][1], &board[j][2], &board[j][3]);
		}
		getline(cin, s);

		score = 0, longest_word = "", word_count = 0;
		for(j = 0; j < w; j++) {
			s = string(dict[j]);
			if (word_in_board(s, board)) {
				word_count += 1;
				switch(s.length()) {
					case 3:
					case 4:
						score += 1; break;
					case 5:
						score += 2; break;
					case 6:
						score += 3; break;
					case 7:
						score += 5; break;
					case 8:
						score += 11; break;
				}
				if (s.length() > longest_word.length()) {
					longest_word = s;
				} else if (s.length() == longest_word.length() &&
						s < longest_word) {
					longest_word = s;
				}
			}
		}
		printf("%d %s %d\n", score, longest_word.c_str(), word_count);
	}

	return 0;
}

