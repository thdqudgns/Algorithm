def cal(res, x, y):
    if y == 1:
        return res * x
    else:
        res *= x
        y -= 1
        return cal(res, x, y)

for i in range(1, 10+1):
    N = int(input())
    x, y = map(int, input().split())
    res = 1
    print('#{} {}'.format(i, cal(res, x, y)))