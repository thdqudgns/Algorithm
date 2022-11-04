T = 1
while T < 11:
    N = int(input())
    password = list(map(int, input().split()))
    M = int(input())
    arr = list(map(str, input().split()))
    command = []
    i = 0
    while i < len(arr):
        if arr[i] == 'I':
            x = int(arr[i+1])
            y = int(arr[i+2])
            command.append(arr[i:i+3+y])
            i = i + 3 + y
            continue
        if arr[i] == 'A':
            y = int(arr[i+1])
            command.append(arr[i:i+2+y])
            i = i + 2 + y
            continue
        if arr[i] == 'D':
            command.append(arr[i:i+3])
            i = i + 3
            continue

    x, y = 0, 0
    s = []
    for i in range(M):
        if command[i][0] == 'I':
            x = int(command[i][1])
            y = int(command[i][2])
            s = command[i][3:]
            for j in range(y):
                password.insert(x + j, s[j])
            continue
        if command[i][0] == 'D':
            x = int(command[i][1])
            y = int(command[i][2])
            for _ in range(y):
                password.pop(x)
            continue
        if command[i][0] == 'A':
            y = int(command[i][1])
            s = command[i][2:]
            for j in range(y):
                password.append(s[j])
            continue

    print(f'#{T}', end=' ')
    [print(password[i], end=' ') for i in range(10)]
    print()
    T += 1