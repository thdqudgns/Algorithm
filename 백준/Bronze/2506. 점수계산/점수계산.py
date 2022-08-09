n = int(input())    # 반복횟수
a = list(map(int, input().split()))
sum = 0
cnt = 0
for i in a:
    if i == 0:
        cnt = 0
        continue
    else:
        cnt += 1
        sum += cnt
print(sum)