for i in range(1, 11):
    originLength = int(input())
    originPW = list(map(str, input().split()))
    commandCnt = int(input())
    command = list(map(str, input().split()))
    j = 0
    while j < len(command):
        if command[j] == 'I':
            x = int(command[j+1])
            y = int(command[j+2])
            add = command[j+3:j+3+y]
            for k in range(y):
                originPW.insert(x+k, add[k])
            j = j+3+y
    print(f'#{i}', end=' ')
    [print(originPW[i], end=' ') for i in range(10)]
    print()