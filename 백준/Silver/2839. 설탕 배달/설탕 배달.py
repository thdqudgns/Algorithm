n = int(input())
result = n
# 맨 처음에는 5로 나눈다.
# 나머지가 있으면 그 몫만큼 반복을 돌리면서, 나머지가 3으로 나눠지는 경우를 본다.
for i in range((n//5)+1):   # 3
    a = n - (i*5)   # 18-0 = 18, 18-5 = 13, 18-10 = 8, 18-15 = 3
    b = i + a//3
    if a%3 == 0 and b < result:     # 나머지가 3으로 나눠지고, b가 result보다 작으면
        result = b                  # b를 result로 최신화
    else:
        continue    # 나머지가 3으로 안 나눠진다면 pass
if result == n:
    print(-1)       # result가 최신화가 안 되어 초기값과 같다면 -1을 출력한다.
else:
    print(result)   # result가 최신화가 되었다면 그대로 출력한다.