# 월요일이면 0, 화요일이면 1, 수요일이면 2, 목요일이면 3, 금요일이면 4, 토요일이면 5, 일요일이면 6
# 2016년 1월 1일은 금요일
year = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
week = {0:3, 1:4, 2:5, 3:6, 4:0, 5:1, 6:2}
T = int(input())
for tc in range(1, T+1):
    m, d = map(int, input().split())
    date = sum(year[:m]) + d    # 날짜를 하루씩 더함
    day = date%7                # 총 날짜를 7로 나눠 요일을 구함
    print(f'#{tc} {week[day]}') # 요일 구할 때 딕셔너리 사용