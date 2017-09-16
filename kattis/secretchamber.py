from sys import stdin

m, n = map(int, stdin.readline().split(' ', 1))
tr = {}
for _ in xrange(m):
    l = stdin.readline().strip().split(' ', 1)
    if not l[0] in tr.keys():
        tr[l[0]] = []
    tr[l[0]].append(l[1])

# Find c2 in translation rules from c1.
def find_in_translations(c1, c2, seen):
    if c1 == c2:
        # shorten future searches here
        for c in seen:
            tr[c].append(c2)
        return True
    if c1 in seen: return False
    if not c1 in tr.keys(): return False
    for c in tr[c1]:
        if find_in_translations(c, c2, seen + [c1]): 
            return True
    return False

for _ in xrange(n):
    w1, w2 = map(list, map(str.strip, stdin.readline().split(' ', 1)))

    # Are they the same length?
    if len(w1) != len(w2):
        print 'no'
        continue

    # Check each letter in order.
    no = False
    for i in xrange(len(w1)):
        if not find_in_translations(w1[i], w2[i], []):
            no = True
            break
    if no: print 'no'
    else: print 'yes'

