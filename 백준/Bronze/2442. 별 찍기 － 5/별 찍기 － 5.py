N = int(input())
e = ' '
s = '*'
# 1 3 5 7 9 11
# (5-1) = (N-i) 1
# (5-2) = (N-i) 3
# 2 5
# 1 7
# 0 9
for i in range(N):
    print(str(e*(N-(i+1))),end='')
    print(str(s*((2*i)+1)))
# 뒤의 공백을 지움