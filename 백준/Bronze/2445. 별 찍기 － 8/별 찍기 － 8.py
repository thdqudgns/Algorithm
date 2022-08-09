N = int(input())
for i in range(1,N):
    print('*'*i + '' + ' '*(2*N-(2*i)) + '' + '*'*i)
print('*'*2*N)
for i in range(N-1):
    print('*'*(N-(i+1)) + '' + ' '*((2*i)+2) + '' + '*'*(N-(i+1)))