import sys
N = int(sys.stdin.readline())
for _ in range(N):
    a, b = map(int, sys.stdin.readline().strip().split())
    print(f'You get {a//b} piece(s) and your dad gets {a%b} piece(s).')