# target의 시작은 입력받은 수의 /2, 끝은 입력받은수
N = int(input())
start = N//2
result = 0
# 시작에서 1씩 증가함
# 점점 증가하는 수,
for s in range(start, N):   # 오름차순이기에 최솟값에서 멈춘다.
    sum = s
    for i in str(s):    # 각 자리수를 더함
        sum += int(i)
    if sum == N:        # s가 생성자가 되었으면 출력하고 멈춤
        result = s
        break
print(result)

