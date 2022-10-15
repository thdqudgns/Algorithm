import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
A = [[0 for _ in range(M)] for _ in range(N)]   # 열쪽을 []로 묶어 줘야 한다.
B = [[0 for _ in range(M)] for _ in range(N)]   # 따로 생성해줘야 한다.
answer = [[0 for _ in range(M)] for _ in range(N)]
# print(A)
# print(B)

for i in range(N):
    A[i] = list(map(int, input().rstrip().split()))

for i in range(N):
    B[i] = list(map(int, input().rstrip().split()))

# print(A)
# print(B)

for i in range(N):
    for j in range(M):
        answer[i][j] = A[i][j] + B[i][j]

[print(*i) for i in answer]