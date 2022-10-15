import sys

n, m = map(int, sys.stdin.readline().rstrip().split())
arr_n = set()
arr_m = set()

for _ in range(n):
    arr_n.add(sys.stdin.readline().rstrip())

for _ in range(m):
    arr_m.add(sys.stdin.readline().rstrip())

result = sorted(list(arr_n & arr_m))

print(len(result))
for i in result:
    print(i)