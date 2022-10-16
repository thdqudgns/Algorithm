import sys
N, M = map(int, sys.stdin.readline().rstrip().split())
address = dict()

for i in range(N):
    x, y = map(str, sys.stdin.readline().rstrip().split())
    address[x] = y

for i in range(M):
    w = sys.stdin.readline().rstrip()
    print(address[w])