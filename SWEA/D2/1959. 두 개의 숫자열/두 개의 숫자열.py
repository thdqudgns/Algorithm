T = int(input())
for t in range(T):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
     
    result = -2100
     
    # 긴 배열을 기준으로 짧은 배열을 움직이므로, 어느 배열이 긴지 기억해야 한다.
    # n, a 가 무조건 긴거라고 한다면
    #print('입력 정상')
    if m > n: 
        n, m = m, n
        a, b = b, a
    #print('바꾸기 정상')
    # 이제 n, a가 무조건 긴 배열이다. a를 기준으로 b를 움직이면 된다.
    for i in range(0, n-m+1):    # 시작위치 조정 0~(n-m)
        # 곱하는 것은 시작 index부터 짧은 배열 b의 길이 m만큼
        tmp = 0
        #print('index 변경 정상')
        for s in range(i, i+m, 1):
            # 짧은 배열의 index는 증가하면 안 된다. 계속 0~m 이어야 한다.
            tmp += a[s]*b[s-i]
            #print(tmp, s, a[s], b[s-i])
            #print('곱셈 후 더하기 정상')
        if tmp > result: result = tmp
     
    print(f'#{t+1} {result}')