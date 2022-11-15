for tc in range(1, int(input())+1):
    N = int(input())
    arr = list(map(int, input().split()))
    result = 0
    for i in range(N-1):
        for j in range(i+1, N):
            tmp = str(arr[i]*arr[j])
            flag = True
            for k in range(len(tmp)-1):
                if int(tmp[k]) > int(tmp[k+1]):
                    flag = False
            if flag and int(tmp) > result:
                result = int(tmp)
    if result == 0:
        result = -1

    print(f'#{tc} {result}')