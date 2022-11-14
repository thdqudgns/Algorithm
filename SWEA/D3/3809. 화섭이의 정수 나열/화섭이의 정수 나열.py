for tc in range(1, int(input())+1):
    n = int(input())
    num = 0
    s = input()
    s = s.replace(' ', '')
    while n > len(s):
        s += input()
        s = s.replace(' ', '')
    s = s.replace(' ', '')

    while True:
        if str(num) not in s:
            break
        num += 1
    print(f'#{tc} {num}')