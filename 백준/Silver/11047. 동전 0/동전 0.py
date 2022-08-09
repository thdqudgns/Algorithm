import sys
N, K = map(int, sys.stdin.readline().strip().split(' '))   # input() 보다 훨씬 빠르다
A = []
for i in range(N):
    A.append(int(sys.stdin.readline()))
# A = [1,5,10,50,100,500,1000,5000,10000,50000]
mok = 0
while K != 0:
    mok += K // A[N-1]
    K %= A[N-1]     # 입력받은 수를 가장크게 나눌 수 있는 수로 나눈 나머지를 K에 저장한다.
    N -= 1          # 그다음 수로 나누기 위해 -1 한다.

print(mok)