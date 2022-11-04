T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())
    arr = sorted(map(int, input().split()), reverse=True)
    sum = 0
    for i in range(K):
        sum += arr[i]
    print(f'#{tc} {sum}')
