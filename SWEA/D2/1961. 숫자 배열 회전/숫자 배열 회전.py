def rotate(arr, n):
    arr2 = [[0 for _ in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            arr2[i][j] = arr[n-1-j][i]
    return arr2

for tc in range(1, int(input())+1):
    n = int(input())
    arr = [list(map(str, input().split())) for _ in range(n)]
    arr90 = rotate(arr, n)
    arr180 = rotate(arr90, n)
    arr270 = rotate(arr180, n)
    print(f'#{tc}')
    [print(''.join(arr90[i]), ''.join(arr180[i]), ''.join(arr270[i])) for i in range(n)]
