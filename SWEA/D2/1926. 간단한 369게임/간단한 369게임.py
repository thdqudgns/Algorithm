n = input()
for i in range(1, int(n) + 1):
    m = list(str(i))
    if '3' in m or '6' in m or '9' in m:
        for j in m:
            if j == '3' or j == '6' or j == '9':
                print('-', end='')
            else:
                print('', end='')
    else:
        print(int(i), end='')
    print('', end=' ')