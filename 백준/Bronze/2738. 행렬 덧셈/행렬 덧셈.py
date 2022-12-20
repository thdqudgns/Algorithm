import sys
# n, m 을 입력 받는다
n, m = map(int, sys.stdin.readline().rstrip().split())

# n, m 크기의 행렬을 만들어 0으로 채운다
C = [[0 for _ in range(m)] for _ in range(n)]

# 첫번째 행렬 A를 입력받아 C에 더한다
for i in range(n):
    tmp = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(m):
        C[i][j] += tmp[j]

# 두번째 행렬 B를 입력받아 C에 더한다.
for i in range(n):
    tmp = list(map(int, sys.stdin.readline().rstrip().split()))
    for j in range(m):
        C[i][j] += tmp[j]

# 출력한다.
for i in range(n):
    print(*C[i])