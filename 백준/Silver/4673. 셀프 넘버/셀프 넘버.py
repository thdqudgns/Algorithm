a = [ i for i in range(10000)]

def cal(n):
    z = str(n)
    sum = int(n)
    for i in range(len(z)):
        sum += int(z[i])
    if sum in a:
        a.remove(sum)

for i in range(10000):
    cal(i)

for i in range(len(a)):
    print(a[i])