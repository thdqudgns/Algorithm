t=int(input())
for _ in range(t):
  k=int(input())
  n=list(map(int, input().split()))
  e=0
  while k>1:
    idx=n.index(max(n))
    e=e-sum(n[:idx])+n[idx]*idx
    n=n[(idx+1):]
    k-=idx+1
  print(f'#{_+1} {e}')