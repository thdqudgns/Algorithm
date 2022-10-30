from math import sqrt

def palindrome(n):
    n = list(str(n))
    flag = True
    for p in range(len(n)):
        if n[p] != n[-(p+1)]:
            flag = False
            break
    return flag

T = int(input())

for i in range(1, T+1):
    a, b = map(int, input().split())
    cnt = 0
    for num in range(a, b+1):
        x = num
        y = sqrt(num)
        # 31이 1000이하 중 최대의 제곱근이다.
        # sqrt는 실수로 출력되어 31.0 가 최대인데
        # 문자열로 따지면 길이가 4인 셈이다.
        # 따라서 길이가 4가 넘어가는 것들은 진짜 실수기에 제외한다.
        if len(str(y)) > 4:
            continue
        else:
            y = int(y)
        if palindrome(x):
            if palindrome(y):
                cnt += 1

    print('#{} {}'.format(i, cnt))