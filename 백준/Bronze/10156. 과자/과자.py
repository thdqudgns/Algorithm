K, N, M = map(int, input().split(' '))
result = M-K*N
if result < 0: result = -result
elif result > 0: result = 0
print(result)