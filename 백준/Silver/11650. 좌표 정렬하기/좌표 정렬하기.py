import sys
input = sys.stdin.readline
N = int(input())
arr = [[0 for _ in range(2)] for _ in range(N)]
# print(arr)
for i in range(N):
    arr[i] = list(map(int, input().rstrip().split()))

arr = sorted(arr, key=lambda x: (x[0],x[1]))
[print(*arr[i]) for i in range(N)]