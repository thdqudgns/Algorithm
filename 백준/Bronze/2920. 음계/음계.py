umm = list(map(int, input().split()))
result = 'm'
for i in range(7):
    if umm[i] - umm[i+1] == 1:
        result = 'd'
        continue
    elif umm[i] - umm[i+1] == -1:
        result = 'a'
        continue
    else:
        result = 'm'
        break

if result == 'm':
    print('mixed')
elif result == 'a':
    print('ascending')
elif result == 'd':
    print('descending')