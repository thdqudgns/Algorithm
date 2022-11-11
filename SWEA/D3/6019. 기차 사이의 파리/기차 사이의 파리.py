# 6019. 기차 사이의 파리
for tc in range(1, int(input())+1):
    d, a, b, f = map(int, input().split())
    cnt = d / (a+b)     # 시간 = 거리 / 속력
    result = f * cnt    # 거리 = 속력 * 시간
    print(f'#{tc} {result}')