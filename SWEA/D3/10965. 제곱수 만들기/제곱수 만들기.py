T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
primes = [2]
for i in range(3, int(10000000 ** 0.5), 2):
    for p in primes:
        if not i % p:break
    else:
        primes.append(i)
res = []
for test_case in range(1, T + 1):
    num = int(input())
    answer = 1
    #num이 제곱근이 있으면 그냥 answer을 출력
    if num ** 0.5 != int(num ** 0.5):
        #각 소수들을 하나씩 나누어서 그 소수가 나누어지는지 확인
        for p in primes:
            cnt = 0
            #정해진 소수p가 나누어질때까지 확인
            while not num % p:
                num //= p
                cnt += 1
            #나누어진 수가 짝수이면 answer에 더해줍니다.
            if cnt % 2:
                answer *= p
            #더이상 나눌수 없으면 for문을 끝내줍니다.
            if num == 1 or p > num:
                break
        if num > 1:
            answer *= num
    res.append('#{} {}'.format(test_case, answer))
for r in res:
    print(r)