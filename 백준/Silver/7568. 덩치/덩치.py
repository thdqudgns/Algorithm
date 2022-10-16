import sys
N = int(sys.stdin.readline())
arr = []
rank = 0
for i in range(N):
    x, y = map(int, sys.stdin.readline().rstrip().split())
    arr.append([x, y, rank])

for i in range(N):
    cnt = 1
    for j in range(N):
        if arr[i][0] < arr[j][0] and arr[i][1] < arr[j][1]:
            cnt += 1
    arr[i][2] = cnt
[print(arr[i][2], end=' ') for i in range(N)]