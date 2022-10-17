import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
dict_n = dict()
cnt = 0
for _ in range(N):
    w = sys.stdin.readline().rstrip()
    dict_n[w] = 0
for _ in range(M):
    w = sys.stdin.readline().rstrip()
    if w in dict_n:
        cnt += 1
print(cnt)