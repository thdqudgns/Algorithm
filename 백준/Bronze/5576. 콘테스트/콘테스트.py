a = list()
b = list()
for i in range(10):
    a.append(int(input()))
a.sort()

for i in range(10):
    b.append(int(input()))
b.sort()

print(sum(a[7:]),end=' ')
print(sum(b[7:]))