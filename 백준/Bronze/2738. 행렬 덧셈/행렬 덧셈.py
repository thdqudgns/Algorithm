# n, m 을 입력 받는다
n, m = map(int, input().split())

# n, m 크기의 행렬을 두 개 만들어 0으로 채운다
A = [[0 for i in range(m)] for j in range(n)]
B = [[0 for i in range(m)] for j in range(n)]
C = [[0 for i in range(m)] for j in range(n)]

# 첫번째 행렬 A를 입력받는다
for i in range(n):
    A[i] = list(map(int, input().split()))
    # print(A[i])

# 두번째 행렬 B를 입력받는다.
for i in range(n):
    B[i] = list(map(int, input().split()))
    # print(B[i])

# 더한다.
for i in range(n):
    for j in range(m):
        C[i][j] = A[i][j] + B[i][j]

# 출력한다.
for i in range(n):
    print(*C[i])