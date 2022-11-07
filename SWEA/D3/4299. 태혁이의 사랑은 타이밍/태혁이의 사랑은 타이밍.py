# 4299. 태혁이의 사랑은 타이밍
for tc in range(1, int(input())+1):
    d, h, m = map(int, input().split())
    result = 0
    if (d == 11 and h < 11) or (d == 11 and h == 11 and m < 11):
        print(f'#{tc} {-1}')
        continue

    if m < 11:
        result += m+49
        h -= 1
    else:
        result += m-11

    if h < 11:
        result += (h+13)*60
        d -= 1
    else:
        result += (h-11)*60

    result += (d-11)*24*60

    print(f'#{tc} {result}')