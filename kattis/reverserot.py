from sys import stdin

alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_."

for line in stdin:
    l = line.strip().split(" ")
    N = int(l[0])
    if N == 0: break
    S = l[1][::-1] # Reverse S.
    T = ""
    for i in xrange(len(S)):
        if S[i] >= 'A' and S[i] <= 'Z':
            idx = ord(S[i]) - ord('A') 
        elif S[i] == '_':
            idx = 26
        else: # S[i] == '.'
            idx = 27
        idx = (idx + N) % len(alphabet)
        T = T + alphabet[idx]
    print T

