#include <stdio.h>
#include <float.h>
#include <math.h>

typedef struct {
    double x;
    double y;
} Point;

/* y = mx + b */
typedef struct {
    double b;
    double m;
} Line;

Line convert_to_line(Point point, int slope)
{
    Line l;

    l.m = slope;
    l.b = point.y - l.m * point.x;

    return l;
}

int main()
{
    Point A, B, C;
    double perp_slope;
    Point midpoint;
    Line ABbi, BCbi;
    double x, y, radius; /* X, Y of circle centre */

    while(scanf("%lf %lf %lf %lf %lf %lf", 
                &(A.x), &(A.y), &(B.x), &(B.y), &(C.x), &(C.y)) != EOF)
    {
        /* Find perpendicular bisectors of two lines of triangle ABC. */
        /* slope = rise / run, so perpendicular slope = -run / rise */
        if (B.y - A.y == 0)
        {
            perp_slope = DBL_MAX;
        }
        else
        {
            perp_slope = -(B.x - A.x) / (B.y - A.y);
        }
        midpoint.x = A.x + (B.x - A.x)/2;
        midpoint.y = A.y + (B.y - A.y)/2;
#ifndef ONLINE_JUDGE
        printf("Found line AB with midpoint (%f, %f), "
                "perpendicular slope %f.\n", 
                midpoint.x, midpoint.y, perp_slope);
#endif
        ABbi = convert_to_line(midpoint, perp_slope);
#ifndef ONLINE_JUDGE
        printf("Line ABbi = (y = (%f)x + (%f))\n", ABbi.m, ABbi.b);
#endif

        if (C.y - B.y == 0)
        {
            perp_slope = DBL_MAX;
        }
        else
        {
            perp_slope = -(C.x - B.x) / (C.y - B.y);
        }
        midpoint.x = B.x + (C.x - B.x)/2;
        midpoint.y = B.y + (C.y - B.y)/2;
#ifndef ONLINE_JUDGE
        printf("Found line BC with midpoint (%f, %f), "
                "perpendicular slope %f.\n", 
                midpoint.x, midpoint.y, perp_slope);
#endif
        BCbi = convert_to_line(midpoint, perp_slope);
#ifndef ONLINE_JUDGE
        printf("Line BCbi = (y = (%f)x + (%f))\n", BCbi.m, BCbi.b);
#endif
        /* Where those bisectors intersect is the centre of the circle. */
        /* y = m1*x + b1 = m2*x + b2 => x = (b2 - b1) / (m1 - m2) */
        /* We don't check if (m1 - m2) is 0, because this would mean the
         * lines never intersect (ie. they are parallel). We are guaranteed
         * to be given valid input, so this will never be the case. */
        x = (BCbi.b - ABbi.b) / (ABbi.m - BCbi.m);
        y = ABbi.m * x + ABbi.b;

#ifndef ONLINE_JUDGE
        printf("Circle midpoint: (%f, %f)\n", x, y);
#endif

        /* radius = distance from centre to any of A, B, or C,
         * ie. sqrt((A.x - x)^2 + (A.y - y)^2) */
        radius = sqrt((A.x-x)*(A.x-x) + (A.y-y)*(A.y-y));
        printf("%f\n", radius);
    }

    return 0;
}

