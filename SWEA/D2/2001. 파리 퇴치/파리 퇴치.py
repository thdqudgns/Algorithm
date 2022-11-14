# 2001. 파리 퇴치
for tc in range(1, int(input())+1):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    maxFly = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            test = 0
            for k in range(i, i+m):
                test += sum(arr[k][j:j+m])
            if test > maxFly:
                maxFly = test
    print(f'#{tc} {maxFly}')