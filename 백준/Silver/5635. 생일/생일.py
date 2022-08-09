import sys
input = sys.stdin.readline

n = int(input())
b = []

for i in range(n):
    b.append(list(map(str, input().rstrip().split())))
    b[i][1] = int(b[i][1])
    b[i][2] = int(b[i][2])
    b[i][3] = int(b[i][3])

# print(b)
b = sorted(b, key=lambda x: (x[3], x[2], x[1]))
# print(b)
print(b[len(b)-1][0])
print(b[0][0])
