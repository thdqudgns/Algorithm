T = int(input())

for i in range(1, T+1):
    a, b, c = map(int, input().split())
    if c > b:
        print('#{} {}'.format(i, -1))
    elif c < a:
        print('#{} {}'.format(i, a-c))
    else:
        print('#{} {}'.format(i, 0))