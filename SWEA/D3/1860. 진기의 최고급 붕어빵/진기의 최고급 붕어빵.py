# N: 손님 수
# M: 붕어빵 제작 시간
# K: 붕어빵 생산 수
# M초 동안 K개의 붕어빵을 만든다.

# N, M, K 입력 이후에는
# N개의 정수가 공백으로 구분되어 입력된다.
# 즉, N명의 사람들 각각이 몇초에 도착하는지 주어진다.

# 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 아니라면 “Impossible”을 출력한다.

for t in range(1, int(input()) + 1):
    N, M, K = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()

    result = "Possible"
    for i in range(N):
        # (붕어빵 생산 수)*(손님의 도착시간 // 붕어빵 제작시간) - (손님 수)
        # (한 횟수 당 붕어빵 생산 수)*(손님의 도착시간에 붕어빵을 생산할 수 있는 횟수) - (손님 수)
        # 손님의 도착시간 내에 만들 수 있는 붕어빵의 개수 - 붕어빵을 줘야 하는 손님 수
        carpa = K * (arr[i] // M) - (i + 1)

        # 생산한 붕어빵의 수보다 붕어빵을 줘야 하는 손님의 수가 많다면 Impossible이다.
        if carpa < 0:
            result = "Impossible"

    print(f"#{t} {result}")