T = int(input())
for i in range(1, T+1):
    N = int(input())
    arr = [input() for _ in range(N)]
    soil = [[0 for _ in range(N)] for _ in range(N)]
    for n in range(N):
        for m in range(N):
            soil[n][m] = int(arr[n][m])
    soil_sum = 0
    mid = N // 2
    for j in range(mid+1):
        if j != mid:
            soil_sum += sum(soil[j][mid-j:mid+j+1])
            soil_sum += sum(soil[N-1-j][mid-j:mid+j+1])
        else:
            soil_sum += sum(soil[j][mid-j:mid+j+1])
    print(f'#{i} {soil_sum}')
