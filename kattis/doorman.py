from sys import stdin

X = int(stdin.readline())

d = 0
n = 0
l = stdin.readline()
lineup = []
for c in l:
    # Replace every M with a 1, W with a -1
    addme = (c == 'M' and 1) or (c == 'W' and -1) or None
    if addme: lineup.append(addme)

while(len(lineup)):
    if abs(d + lineup[0]) <= X:
        d += lineup[0]
        lineup = lineup[1:]
        n += 1
    elif len(lineup) > 1 and abs(d + lineup[1]) <= X:
        d += lineup[1]
        lineup = lineup[0:1] + lineup[2:]
        n += 1
    else:
        break

print n
