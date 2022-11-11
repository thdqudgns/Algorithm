# 10580. 전봇대
def countCrossPoint(arr):
    cnt = 0
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            if arr[i][0] < arr[j][0] and arr[i][1] > arr[j][1]:
                cnt += 1
            elif arr[i][0] > arr[j][0] and arr[i][1] < arr[j][1]:
                cnt += 1
    return cnt

T = int(input())
for tc in range(1, T + 1):
    # 교차점: 두 선분의 양 끝점을 비교했을 때 한쪽은 작고, 한쪽은 클 때 존재함.
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    result = countCrossPoint(arr)
    print(f'#{tc} {result}')