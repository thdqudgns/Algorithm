T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    twinhon = N-M
    unicorn = M-twinhon
    print(f'#{tc} {unicorn} {twinhon}')