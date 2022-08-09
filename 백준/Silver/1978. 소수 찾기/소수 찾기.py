import sys
n = int(input())
a = list(map(int, sys.stdin.readline().strip().split()))
res = 0

for i in range(n):
    num = 1
    cnt = 0
    while num <= a[i]:   # 1 ~ 저장된 수
        if a[i] % num == 0:
            cnt += 1
        num += 1
    if cnt == 2:
       res += 1

print(res)