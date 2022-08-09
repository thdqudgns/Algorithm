import sys
N = int(sys.stdin.readline())
for _ in range(N):
    a = []
    n = int(sys.stdin.readline())
    for i in range(n):
        a.append(sys.stdin.readline().strip().split())
        a[i][0] = int(a[i][0])
    a.sort()
    print(a[n-1][1])