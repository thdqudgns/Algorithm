for tc in range(1, int(input())+1):
    N = int(input())
    arr = [True, True, True, True, True, True, True, True, True, True]
    k = 0
    while True:
        if True not in arr:
            break
        k += 1
        s = str(k*N)
        for i in s:
            if arr[int(i)]:
                arr[int(i)] = False
    print(f'#{tc} {k*N}')