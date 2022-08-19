import sys
n = int(sys.stdin.readline())
for i in range(n):
    a = list(map(int, sys.stdin.readline().strip().split()))
    a.sort()
    a.pop(4)
    a.pop(0)
    if max(a) - min(a) >= 4:
        print('KIN')
        continue
    else:
        print(sum(a))