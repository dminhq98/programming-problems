#include <stdio.h>
#include <math.h>

int main()
{
    int N,
        petrol,
        centre,
        dist,
        scenario,
        i, j, k;

    scanf("%d", &N);

    for(scenario = 1; scenario <= N; scenario++)
    {
        printf("Scenario #%d:\n", scenario);

        scanf("%d", &petrol);

        centre = petrol + 1;

        for(i = 1; i <= petrol * 2 + 1; i++)
        {
            printf("slice #%d:\n", i);

            dist = abs(centre - i);
            for(j = 1; j <= petrol * 2 + 1; j++)
            {
                dist += abs(centre - j);
                for(k = 1; k <= petrol * 2 + 1; k++)
                {
                    dist += abs(centre - k);
                    if (dist > petrol)
                        printf(".");
                    else printf("%d", dist);
                    dist -= abs(centre - k);
                }
                printf("\n");
                dist -= abs(centre - j);
            }
        }
        printf("\n");
    }

    return 0;
}

