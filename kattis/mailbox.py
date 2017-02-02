from sys import stdin

def sum_of_0_to(n):
    if n < 0: return 0
    return (n * (n+1) / 2)

cache = {}

def G(k, i, j):
    if (i, j, k) in cache:
        return cache[(i, j, k)]

    if i > j: return 0
    if i == j: return i
    if k == 1:
        return sum_of_0_to(j) - sum_of_0_to(i-1)

    minimum = -1
    for n in range(i, j+1):
        x = n + max(G(k-1, i, n-1), G(k, n+1, j))
        # if i == 1: print "G{4}({0}, {1}, {2}) = {3}".format(k, i, j, x, n)
        if minimum == -1 or x < minimum:
            minimum = x

    # cache[(i, j, k)] = minimum
    return minimum

N = int(stdin.readline())

for _ in range(N):
    k, m = map(int, stdin.readline().split())
    
    print G(k, 1, m)

