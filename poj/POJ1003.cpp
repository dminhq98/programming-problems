#include <iostream>

using namespace std;

int main()
{
    int i;
    float overhang[512]; // overhang with i cards
    overhang[0] = 0.0;
    for(i = 1; i < 512; i++)
    {
        overhang[i] = overhang[i-1] + 1.0 / (float) (i + 1);
        if (overhang[i] > 5.20)
        {
#ifndef ONLINE_JUDGE
            cout << "found 5.20 with " << i << " cards." << endl;
#endif
            break;
        }
    }

    float input;
    while(cin >> input)
    {
        if (input == 0.00)
        {
            break;
        }
        
        for(i = 1; overhang[i] < input; i++);
        cout << i << " card(s)" << endl;
    }

    return 0;
}

