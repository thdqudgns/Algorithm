# 테스트케이스 10 고정, 100x100 배열 고정
for _ in range(10):
    t = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    maxA = 0
    maxB = 0
    maxC = 0
     
    # 행, 열, 대각선의 합
    for i in range(100):
        sumA, sumB, sumC = 0, 0, 0
        for j in range(100):
            sumA += arr[i][j]
            sumB += arr[j][i]
            if i == 0:
                sumC += arr[j][j]
        if sumA > maxA: maxA = sumA
        if sumB > maxB: maxB = sumB
        if sumC > maxC: maxC = sumC
     
    # 비교
    result = max(maxA, maxB, maxC)
     
    print(f'#{t} {result}')