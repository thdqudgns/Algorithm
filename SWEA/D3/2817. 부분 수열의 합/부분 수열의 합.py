from itertools import combinations
for tc in range(1, int(input())+1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    cnt = 0
    for i in range(1, len(arr)+1):
        combi = list(combinations(arr, i))
        for j in range(len(combi)):
            if sum(combi[j]) == K:
                cnt += 1
    print(f'#{tc} {cnt}')