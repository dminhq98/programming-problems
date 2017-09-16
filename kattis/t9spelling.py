from sys import stdin

letters = {
        "abc": "2",
        "def": "3",
        "ghi": "4",
        "jkl": "5",
        "mno": "6",
        "pqrs": "7",
        "tuv": "8",
        "wxyz": "9",
        " ": "0"
}

N = int(stdin.readline())

for i in xrange(N):
    s = ""
    prev = -1
    line = stdin.readline()
    for c in line:
        for k in letters.keys():
            if c in k:
                if prev == letters[k]: s = s + " "
                for j in xrange(k.index(c)+1):
                    s = s + letters[k]
                prev = letters[k]
                break
    print "Case #{0}: {1}".format(i+1, s)


