#include <stdio.h>

int main()
{
    char c;
    int letters[26] = { 0 };
    int max = 0,
        i,
        j;

    while ((c = getchar()) != EOF)
    {
        if (!(c - 'A' >= 0 && c - 'A' < 26)) continue;
        letters[(c - 'A')] += 1;
    }

    for (i = 0; i < 26; i++)
    {
        if (letters[i] > max)
        {
            max = letters[i];
        }
    }

    for (i = max; i > 0; i--)
    {
        for (j = 0; j < 26; j++)
        {
            if (letters[j] >= i)
            {
                printf("* ");
            }
            else
            {
                printf("  ");
            }
        }
        printf("\n");
    }

    printf("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z\n");

    return 0;
}

