for tc in range(1, int(input())+1):
    P, Q, R, S, W = map(int, input().split())
    A = P*W
    B = Q
    if W > R:
        B += S*(W-R)
    print(f'#{tc} {min(A, B)}')