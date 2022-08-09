n = int(input())
a1, a2 = 0, 1
cnt, sum = 0, 0

while cnt < n:
    sum = a1 + a2
    a1, a2 = a2, sum
    cnt += 1

print(a1)