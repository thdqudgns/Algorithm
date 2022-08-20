while True:
    w = input()
    if w == 'END':
        break
    print(w[::-1])
    # 문자열을 뒤집는 또다른 방법
    # w = ''.join(reversed(w))
    # print(w)

