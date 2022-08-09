n = int(input())
a = []
a = list(map(int, input().split(' ')))

a.sort()
sum = 0
for i in range(len(a)):
    sum += a[i]*(n-i)
# a[0]*(n) + a[1]*(n-1)

print(sum)