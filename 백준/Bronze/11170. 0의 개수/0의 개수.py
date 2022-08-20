# 숫자를 1씩 증가시키면서, 숫자를 문자로 바꾸고,
# 문자를 하나씩 뽑아내면서 0의 개수를 센다.
T = int(input())
for i in range(T):
    N, M = map(int, input().split())
    cnt = 0
    for j in range(N, M+1):
        word = str(j)
        for k in word:
            if k == '0':
                cnt += 1
    print(cnt)