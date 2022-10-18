# https://velog.io/@ready2start/Python-%EB%B0%B1%EC%A4%80-11660-%EA%B5%AC%EA%B0%84-%ED%95%A9-%EA%B5%AC%ED%95%98%EA%B8%B0-5
# https://castlerain.tistory.com/m/100
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