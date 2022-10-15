import math
from sys import stdin
n, k= map(int, stdin.readline().split())

a = math.factorial(n)
b = math.factorial(k)
c = math.factorial(n-k)

print(a // (b * c))