from sys import stdin
from math import sin

line = stdin.readline().split(" ")

h = int(line[0])
v = float(line[1])
v = (v / 180) * 3.1415926
l = h/sin(v)
if abs(int(l) - l) > 10e-5: l = l+1
print int((l))
