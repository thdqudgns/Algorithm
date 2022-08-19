import sys
n = int(input())
for i in range(n):
    a = list(map(int, sys.stdin.readline().strip().split()))
    b = [i for i in a if i % 2 == 0]
    print(sum(b), min(b))