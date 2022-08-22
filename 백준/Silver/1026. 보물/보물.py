n = int(input())
a = list(map(int, input().split()))
aa = [0 for i in range(n)]
b = list(map(int, input().split()))
bb = [i for i in b]
a.sort()
for i in a:
    big = 0
    for j in b:
        if j == max(b):
            big = j
            aa[b.index(big)] = i
            b[b.index(big)] = -1
            break
# print(aa)
# print(bb)
result = 0
for i in range(n):
    result += aa[i]*bb[i]
print(result)