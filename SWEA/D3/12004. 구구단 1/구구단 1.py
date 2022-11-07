# 12004. 구구단 1
for tc in range(1, int(input())+1):
    n = int(input())
    result = 'No'
    for i in range(1, 10):
        if n % i != 0 or not(1 <= n//i <= 9):
            continue
        else:
            result = 'Yes'
    print(f'#{tc} {result}')