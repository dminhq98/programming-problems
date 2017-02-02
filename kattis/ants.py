from sys import stdin

cases = int(stdin.readline())

for _ in xrange(cases):
    line = stdin.readline().split()
    l, n = float(line[0]), int(line[1])

    ants = []
    while len(ants) < n:
        line = stdin.readline().split()
        for ant in line:
            ants.append(int(ant))

    best, worst = 0, 0
    for ant in ants:
        if ant <= l/2 and ant > best:
            best = ant
        elif ant > l/2 and l - ant > best:
            best = l - ant
        if ant > worst:
            worst = ant
        if l - ant > worst:
            worst = l - ant

    print int(best), int(worst)
