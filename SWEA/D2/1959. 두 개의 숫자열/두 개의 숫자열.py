for tc in range(1, int(input())+1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    # 무조건 N, A를 작은걸로 한다.
    if N > M:
        A, B = B, A
        N, M = M, N

    maxResult = 0
    # 5 3
    # 3 6 -7 5 4
    for i in range(M-N+1):  # 0 1 2 3
        result = 0
        for j in range(N):  # 0 1
            result += A[j] * B[j+i]
        # A[0] * B[0]
        # A[1] * B[1]

        # A[0] * B[1]
        # A[1] * B[2]

        # A[0] * B[2]
        # A[1] * B[3]

        # A[0] * B[3]
        # A[1] * B[4]

        if result > maxResult:
            maxResult = result

    print(f'#{tc} {maxResult}')