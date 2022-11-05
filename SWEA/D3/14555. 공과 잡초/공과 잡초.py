T = int(input())
for tc in range(1, T+1):
    s = input()
    s = s.replace('()', '0')
    s = s.replace('(|', '0')
    s = s.replace('|)', '0')
    # print(s)
    result = s.count('0')
    print(f'#{tc} {result}')