from sys import stdin

t = {
    'a': '@',
    'b': '8',
    'c': '(',
    'd': '|)',
    'e': '3',
    'f': '#',
    'g': '6',
    'h': '[-]',
    'i': '|',
    'j': '_|',
    'k': '|<',
    'l': '1',
    'm': '[]\\/[]',
    'n': '[]\\[]',
    'o': '0',
    'p': '|D',
    'q': '(,)',
    'r': '|Z',
    's': '$',
    't': "']['",
    'u': '|_|',
    'v': '\\/',
    'w': r'\/\/',
    'x': '}{',
    'y': '`/',
    'z': '2'
}

l = stdin.readline().lower()
o = ""
for c in l:
    if c in t.keys():
        o = o + t[c]
    else:
        o = o + c
print o

