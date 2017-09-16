from sys import stdin

m, n = map(int, stdin.readline().split(' ', 1))
tr = {}
for _ in xrange(m):
    l = stdin.readline().strip().split()
    if l[0] in tr.keys():
        tr[l[0]].append(l[1])
    else: 
        tr[l[0]] = [l[1]]

# Find and break any cycles in translation.
for k in tr.keys():
    tortoise = k
    hare = k
    while hare in tr.keys():
        if tr[hare] == tortoise:
            hare.remove(tr[hare])
        hare = tr[hare]
        tortoise = tr[tortoise]
        if not hare in tr.keys(): break
        if tr[hare] == tortoise:
            hare.remove(tr[hare])
        hare = tr[hare]
            

# Returns a list of all possible translations of the word w.
def enumerate_translations(w):
    l = []
    did_recurse = False
    for i in xrange(len(w)-1):
        while w[i] in tr.keys():
            subs = tr[w[i]]
            for c in subs:
                w[i] = c
                l = l + enumerate_translations(w)
                did_recurse = True
    i = len(w)-1
    if w[i] in tr.keys():
        while w[i] in tr.keys():
            subs = tr[w[i]]
            for c in subs:
                w[i] = c
                l.append(''.join(w))
    elif not did_recurse:
        l.append(''.join(w))
    # else: don't append something that was already appended in a recursion.
    return l

for _ in xrange(n):
    w1, w2 = map(list, map(str.strip, stdin.readline().split(' ', 1)))
    if len(w1) != len(w2):
        print 'no'
        continue
    l1 = enumerate_translations(w1)
    l2 = enumerate_translations(w2)
    if True in [(w in l2) for w in l1]:
        print 'yes'
    else:
        print 'no'


