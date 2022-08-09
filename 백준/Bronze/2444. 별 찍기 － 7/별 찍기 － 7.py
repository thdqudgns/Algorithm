N = int(input())
for i in range(N):
    print(' '*(N-(i+1)) + '' + '*'*((2*i)+1))
for i in range(1,N):
    print(' '*i + '' + '*'*(2*N-(2*i+1)))