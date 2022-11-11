# 11387. 몬스터 사냥
T = int(input())
for tc in range(1, T + 1):
    D, L, N = map(int, input().split())
    result = 0
    cnt = 0
    while cnt < N:
        result += D*(1+(cnt*L/100))
        cnt += 1
    print(f'#{tc} {int(result)}')