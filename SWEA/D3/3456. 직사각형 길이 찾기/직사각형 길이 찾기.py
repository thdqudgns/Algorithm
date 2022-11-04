T = int(input())
for i in range(1, T+1):
    a, b, c = map(int, input().split())
    d = 0
    if a==b and a==c:
        d = a
    elif a==b and a!=c:
        d = c
    elif a!=b and a==c:
        d = b
    elif b==c:
        d = a
    print(f'#{i} {d}')