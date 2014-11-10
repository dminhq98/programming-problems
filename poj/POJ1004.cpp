#include <iostream>

using namespace std;

int main()
{
    double in;
    double sum = 0.0;
    for (int i = 0; i < 12; i++)
    {
        cin >> in;
        sum += in;
    }
    cout << "$" << sum / 12.0 << endl;

    return 0;
}

