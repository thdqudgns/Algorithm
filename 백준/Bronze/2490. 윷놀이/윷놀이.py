for i in range(3):
    a = list(map(int, input().split()))     # 윷의 개수를 제한하지 않는 단점이 있다.
    cnt = a.count(0)
    if cnt == 0: print('E')
    elif cnt == 1: print('A')
    elif cnt == 2: print('B')
    elif cnt == 3: print('C')
    else: print('D')
