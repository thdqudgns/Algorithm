# https://yoonsang-it.tistory.com/m/33
import sys, math

n = int(sys.stdin.readline())

for i in range(n):
    N, M = map(int, sys.stdin.readline().split())
    bridge = math.factorial(M)//((math.factorial(N))*(math.factorial(M-N)))
    print(bridge)