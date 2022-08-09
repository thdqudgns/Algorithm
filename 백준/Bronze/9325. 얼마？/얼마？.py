N = int(input())

for i in range(N):
    s = int(input())
    n = int(input())
    sum = 0
    for j in range(n):
        q, p = map(int, input().split(' '))
        sum = sum + (q*p)
    print(s+sum)