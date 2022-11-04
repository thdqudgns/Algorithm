year = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = {0:3, 1:4, 2:5, 3:6, 4:0, 5:1, 6:2}
T = int(input())
for tc in range(1, T+1):
    m, d = map(int, input().split())
    date = sum(year[:m]) + d
    day = date%7
    print(f'#{tc} {week[day]}')