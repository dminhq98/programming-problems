from sys import stdin

ops = '+-*/'
nums = {}

for op1 in ops:
    for op2 in ops:
        for op3 in ops:
            val = eval("4 {0} 4 {1} 4 {2} 4".format(op1, op2, op3))
            nums[val] = (op1, op2, op3)

m = int(stdin.readline())

for _ in xrange(m):
    n = int(stdin.readline())
    if n in nums:
        ans = nums[n]
        print "4 {0} 4 {1} 4 {2} 4 = {3}".format(ans[0], ans[1], ans[2], n)
    else:
        print "no solution"

