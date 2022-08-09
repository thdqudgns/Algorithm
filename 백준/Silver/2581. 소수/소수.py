M = int(input())
N = int(input())
a = []
sum = 0
for i in range(M, N+1):
    num = 1
    cnt = 0
    while num <= i//2:   # 1 ~ 저장된 수
        if i % num == 0:
            cnt += 1
        if num < i and cnt > 1:
            break
        if num >= i//2 and cnt == 1:
            a.append(i)
            sum += i
        num += 1
        
if len(a) == 0:
    print(-1)
else:
    print(sum)
    print(a[0])