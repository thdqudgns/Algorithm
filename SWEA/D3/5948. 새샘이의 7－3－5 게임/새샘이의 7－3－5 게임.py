# 5948. 새샘이의 7-3-5 게임
for tc in range(1, int(input())+1):
    arr = list(map(int, input().split()))
    result = set()
    for i in range(7):
        for j in range(i+1, 7):
            for k in range(j+1, 7):
                result.add(arr[i]+arr[j]+arr[k])
    result = sorted(result)
    print(f'#{tc} {result[-5]}')