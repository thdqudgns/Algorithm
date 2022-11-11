move=[(-1,0),(1,0),(0,-1),(0,1)]
command_dict = {'U' : 0, 'D' : 1, 'L' : 2, 'R' : 3, 'S' :4,'^' : 0, 
                'v' : 1, '<': 2, '>': 3, 0: '^', 1: 'v', 2:'<', 3:'>'}
find=['<','>','^','v']
T=int(input())
for tc in range(1,T+1):
    H,W=map(int,input().split())
    arr=[list(input())for _ in range(H)]
    N=int(input())
    arr2=input()
    for i in range(H):
        for j in range(W):
            if arr[i][j] in find:
                ta=(i,j,command_dict[arr[i][j]])
                break
        else: continue
        break   
    for com in arr2:        
        temp=command_dict[com]        
        if temp==4:
            dy=ta[0]
            dx=ta[1]
            while True:
                dy+=move[ta[2]][0]
                dx+=move[ta[2]][1]
                if dy<0 or dx<0 or dy>=H or dx >=W or arr[dy][dx]=='#':
                    break
                if arr[dy][dx]=='*':
                    arr[dy][dx]='.'
                    break
        else:
            y=ta[0]
            x=ta[1]
            dy=y+move[temp][0]
            dx=x+move[temp][1]            
            arr[y][x]=command_dict[temp]
            ta=(y,x,temp)    
            if 0<=dy<H and 0<=dx<W and arr[dy][dx]=='.':
                arr[y][x]='.'
                arr[dy][dx]=command_dict[temp]
                ta=(dy, dx,temp)
    print(f'#{tc}',end=' ')
    for q in arr:
        print(''.join(q))