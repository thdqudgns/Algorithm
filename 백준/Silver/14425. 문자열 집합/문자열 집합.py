N, M = map(int, input().split())
set_n = set()
cnt = 0
for _ in range(N):
    set_n.add(input())
for _ in range(M):
    w = input()
    if w in set_n:
        cnt += 1
print(cnt)