T = int(input())
arr=[]
for tc in range(1, T + 1):
    A,B,C,D=map(int,input().split())
    if A and not B and not C and not D:
        res='0'*(A+1)
    elif D and not A and not B and not C:
        res='1'*(D+1)
    elif B==C and B:
        res='0'*(A+1)+'10'*(B-1)+'1'*(D+1)+'0'
    elif B-C==1:
        res='0'*(A+1)+'10'*(B-1)+'1'*(D+1)
    elif C-B==1:
        res='1'*(D+1)+'01'*(B)+'0'*(A+1)
    else:
        res='impossible'
    arr.append(res)
for tc in range(1,T+1):
    print(f'#{tc} {arr[tc-1]}')