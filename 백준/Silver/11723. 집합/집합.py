import sys
M = int(sys.stdin.readline())
S = set()
for i in range(M):
    arr = list(map(str, sys.stdin.readline().rstrip().split()))
    try:
        com, num = arr[0], int(arr[1])
    except:
        com = arr[0]

    if com == 'add':
        S.add(num)
    if com == 'remove' and num in S:
        S.remove(num)
    if com == 'check':
        if num in S:
            print(1)
        else:
            print(0)
    if com == 'toggle':
        if num in S:
            S.remove(num)
        else:
            S.add(num)
    if com == 'all':
        S = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
    if com == 'empty':
        S = set()
