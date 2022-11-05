T = int(input())
for tc in range(1, T+1):
    s = input()
    result = 'YES'
    if s.count('x') > 7:
        result = 'NO'
    print(f'#{tc} {result}')
