import sys
n = int(input())
a = []
for i in range(n):
    a.append(list(map(int, sys.stdin.readline().strip().split())))

a.sort(key=lambda x: (x[1], x[0]))

cnt = 1
end_time = a[0][1]
for i in range(1, n):
    if a[i][0] >= end_time:
        cnt += 1
        end_time = a[i][1]
print(cnt)