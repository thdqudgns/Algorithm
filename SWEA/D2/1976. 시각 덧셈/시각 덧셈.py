# 1976. 시각 덧셈
for tc in range(1, int(input())+1):
    h1, m1, h2, m2 = map(int, input().split())
    sumTime = h1*60 + m1 + h2*60 + m2
    h = (sumTime//60)%12
    if h == 0:
        h = 12
    m = sumTime%60
    print(f'#{tc} {h} {m}')