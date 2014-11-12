#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
    unsigned int speed;
    int departure_time;
} Rider;

int main()
{
    unsigned int N,
                 i;
    double min,
           arrival_time;
    Rider *riders;
    
    while (scanf("%u", &N) != EOF)
    {
        if (N == 0) continue;
        
        min = UINT_MAX;
        riders = (Rider *)malloc(N * sizeof(Rider));

        for(i = 0; i < N; i++)
        {
            scanf("%u   %d", &(riders[i].speed), 
                    &(riders[i].departure_time));
            arrival_time = riders[i].departure_time + (4.5 / (double)riders[i].speed)*(60 * 60);
            if (arrival_time < min && riders[i].departure_time >= 0)
            {
                min = arrival_time;
            }
        }
        printf("%d\n", (int)min);
    }

    return 0;
}
