sum = list()

for i in range(10):
    a, b = map(int, input().split())
    if i != 0:
        sum.append(sum[i-1] + b - a)
    else:
        sum.append(b-a)
print(max(sum))