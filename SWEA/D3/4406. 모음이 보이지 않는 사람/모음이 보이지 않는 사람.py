t = int(input())
mo = {'a', 'e', 'i', 'o', 'u'}
for i in range(1, t+1):
    w = input()
    res = ''
    for j in w:
        if j not in mo:
            res += j
    print('#{} {}'.format(i, res))