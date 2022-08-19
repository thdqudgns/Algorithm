import sys
n = int(sys.stdin.readline())
for i in range(n):
    a = list(map(int, sys.stdin.readline().strip().split()))
    a.sort()
    print(a[7])