from sys import stdin

while True:
    tokens = stdin.readline().split()

    n, m = int(tokens[0]), int(tokens[1])

    if n == 0 and m == 0:
        break

    bestA, bestB = None, None
    for i in xrange(n):
        tokens = stdin.readline().split()
        a, b = float(tokens[0]), float(tokens[1])
        if a > m:
            continue
        if bestA is None or b/a < bestB/bestA or (b/a == bestB/bestA and a > bestA):
            bestA, bestB = a, b

    if bestA is None:
        print "No suitable tickets offered"
    else:
        print "Buy {0} tickets for ${1}".format(int(bestA), int(bestB))

