T = int(input())
for tc in range(1, T+1):
    N = int(input())    # 2~20
    salaryAvg = 0
    for i in range(N):
        a, b = map(float, input().split())
        salaryAvg += a * int(b)
    print(f'#{tc} {salaryAvg}')