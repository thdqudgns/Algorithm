import sys
N, K = map(int, sys.stdin.readline().strip().split())
a = []
for i in range(1, N+1):
    if N%i == 0:
        a.append(i)
if len(a) >= K:
    print(a[K-1])
else:
    print(0)