T = int(input())
arr = 'abcdefghijklmnopqrstuvwxyz'
for test_case in range(1, T + 1):
    a = input()
    cnt = 0
    for i in range(len(a)):
        if a[i] == arr[i]:
            cnt += 1
        else:
            break
    print('#{} {}'.format(test_case, cnt))
