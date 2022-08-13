import sys
b = []
for i in range(5):
    a = list(map(int, sys.stdin.readline().strip().split()))
    b.append(sum(a))
print(b.index(max(b))+1)
print(max(b))