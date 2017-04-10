from sys import stdin

sum = 0
N = int(stdin.readline())
for i in xrange(N):
    P = stdin.readline().strip()
    sum += int(P[:-1])**int(P[-1])
print sum
