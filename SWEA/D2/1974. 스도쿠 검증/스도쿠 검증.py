# 1974. 스도쿠 검증
for tc in range(1, int(input())+1):
    # 1. 배열 입력받기
    arr = [list(map(int, input().split())) for _ in range(9)]
    arr2 = list(zip(*arr))
    flag = 1

    # 2. 검증 - 행, 열
    for i in range(9):
        setA = set(arr[i])
        setB = set(arr2[i])
        if len(setA) != 9 or len(setB) != 9:
            flag = 0
            break

    if flag == 0:
        print(f'#{tc} {flag}')
        continue

    # 2. 검증 - 3x3 칸
    for i in range(0, 9, 3):    # 0, 3, 6
        for j in range(0, 9, 3):    # 0, 3, 6
            setC = set()
            for k in range(i, i+3):
                for l in range(j, j+3):
                    setC.add(arr[k][l])
            if len(setC) != 9:
                flag = 0
                break

    if flag == 0:
        print(f'#{tc} {flag}')
    else:
        print(f'#{tc} {flag}')
