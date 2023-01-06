T = int(input())
for t in range(1, T+1):
    n = int(input())
    a = [list(input().split()) for _ in range(n)]
    b = [[0 for _ in range(n)] for _ in range(n) ]
     
    for i in range(n):
        for j in range(n):
            b[i][j] = a[n-j-1][i]
                 
    print(f'#{t}')
    for i in range(n):
        print(f"{''.join(b[i])} {''.join(reversed(a[-i-1]))} {''.join(reversed(b[-i-1]))}")
