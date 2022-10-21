T = int(input())

for i in range(1, T+1):
    a, b = map(int, input().split())
    time = a + b
    if time < 24:
        print('#{} {}'.format(i, time))
    else:
        time %= 24
        print('#{} {}'.format(i, time))