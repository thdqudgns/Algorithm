import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

result = N-M
if result < 0:
    print(-result)
else:
    print(result)
