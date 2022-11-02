T = int(input())
for i in range(1, T+1):
    arr = list(map(int, input().split()))
    for j in range(5):
        if arr[j] < 40:
            arr[j] = 40
    print(f'#{i} {sum(arr)//5}')
