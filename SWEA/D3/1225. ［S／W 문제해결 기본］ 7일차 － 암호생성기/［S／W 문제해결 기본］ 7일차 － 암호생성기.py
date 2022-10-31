from collections import deque
T = 10
while T > 0:
    N = int(input())
    dq = deque(list(map(int, input().split())))
    a = 1
    while True:
        if a == 0:
            break
        for i in range(1, 6):
            num = dq.popleft()-i
            if num < 0:
                num = 0
            dq.append(num)
            if num == 0:
                a = 0
                break
            # print(dq)
    print(f'#{N}', end=' ')
    print(*dq)
    T -= 1