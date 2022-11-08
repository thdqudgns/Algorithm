# 3131. 100만 이하의 모든 소수
import math

arr = [True for _ in range(1000001)]    # 처음엔 모든 수가 소수인 것으로 초기화

# 에라토스테네스의 체 알고리즘: 배수를 지운다.
for i in range(2, int(math.sqrt(1000000))+1):   # 2부터 n의 제곱근까지의 수를 확인
    if arr[i] == True:  # i가 소수인 경우(남은 수인 경우)
        # i를 제외한 i의 모든 배수를 지우기
        j = 2
        while i*j <= 1000000:   # 일일히 반복하면서 지운다
            arr[i*j] = False
            j += 1

for i in range(2, 1000001):
    if arr[i]:  # 소수라면 출력
        print(i, end=' ')