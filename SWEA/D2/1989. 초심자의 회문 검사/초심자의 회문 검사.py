for tc in range(1, int(input())+1):
    s = input()
    if s == s[::-1]:
        print(f'#{tc} {1}')
    else:
        print(f'#{tc} {0}')