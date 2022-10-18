# https://velog.io/@yoonkeem/BOJ-2559%EB%B2%88-%EC%88%98%EC%97%B4-%ED%8C%8C%EC%9D%B4%EC%8D%AC
import sys

N, K = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
arr_sum = []
part_sum = sum(arr[:K])
max = part_sum
for i in range(N-K):
    part_sum = part_sum - arr[i] + arr[i+K]
    if part_sum > max:
        max = part_sum
print(max)

