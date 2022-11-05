T = int(input())
for tc in range(1, T+1):
    s = input()
    alpha = []
    check = dict()
    for w in s:
        if w not in alpha:
            alpha.append(w)
    for w in s:
        if w not in check:
            check[w] = 1
            continue
        if w in check:
            check[w] += 1
    result = 'No'
    if len(alpha) == 2 and check[alpha[0]] == 2 and check[alpha[1]] == 2:
        result = 'Yes'
    print(f'#{tc} {result}')