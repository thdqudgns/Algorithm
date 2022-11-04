for tc in range(1, 11):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    max = 0
    diagonalSum = 0
    for i in range(100):
        # 행
        if sum(arr[i]) > max:
            max = sum(arr[i])
        
        columSum = 0
        for j in range(100):
            columSum += arr[j][i]
            if i == j:
                diagonalSum += arr[i][j]
        # 열
        if columSum > max:
            max = columSum
    # 대각선
    if diagonalSum > max:
        max = diagonalSum

    print(f'#{tc} {max}')