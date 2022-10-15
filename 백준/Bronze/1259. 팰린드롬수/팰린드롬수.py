import sys
input = sys.stdin.readline
flag = 'yes'
while 1:
    w = input().rstrip()
    if w == '0':
        break
    for i in range(len(w)):
        if w[i] == w[-(i+1)]:
            flag = 'yes'
        else:
            flag = 'no'
            break
    print(flag)
