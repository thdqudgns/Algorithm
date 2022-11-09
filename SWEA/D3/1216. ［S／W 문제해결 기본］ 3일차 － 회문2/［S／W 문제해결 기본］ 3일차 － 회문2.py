for _ in range(10):
    i=int(input())
    m=[[*map(str,input())]for _ in range(100)]
    z=[*map(list,zip(*m))]
    a=1
    for j in range(100):
        t=a+1
        while t-a<3:
            for k in range(101-t):
                r=m[j][k:k+t]
                c=z[j][k:k+t]
                p=1
                s=1
                for q in range(t//2):
                    if r[q]!=r[t-1-q]:p=0
                    if c[q]!=c[t-1-q]:s=0
                if p==1 or s==1:a=t
            t+=1
    print(f'#{i} {a}')