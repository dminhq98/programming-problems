#include <iostream>

using namespace std;

int main()
{
    int N;

    cin >> N;

    int ways = 1; // 1 way to start: N itself

    for (int i = 1; i <= N / 2; i++)
    {
        int sum = i;
        for (int j = i + 1; sum < N; j++)
        {
            sum += j;
            if (sum == N)
            {
                ways += 1;
            }
        }
    }

    cout << ways << endl;

    return 0;
}

