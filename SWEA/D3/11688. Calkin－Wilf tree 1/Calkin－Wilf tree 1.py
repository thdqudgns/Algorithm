for i in range(1, int(input())+1):
    data = input()
    a, b = 1, 1
    for w in data:
        if w == 'L':
            a, b = a, a+b
        if w == 'R':
            a, b = a+b, b
    if a%b == 0 or b%a == 0:
        big, small = 0, 0
        if a > b:
            big, small = a, b
        else:
            big, small = b, a
        for num in range(small, 0, -1):
            if a%num == 0 and b%num == 0:
                a //= num
                b //= num
    print('#{} {} {}'.format(i, a, b))