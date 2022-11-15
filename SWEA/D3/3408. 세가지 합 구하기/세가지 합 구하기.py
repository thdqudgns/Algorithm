ans = []
t = int(input())
for tc in range(1, t+1):
    n = int(input())
    S1 = n*(n+1)//2
    S2 = n**2
    S3 = S1*2
    ans.append(f'#{tc} {S1} {S2} {S3}')

[print(i) for i in ans]