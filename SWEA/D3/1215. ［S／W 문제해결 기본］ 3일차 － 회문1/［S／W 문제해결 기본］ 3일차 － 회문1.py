for i in range(1, 10+1):
    N = int(input())
    arr = [list(map(str, input())) for _ in range(8)]
    arr2 = [[0 for _ in range(8)] for _ in range(8)]
    for a in range(8):
        for b in range(8):
            arr2[a][b] = arr[b][a]
    cnt = 0
    for x in range(8):
        for y in range(8):
            mun = arr[x][y:y+N]
            flag = True
            if len(mun) != N:
                break
            for j in range(len(mun)):
                if mun[j] != mun[-(j+1)]:
                    flag = False
                    break
            if flag:
                cnt += 1
    for x in range(8):
        for y in range(8):
            mun = arr2[x][y:y+N]
            flag = True
            if len(mun) != N:
                break
            for j in range(len(mun)):
                if mun[j] != mun[-(j+1)]:
                    flag = False
                    break
            if flag:
                cnt += 1
    print('#{} {}'.format(i, cnt))