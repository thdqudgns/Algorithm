# N만큼의 수들이 동그랗게 있다.
# K씩 건너뛰면서 있는 수를 제거한다.
import sys

N, K = map(int, sys.stdin.readline().strip().split())

circle = [i for i in range(1, N+1)]
result = []
index = 0
for j in range(N):
    index += K-1
    if index >= len(circle):
        index %= len(circle)
    result.append(circle[index])
    circle.pop(index)

print(str(result).replace('[', '<').replace(']', '>'))