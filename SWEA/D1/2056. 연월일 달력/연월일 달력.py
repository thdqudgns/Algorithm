month = [0,31,28,31,30,31,30,31,31,30,31,30,31]
T = int(input())
for i in range(1, T+1):
    a = input()
    if int(a[6:]) > month[int(a[4:6])] or int(a[4:6]) < 1 or int(a[4:6]) > 12:
        print('#%d -1' % i)
    else:
        print('#%d %s/%s/%s' % (i, a[0:4], a[4:6], a[6:8]))