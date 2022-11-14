b = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/'
c = ''; d = ''; e = ''; g = ''
for t in range(int(input())):
    a = input()
    while a != '':
        c = str(b.find(a[0]))
        a = a[1:]
        d += bin(int(c))[2:].zfill(6)
    while d !='':
        e += chr(int(d[:8],2))
        d = d[8:]
    print(f'#{t+1}', e)
    c=''; d=''; e=''