a, b = map(int, input().split())
# 2 > 1 > 3 > 2
if (a == 2 and b == 1) or (a == 1 and b == 3) or (a == 3 and b == 2):
    print('A')
else:
    print('B')