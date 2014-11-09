#include <iostream>
#include <stdlib.h>

using namespace std;

static int N, M;

typedef struct {
    string str;
    int score;
} DNA;

static int get_score(string s)
{
    int score = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = i + 1; j < N; j++)
        {
            if (s[i] > s[j])
            {
                score++;
#ifndef ONLINE_JUDGE
                cout << s[i] << " is larger than " << s[j] << ". Score is now " << score << endl;
#endif
            }
        }
    }

    return score;
}

static int cmp_score(const void *cmp1, const void *cmp2)
{
    int a = ((DNA *) cmp1)->score;
    int b = ((DNA *) cmp2)->score;
    return a - b;
}

int main()
{
    cin >> N >> M; // N = length of each string, M = number of strings

    DNA sort_me[M];

    string s;
    
    for(int i = 0; i < M; i++)
    {
        cin >> s;
        DNA dna = { s, get_score(s) };
        sort_me[i] = dna;
    }

    qsort(sort_me, M, sizeof(DNA), cmp_score);
    for (int i = 0; i < M; i++)
    {
        cout << sort_me[i].str << endl;
    }

    return 0;
}

