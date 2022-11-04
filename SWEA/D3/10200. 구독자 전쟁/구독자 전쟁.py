T = int(input())
for tc in range(1, T+1):
    # N명의 사람, A구독자 A명, B구독자 B명
    # 이때 둘 다 구독하고 있는 사람의 최대와 최소는?
    N, A, B = map(int, input().split())
    dae = min(A, B)
    so = min(A,B) - (N-max(A,B))
    if so < 0:
        so = 0
    print(f'#{tc} {dae} {so}')