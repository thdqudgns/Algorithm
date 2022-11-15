# N: 손님 수
# M: 붕어빵 제작 시간
# K: 붕어빵 생산 수
# M초 동안 K개의 붕어빵을 만든다.

# N, M, K 입력 이후에는
# N개의 정수가 공백으로 구분되어 입력된다.
# 즉, N명의 사람들 각각이 몇초에 도착하는지 주어진다.

# 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 아니라면 “Impossible”을 출력한다.

for tc in range(1, int(input())+1):
    N, M, K = map(int, input().split())
    result = 'Possible'
    arr = sorted(map(int, input().split()))

    # 기준은 시간이다. 1초 부터 마지막 손님의 도착 시간까지
    bread = 0
    for i in range(max(arr)+1):
        # M초가 지날 때마다 빵이 추가된다.
        if i % M == 0 and i != 0:
            bread += K

        # 손님이 도착하면 빵이 사라진다.
        for customer in arr:
            # i초에 손님이 도착했다면 빵을 뺀다.
            if customer == i:
                bread -= 1

        if bread < 0:
            result = 'Impossible'
            break

    print(f'#{tc} {result}')

