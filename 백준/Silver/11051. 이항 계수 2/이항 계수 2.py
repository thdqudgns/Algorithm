from math import factorial

n, m = map(int, input().split())

res = (factorial(n) // (factorial(m)*factorial(n-m))) % 10007

print(res)