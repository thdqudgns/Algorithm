while 1:
    arr = sorted(map(int, input().rstrip().split()))
    if arr[0] == 0 and arr[1] == 0 and arr[2] == 0:
        break
    if pow(arr[2],2) == pow(arr[0],2) + pow(arr[1],2):
        print('right')
    else:
        print('wrong')