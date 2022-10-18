from math import sqrt
T = int(input())

for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    length = sqrt(abs(y2-y1)**2 + abs(x2-x1)**2)
    if r1 == r2 and length == 0:
        print(-1)
    elif r1 + r2 > length > abs(r1-r2):
        print(2)
    elif r1 + r2 == length or abs(r1-r2) == length: # 외접, 내접
        print(1)
    else:
        print(0)

