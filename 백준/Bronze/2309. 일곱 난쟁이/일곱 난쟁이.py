import sys
a = []
for i in range(9):
    a.append(int(sys.stdin.readline()))
two_false = sum(a) - 100
for i in range(8):
    for j in range(i+1,9):
        if a[i] + a[j] == two_false:
            exit_1 = a[i]
            exit_2 = a[j]
            a.remove(exit_1)
            a.remove(exit_2)
            a.sort()
            break
        else:
            continue
    if len(a) == 7:
        break
for i in a:
    print(i)