n = int(input())
for i in range(n):
    w = list(map(str,input()))
    if 97 <= ord(w[0]) <= 122:
        w[0] = str(chr(ord(w[0]) - 32))
        print(''.join(w))
    else:
        print(''.join(w))