n = int(input())
a = [i for i in range(1, n+1) if n%i == 0]
for i in a:
    print(i, end=' ')