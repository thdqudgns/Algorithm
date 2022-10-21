import sys
a, b, c, d, e = map(int, sys.stdin.readline().split())

cnt = min(a, b, c, d, e)

while True:
    res = 0
    if cnt % a == 0:
        res += 1
    if cnt % b == 0:
        res += 1
    if cnt % c == 0:
        res += 1
    if cnt % d == 0:
        res += 1
    if cnt % e == 0:
        res += 1
    if res >= 3:
        break
    cnt += 1

print(cnt)