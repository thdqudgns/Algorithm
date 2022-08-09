n = int(input())
cnt = 0     # 10부제를 실시하는 차량 개수 (0~5)
a = list(map(int, input().split()))
for i in a:
    if i == n:
        cnt += 1
print(cnt)