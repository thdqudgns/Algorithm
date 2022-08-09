b = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
c = [0 for i in range(26)]
m = input().upper()
for w in m:
    c[b.index(w)] += 1

num = max(c)

if c.count(num) > 1:
    print('?')
else:
    print(b[c.index(num)])