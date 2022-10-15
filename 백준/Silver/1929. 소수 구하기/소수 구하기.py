N, M = map(int, input().split())
# 에라토스테네스의 체: n의 배수는 다 지운다
arr = [False, False] + [True]*(M-1)     # True인 index들이 뭔가의 배수이면 False로 바꿈

for i in range(2, M+1):
    if arr[i] and i >= N:   # 뭔가의 배수가 아닐 때만 출력함
        print(i)
    for j in range(i*2, M+1, i):    # 배수들을 False로 바꾸는 코드
        arr[j] = False

