# 소인수분해는 한 숫자에서 나눌 수 있는 최대로 나눠야 한다.

N = int(input())

if N == 1:
    print('')

for i in range(2, N+1): # i는 2부터 N까지 자동 증가
    if N % i == 0:
        while N % i == 0: # i로 나눌 수 있는 만큼 나누기
            print(i)
            N = N / i
