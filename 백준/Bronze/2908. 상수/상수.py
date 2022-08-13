a, b = map(str, input().split())
aa, bb = 0, 0

aa += int(a[0])*1
aa += int(a[1])*10
aa += int(a[2])*100

bb += int(b[0])*1
bb += int(b[1])*10
bb += int(b[2])*100

if aa > bb:
    print(aa)
else:
    print(bb)