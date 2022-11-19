n = int(input())
ans = []
max = 1
for i in range(n, -1, -1):
    res = [n]
    tmp = i
    cnt = 1
    while tmp >= 0:
        res.append(tmp)
        tmp = res[-2]-tmp
        cnt += 1
    if cnt>max:
        max = cnt
        ans = res
print(max)
print(*ans)