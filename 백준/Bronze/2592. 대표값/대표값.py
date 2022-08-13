sum = 0
a = list()
b = []
for i in range(10):
    n = int(input())
    sum += n
    a.append(n)
for i in range(10):
    b.append(a.count(a[i]))

print(sum//10)
print(a[b.index(max(b))])