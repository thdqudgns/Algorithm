T = int(input())
first = []
for i in range(T):
    a,b,c = map(int, input().split(' '))
    if a==b and a==c:
        first.append(a * 1000 + 10000)
    if (a==b and a!=c) or (a!=b and a==c):
        first.append(a * 100 + 1000)
    elif b==c and b!=a:
        first.append(b * 100 + 1000)
    if a!=b and a!=c and b!=c:
        nun = [a,b,c]
        nun.sort()
        first.append(nun[2]*100)

first.sort()
print(first[len(first)-1])