# 4676. 늘어지는 소리 만들기
for tc in range(1, int(input())+1):
    L = list(input())
    H = int(input())
    arr = sorted(map(int, input().split()), reverse=True)
    for i in arr:
        L.insert(i, '-')
    print(f'#{tc} {"".join(L)}')