s = input().split(' ')
if s[0] == '':
    s.pop(0)
if s[-1] == '':
    s.pop(-1)
print(len(s))
