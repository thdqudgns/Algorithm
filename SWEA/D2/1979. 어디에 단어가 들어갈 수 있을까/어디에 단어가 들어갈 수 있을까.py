T = int(input())
for test_case in range(1,T+1):
  N,M = map(int,input().split())
  #N*N , M은단어길이
  arr = [list(map(int,input().split())) for _ in range(N)]
  # 1번 가로에 있는지 확인
  result = 0
  for i in range(N):
    cnt = 0
    for j in range(N):
      if arr[i][j]==1:
        cnt+=1
      else:
        if cnt==M:
            result+=1
        cnt = 0
    if cnt==M:
      result+=1
  #세로에 있는지 확인
  arr90 = list(zip(*arr[::-1]))
  for i in range(N):
    cnt = 0
    for j in range(N):
      if arr90[i][j]==1:
        cnt+=1
      else:
        if cnt==M:
            result+=1
        cnt = 0
    if cnt==M:
      result+=1
  print('#{} {}'.format(test_case,result))