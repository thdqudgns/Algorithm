for tc in range(1, int(input())+1):
    # N 초 동안 이동한 거리를 구하여라
    # 거리 = 속력 * 시간(1초로 고정)
    # 0이면 속도 유지, 1이면 가속, 2면 감속
    # 0,1,2 를 통한 속도 변경 후에 각각의 경우마다 거리 이동을 계산하여 '총 이동거리'에 더해준다.
    move = 0    # 제출할 정담. 이동거리
    k = 0       # 변하는 가속도
    N = int(input())
    for i in range(N):
        arr = list(map(int, input().split()))
        if arr[0] == 1:
            k += arr[1]
        elif arr[0] == 2:
            k -= arr[1]
        if k < 0:
            k = 0
        move += k

    print(f'#{tc} {move}')