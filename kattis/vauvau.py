from sys import stdin

A, B, C, D = map(int, stdin.readline().split(' '))
P, M, G = map(int, stdin.readline().split(' '))

abperiod = A+B
cdperiod = C+D

for i in (P, M, G):
    abagg = (((i-1) % abperiod) < A)
    cdagg = (((i-1) % cdperiod) < C)
    if abagg and cdagg: print "both"
    elif abagg or cdagg: print "one"
    else: print "none"
    
