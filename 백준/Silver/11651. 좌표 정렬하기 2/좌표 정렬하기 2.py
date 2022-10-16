import sys
N = int(sys.stdin.readline())
arr = []
for i in range(N):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    arr.append([x, y])
arr.sort(key=lambda x:(x[1],x[0]))
[print(*arr[i]) for i in range(N)]