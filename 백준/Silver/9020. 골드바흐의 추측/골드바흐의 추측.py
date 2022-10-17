# 소수는 1과 자기 자신을 제외하고 약수를 가지지 않는다는 성질이 있으며,
# 약수를 가지는 수는 1부터 자기자신의 제곱근 사이에 약수의 절반을 가지고 있다는 성질이 있다.
# 하지만 그 나머지 절반은 굳이 알 필요가 없는데, 어떠한 숫자 x는 a * b로 구성되어 있기 때문에
# 약수 중 더 작은 a를 찾았다면 짝이 되는 b는 자연스럽게 찾을 수 있기 때문이다.
from math import sqrt
num = []

# 소수 먼저 저장한다.
for i in range(2, 10001):
    cnt = 0  # 소수의 개수 확인

    # 제곱근을 사용함으로써 속도를 높여줌. 제곱근 후 +1 하여 제곱근을 안정적으로 범위에 넣어줌.
    for p in range(2, int(sqrt(i)+1)):
        if i % p == 0:      # 나눠진다면 넣고, 패스
            cnt += 1
            break
    if cnt == 0:            # 무언가로 안 나눠질 때만 삽입
        num.append(i)
# print(num)

T = int(input())
for _ in range(T):
    N = int(input())
    for i in range(N//2, -1, -1):
        if i in num:
            if N-i in num:
                print(i, N-i)
                break
        else:
            continue
