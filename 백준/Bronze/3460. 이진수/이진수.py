import sys

T = int(input())

for i in range(T):
  n = int(sys.stdin.readline())
  a = []  # 나머지를 넣을 배열
  d = 0   # a의 index
  while n != 0:
    a.append(n%2)
    # print(a)
    if n%2 == 1:
      print(d, end=' ')
    n //= 2
    d += 1
  print()