import sys

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr_sum = [0]

sum = 0
for i in range(N):
    sum += arr[i]
    arr_sum.append(sum)

for _ in range(M):
    s, e = map(int, sys.stdin.readline().split())
    print(arr_sum[e] - arr_sum[s-1])
