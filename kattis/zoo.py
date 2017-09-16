from sys import stdin

n = int(stdin.readline())
N = 0
while n != 0:
    N += 1
    a = {}
    for i in xrange(n):
        k = stdin.readline().split()[-1].lower()
        if not k in a.keys(): a[k] = 1
        else: a[k] += 1
    print("List {}:".format(N))
    for k in sorted(a.keys()): print("{} | {}".format(k, a[k]))
    n = int(stdin.readline())

