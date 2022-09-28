def apart(k, n):
    arr = [[0 for i in range(n+1)] for j in range(k+1)]
    for i in range(1, n+1):     # 0층
        arr[0][i] = i
    for floor in range(1, k+1): # k층
        for ho in range(1, n+1):
            sum = 0
            for i in range(1, ho+1):
                sum += arr[floor-1][i]
            arr[floor][ho] = sum
    answer = arr[k][n]
    print(answer)

T = int(input())

for _ in range(T):
    k = int(input())
    n = int(input())
    apart(k, n)