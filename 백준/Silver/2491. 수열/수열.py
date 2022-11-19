import sys
n = int(input())
a = list(map(int, sys.stdin.readline().rstrip().split()))
res = 1
cnt = 1
for i in range(1, n):
    if a[i-1] <= a[i]:
        cnt += 1
    else:
        cnt = 1
    if res < cnt:
        res = cnt
cnt = 1
for i in range(1, n):
    if a[i-1] >= a[i]:
        cnt += 1
    else:
        cnt = 1
    if res < cnt:
        res = cnt


print(res)