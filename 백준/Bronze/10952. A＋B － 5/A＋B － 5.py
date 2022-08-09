import sys
# 두 수를 입력받아서 더하고 출력하는 작업을 반복해야 한다.
while 1:
    A,B = map(int,sys.stdin.readline().split())
    if (A==0 and B==0):
        break
    print(A+B)
# 0 0이 입력되면 멈춘다