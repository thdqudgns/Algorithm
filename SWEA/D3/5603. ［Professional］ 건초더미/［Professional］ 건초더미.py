for tc in range(1, int(input())+1):
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(int(input()))
    avg = sum(arr)//N
    cnt = 0
    for i in arr:
        cnt += abs(avg-i)
    cnt = cnt//2
    print(f'#{tc} {cnt}')