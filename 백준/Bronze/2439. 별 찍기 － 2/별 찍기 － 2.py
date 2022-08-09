n = int(input())

for i in range(1,n+1):
  print(' '*(n-i), end='')
  for j in range(0,i):
    print('*',end='')
  print()