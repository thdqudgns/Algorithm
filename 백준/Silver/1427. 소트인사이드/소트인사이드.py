n = input()
m = []
for i in range(len(n)):
    m.append(int(n[i]))

m.sort(reverse=True)
for i in m:
    print(i, end='')