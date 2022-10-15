import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
arr = list(map(int, input().rstrip().split()))
hap = 0

for i in range(N):
    for j in range(i+1,N):          # i 다음부터
        for k in range (j+1,N):     # j 다음부터
            if arr[i] + arr[j] + arr[k] > M:    # M보다 크면 pass
                continue
            else:
                hap = max(hap, arr[i] + arr[j] + arr[k])    # 이전의 합과 지금의 합을 비교하여 더 큰 걸로 저장

# 최댓값이 될 때의 카드 3장까지 보여주려면
# 합을 저장할 때의 arr[i], arr[j], arr[k] 까지 저장하면 된다.
print(hap)