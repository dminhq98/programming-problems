from math import sqrt, asin, pi
from sys import stdin

for line in stdin:
    r, x, y = map(float, line.split())

    # from the Pythagorean Theorem: 
    # Chord length = 2*sqrt(r^2 - d^2)
    # where: r is the radius of the circle, 
    #        d is the perpendicular distance from the chord to the circle center
    # d is also called the "apothem".
    d = abs(sqrt(x*x + y*y))
    if d >= r:
        print "miss"
        continue
    l = 2 * sqrt(r*r - d*d)

    # We can also get the chord length from the angle c subtended by the chord.
    # l = 2r*sin(c/2)
    # We will use this instead to get c. We'll need c in a moment.
    c = 2 * asin(l/(2*r))

    # PI*r^2 is the area of the circle. 
    # If we instead use half the angle (in radians) formed by the chord as PI,
    #     (i.e. (c/2)*r^2)
    # then this gives the circular sector (pie-slice) spanned by the chord.
    # We are only interested in the "circular segment" of this sector, and not
    # the triangular bit closer to the origin.
    sector_area = (c/2)*(r*r)

    # We can get the area of the triangular segment: 
    # Its height is d, and its base length is l.
    triangle_area = d * l / 2

    # So now our circular segment's area should be:
    segment_area = sector_area - triangle_area

    print (pi * r*r) - segment_area, segment_area
