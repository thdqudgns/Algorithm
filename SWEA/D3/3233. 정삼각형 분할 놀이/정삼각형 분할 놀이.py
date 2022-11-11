# 3233. 정삼각형 분할 놀이
for tc in range(1, int(input())+1):
    a, b = map(int, input().split())
    result = 0
    for i in range(a//b):
        result += (i*2)+1
    print(f'#{tc} {result}')