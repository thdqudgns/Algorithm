date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

T = int(input())
for tc in range(1, T+1):
    m1, d1, m2, d2 = map(int, input().split())
    result = sum(date[m1:m2]) + d2 - d1 + 1
    print(f'#{tc} {result}')