n = input()
aa = int(n)
res, sum, cnt = 0, 0, 0

if aa < 10:
    xx = 0
    yy = int(n[0])
else:
    xx = int(n[0])
    yy = int(n[1])

while res != aa:
    sum = xx + yy
    cnt += 1
    xx = yy
    yy = sum%10
    res = xx * 10 + yy

if cnt == 0:
    print(1)
else:
    print(cnt)