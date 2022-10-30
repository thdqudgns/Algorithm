T = int(input())

for i in range(1, T+1):
    a, b = map(int, input().split())
    cnt = 0
    for num in range(a, b+1):
        y = num**(1/2)
        if y != int(y):
            continue
        y = int(y)
        if str(num) == str(num)[::-1] and str(y) == str(y)[::-1]:
            cnt += 1

    print('#{} {}'.format(i, cnt))