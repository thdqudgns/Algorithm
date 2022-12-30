test_case = int(input())
answer = [0 for _ in range(test_case)]  # 정답을 저장할 배열
for t in range(test_case):
    sdocu = [list(map(int, input().split())) for _ in range(9)]
    result = 1  # 정상인지 아닌지
     
    # 1. 가로세로 비교(곱이나 합을 사용하는 것보다, 숫자를 비교하는 것이 정확하다)
    for i in range(9):
        standardW = [0 for _ in range(10)]  # index를 9까지 하여, index 자체로 숫자 비교를 한다.
        standardH = [0 for _ in range(10)]  # index를 9까지 하여, index 자체로 숫자 비교를 한다.
        for j in range(9):
            # W는 행 비교, H는 열 비교
            if standardW[sdocu[i][j]] == 0: 
                standardW[sdocu[i][j]] = 1
            if standardH[sdocu[j][i]] == 0: 
                standardH[sdocu[j][i]] = 1            
        if sum(standardW) < 9 or sum(standardH) < 9: 
            result = 0
            break
     
    # 2. 3x3 공간 비교
    if result == 1:
        # 시작점
        position = [[0, 0], [0, 3], [0, 6], [3, 0], [3, 3], [3, 6], [6, 0], [6, 3], [6, 6]]
        for i, j in position:
            standard = [0 for _ in range(10)]
            for x in range(i, i+3):
                for y in range(j, j+3):
                    if standard[sdocu[x][y]] == 0:
                        standard[sdocu[x][y]] = 1
            if sum(standard) < 9:
                result = 0
                break
     
    # 결과 저장
    answer[t] = result
     
# 결과 출력
for t in range(test_case):
    print(f'#{t+1} {answer[t]}')