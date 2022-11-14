T=int(input())
for tc in range(1,T+1):
    N=int(input())
    arr=list(input().split())
    while N>len(arr):
        arr+=list(input().split())
    arr=''.join(arr)
   
    for i in range(1000):
        if str(i) not in arr:
            break
    print(f'#{tc} {i}')