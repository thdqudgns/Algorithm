import sys
input = sys.stdin.readline

T = int(input().rstrip())
for _ in range(T):
    H, W, N = map(int, input().rstrip().split())
    c, h = 0, 0
    if N % H == 0:
        c = H
        h = N//H
    else:
        c = N % H
        h = (N//H) + 1
    if h < 10:
        h = '0' + str(h)
    print(str(c)+str(h))