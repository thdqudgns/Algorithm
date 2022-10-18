# https://velog.io/@yoonkeem/BOJ-2559%EB%B2%88-%EC%88%98%EC%97%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC
import sys

N, M = map(int, sys.stdin.readline().split())
arr = [[0 for _ in range(N+1)] for _ in range(N+1)]
for i in range(1, N+1):
    arr[i] = [0] + list(map(int, sys.stdin.readline().split()))
    for j in range(1, N+1):
        arr[i][j] = arr[i][j] + arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1]

# print(arr)

for i in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    res = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1]
    print(res)