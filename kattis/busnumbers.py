from sys import stdin

N = int(stdin.readline())

l = [int(s) for s in stdin.readline().split()]
l.sort()

run = 0
for i in xrange(len(l) - 1):
    if l[i] == (l[i+1] - 1):
        run += 1
    elif run > 1:
        print "{0}-{1}".format(l[i-run], l[i]),
        run = 0
    elif run == 1:
        print "{0} {1}".format(l[i-1], l[i]),
        run = 0
    else: # run == 0
        print "{0}".format(l[i]),

if run != 0:
    i = len(l) - 1
    if run == 1:
        print "{0} {1}".format(l[i-1], l[i])
    else: 
        print "{0}-{1}".format(l[i-run], l[i])
else:
    print l[len(l)-1]

