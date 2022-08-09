import sys
a = []
for _ in range(9):
    a.append(int(sys.stdin.readline()))
print(max(a))
print(a.index(max(a))+1)