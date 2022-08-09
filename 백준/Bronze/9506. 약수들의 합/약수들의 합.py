n = 0
while n != -1:
    nlist = []
    n = int(input())

    if n == -1:
        break

    i = 1
    while n > i:
        if n%i == 0:
            nlist.append(i)
        i += 1

    sum = 0
    for j in range(len(nlist)):
        sum += nlist[j]

    if n == sum:
        print(str(n) + ' = ', end='')
        for k in range(len(nlist)):
            if k == len(nlist)-1:
                print(str(nlist[k]))
            else:
                print(str(nlist[k]) + ' + ', end='')
    else:
        print(str(n) + ' is NOT perfect.')