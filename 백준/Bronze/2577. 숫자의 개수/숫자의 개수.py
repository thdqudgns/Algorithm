A = int(input())
B = int(input())
C = int(input())

P = str(A*B*C)
Q = [0 for i in range(10)]

for i in P:
    Q[int(i)] += 1

for i in range(10):
    print(Q[int(i)])
