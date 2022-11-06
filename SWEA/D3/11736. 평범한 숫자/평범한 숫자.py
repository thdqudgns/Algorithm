# 11736. 평범한 숫자
for tc in range(1, int(input())+1):
    n = int(input())
    num = list(map(int, input().split()))
    result = 0
    for i in range(1, n-1):
        if num[i-1] < num[i] < num[i+1] or num[i-1] > num[i] > num[i+1]:
            result += 1
    print(f'#{tc} {result}')