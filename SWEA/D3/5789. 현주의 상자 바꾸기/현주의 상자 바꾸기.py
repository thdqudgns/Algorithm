# 5789. 현주의 상자 바꾸기
for tc in range(1, int(input())+1):
    N, Q = map(int, input().split())
    box = [0 for _ in range(N)]
    for i in range(1, Q+1):
        L, R = map(int, input().split())
        for j in range(L-1, R):
            box[j] = i
    print(f'#{tc}', end=' ')
    print(*box)