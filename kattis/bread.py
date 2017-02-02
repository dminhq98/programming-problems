from sys import stdin

def rot_3r(list, left_idx):
    a = list[left_idx]
    b = list[left_idx+1]
    c = list[left_idx+2]
    list[left_idx] = c
    list[left_idx+1] = a
    list[left_idx+2] = b

N = int(stdin.readline())
l = map(int, stdin.readline().split())
sorted = map(int, stdin.readline().split())

for i, e in enumerate(sorted):
    if i + 3 == N:
        # Skip the last triple.
        break
    e_idx = -1
    for j in xrange(len(l)):
        if l[j] == e:
            e_idx = j
            break
    distance_to_go = e_idx - i
    while distance_to_go > 1:
        rot_3r(l, e_idx-2)
        distance_to_go -= 2
        e_idx -= 2
    if distance_to_go == 1:
        rot_3r(l, e_idx-1)
        rot_3r(l, e_idx-2)

# Check if the last 3 terms are in the right order, 
# or some rotation of the right order.
possible = False
for _ in xrange(3):
    if l[-3] == sorted[-3] and l[-2] == sorted[-2] and l[-1] == sorted[-1]:
        possible = True
        break
    else:
        rot_3r(l, -3)

print possible and "Possible" or "Impossible"

