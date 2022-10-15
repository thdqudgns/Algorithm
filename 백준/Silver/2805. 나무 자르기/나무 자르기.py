import sys
# N: 나무개수, M: 가져갈 나무 길이
N, M = map(int, sys.stdin.readline().rstrip().split())
# 높이의 최대를 구하는 문제.
arr = list(map(int, sys.stdin.readline().rstrip().split()))
start = 0
end = max(arr)
result = []
# 자를 높이를 이분탐색으로 찾아내면서, 나머지 길이의 합이 M과 같을 때의 높이의 최댓값을 구하면 된다.
while start <= end:
    mid = (start+end)//2
    sum = 0
    
    for i in arr:
        if i > mid:
            sum += i - mid

    if sum == M:
        result.append(mid)
        break
    elif sum < M:   # 합계가 적다면 높이를 낮춰야 한다.
        end = mid-1
    elif sum > M:   # 합계가 많다면 높이를 높여야 한다.
        result.append(mid)
        start = mid+1

print(max(result))