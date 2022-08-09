a,b,c = map(int, input().split(' '))

if a==b and a==c:
    print(a * 1000 + 10000)
if (a==b and a!=c) or (a!=b and a==c):
    print(a * 100 + 1000)
elif b==c and b!=a:
    print(b * 100 + 1000)
if a!=b and a!=c and b!=c:
    nun = [a,b,c]
    nun.sort()
    print(nun[2]*100)
