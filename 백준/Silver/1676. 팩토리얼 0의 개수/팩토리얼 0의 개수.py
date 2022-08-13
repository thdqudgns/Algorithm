n = int(input())
r=1
x=0

for i in range(n):
  r *= (i+1)

for i in str(r)[::-1]:
  if i!="0":
    print(x)
    break
  x += 1