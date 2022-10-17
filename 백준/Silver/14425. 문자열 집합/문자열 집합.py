N, M = map(int, input().split())
dict_n = dict()
cnt = 0
for _ in range(N):
    w = input()
    dict_n[w] = 0
for _ in range(M):
    w = input()
    if w in dict_n:
        cnt += 1
print(cnt)