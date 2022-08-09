import sys
N = int(sys.stdin.readline())
a = []
for _ in range(N):
    a.append(int(sys.stdin.readline()))

print(1+sum(a)-N)