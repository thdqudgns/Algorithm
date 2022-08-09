n = int(input())
a = list(map(int, input().split()))
b = [0 for i in range(n)]
m = max(a)

for i in range(n):
    b[i] = a[i]/m*100

print(sum(b)/n)
