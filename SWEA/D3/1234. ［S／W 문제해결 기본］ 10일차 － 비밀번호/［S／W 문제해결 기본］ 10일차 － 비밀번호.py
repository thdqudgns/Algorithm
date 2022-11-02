for i in range(1, 11):
    N, password = map(str, input().split())
    password = list(password)
    length = 0
    short = 0
    flag = True
    while flag:
        length = len(password)
        for j in range(len(password)-1):
            if password[j] == password[j+1]:
                password.pop(j)
                password.pop(j)
                short = len(password)
                break
        if length == short:
            break
    print(f'#{i}', ''.join(password))

