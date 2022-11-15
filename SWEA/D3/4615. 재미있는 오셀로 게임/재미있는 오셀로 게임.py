T=int(input())
for tc in range(1,T+1):
    N,M=map(int,input().split())
    arr=[[0]*(N+1)for _ in range(N+1)]
    n=N//2
    arr[n][n]=arr[n+1][n+1]=2
    arr[n][n+1]=arr[n+1][n]=1
    for _ in range(M):
        sx,sy,d=map(int,input().split())
        arr[sx][sy]=d
        for dx,dy in ((-1,0),(-1,-1),(-1,1),(1,0),(1,-1),(1,1),(0,-1),(0,1)):
            r=[]
            for i in range(1,N):
                nx,ny=sx+dx*i,sy+dy*i
                if 1<=nx<=N and 1<=ny<=N:
                    if arr[nx][ny]==0:
                        break
                    elif arr[nx][ny]==d:
                        while r:
                            tx,ty=r.pop()
                            arr[tx][ty]=d
                        break
                    else:
                        r.append((nx,ny))
                else:
                    break
    b=w=0
    for j in arr:        
        b+=j.count(1)
        w+=j.count(2)
    print(f'#{tc} {b} {w}')