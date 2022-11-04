T = int(input())
for tc in range(1, T+1):
    N, D = map(int, input().split())
    spread = 2*D+1
    cnt = N/spread
    if cnt != int(cnt):
        cnt += 1
    print(f'#{tc} {int(cnt)}')