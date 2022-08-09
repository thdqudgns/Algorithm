T = int(input())

for _ in range(T):
    N = int(input())
    C, sum = 0, 0
    for i in range(N):
        a, b = map(float, input().split(' '))
        C += a
        sum += a*b
    print(int(C),end=' ')
    print('%.1f' %(sum/C))