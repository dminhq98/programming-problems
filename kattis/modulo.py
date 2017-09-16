from sys import stdin

nums = []
for i in xrange(42):
    nums.append(0)

for line in stdin:
    i = int(line)
    nums[i%42] = 1

sum = 0
for i in xrange(42):
    sum += nums[i]

print sum
