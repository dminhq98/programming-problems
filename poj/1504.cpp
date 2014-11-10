#include <iostream>

#include <stdio.h>
#include <stdlib.h>

using namespace std;

int reverse(int a)
{
    char buf[16];
    char out[16];

    int nwritten = sprintf(buf, "%d", a);

#ifndef ONLINE_JUDGE
    printf("reversing %s\n", buf);
#endif
    for(int i = 0; i < nwritten; i++)
    {
        out[i] = buf[nwritten-i-1];
    }
    out[nwritten] = '\0';
#ifndef ONLINE_JUDGE
    printf("now %s\n", out);
#endif

    return atoi(out);
}

int main()
{
    int N, a, b, c;

    cin >> N;

    for(int i = 0; i < N; i++)
    {
        cin >> a >> b;

        a = reverse(a);
        b = reverse(b);

        c = a + b;

        printf("%d\n", reverse(c));
    }

    return 0;
}

