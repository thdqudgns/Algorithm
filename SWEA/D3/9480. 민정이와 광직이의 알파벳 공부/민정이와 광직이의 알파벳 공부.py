# 9480. 민정이와 광직이의 알파벳 공부
alpha_set = set(list('abcdefghijklmnopqrstuvwxyz'))
T = int(input())
for tc in range(1,T+1) :
    n = int(input())
    word = [ input() for _ in range(n)]
    res = 0
    for i in range(1<<n) :
        arr = [ ]
        for j in range(n) :
            if i&(1<<j) :
                arr.append(word[j])
        if not (len(alpha_set-set(list(''.join(arr))))) :
            res += 1
    print(f'#{tc} {res}')