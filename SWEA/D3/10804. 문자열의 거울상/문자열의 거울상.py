T = int(input())
for i in range(1, T+1):
    w = list(input()[::-1])
    for j in range(len(w)):
        if w[j] == 'b':
            w[j] = 'd'
        elif w[j] == 'd':
            w[j] = 'b'
        elif w[j] == 'p':
            w[j] = 'q'
        elif w[j] == 'q':
            w[j] = 'p'
    print(f'#{i}', end=' ')
    print(''.join(w))