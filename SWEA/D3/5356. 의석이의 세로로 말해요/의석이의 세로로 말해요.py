T = int(input())
for tc in range(1, T+1):
    word = [input() for _ in range(5)]
    result = ''
    for i in range(15):
        for j in range(5):
            try:
                result += word[j][i]
            except:
                pass
    print(f'#{tc} {result}')