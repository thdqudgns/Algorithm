n = int(input())
sumY, sumK = 0, 0
for i in range(n):
    for j in range(9):
        Y, K = map(int, input().split(' '))
        sumY += Y
        sumK += K
    if sumY > sumK: print('Yonsei')
    elif sumK > sumY: print('Korea')
    else: print('Draw')