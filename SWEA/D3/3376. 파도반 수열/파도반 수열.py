for tc in range(1,int(input())+1) :   
    n = int(input())
    pado=[1,1,1]
    for i in range(3,101):
        pado.append(pado[i-3] + pado[i-2])
     
    print(f'#{tc} {pado[n-1]}')