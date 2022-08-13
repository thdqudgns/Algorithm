import math
n = list(str(math.factorial(int(input()))))
# print(n)
zero_cnt = 0
if len(n) == 1: print(0)
for i in range(len(n)-1, 0, -1):
    if int(n[i]) == 0:
        zero_cnt += 1
    else:
        print(zero_cnt)
        break