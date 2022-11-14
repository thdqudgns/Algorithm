# 1970. 쉬운 거스름돈
standard = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for tc in range(1, int(input())+1):
    money = int(input())
    arr = [0 for _ in range(8)]
    for i in range(8):
        arr[i] = money//standard[i]
        money %= standard[i]
    print(f'#{tc}')
    print(*arr)