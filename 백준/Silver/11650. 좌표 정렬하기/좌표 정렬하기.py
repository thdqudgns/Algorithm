import sys
input = sys.stdin.readline
N = int(input())
arr = []
for i in range(N):
    x, y = map(int, input().rstrip().split())
    arr.append([x, y])

arr = sorted(arr, key=lambda x: (x[0], x[1]))
[print(*arr[i]) for i in range(N)]