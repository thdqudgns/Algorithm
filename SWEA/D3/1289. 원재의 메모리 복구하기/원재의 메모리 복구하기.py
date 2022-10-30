for i in range(1, int(input())+1):
    cnt = 0
    data = input()
    if data[0] == '1':
        data = '0' + data
    for j in range(len(data)-1):
        if data[j] != data[j+1]:
            cnt += 1
    print('#{} {}'.format(i, cnt))