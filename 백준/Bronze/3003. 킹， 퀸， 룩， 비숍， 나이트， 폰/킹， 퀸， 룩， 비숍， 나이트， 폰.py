a = list(map(int, input().split()))
# a[0] + b[0] = 1
# b[0] = 1 - a[0]
b = [0 for _ in range(6)]
b[0] = 1 - a[0]
b[1] = 1 - a[1]
b[2] = 2 - a[2]
b[3] = 2 - a[3]
b[4] = 2 - a[4]
b[5] = 8 - a[5]
for i in range(6):
    print(b[i], end=' ')