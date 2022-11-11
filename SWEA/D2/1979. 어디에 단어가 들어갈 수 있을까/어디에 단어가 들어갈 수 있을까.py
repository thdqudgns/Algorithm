T = int(input())
 
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    puzzle = []
    result = 0
     
    for i in range(1, N+1):
        puzzle.append(list(map(int, input().split())))
     
    # 가로
    for n in range(N):
        count = 0
        for m in range(N):
            if puzzle[n][m] == 1:
                count += 1
            if puzzle[n][m] == 0 or m == N-1: # 0을 만나거나 마지막 열일 경우
                if count == K: # 단어가 들어갈 수 있는 자리면
                    result += 1
                if puzzle[n][m] == 0:
                    count = 0
    # 세로
    for n in range(N):
        count = 0
        for m in range(N):
            if puzzle[m][n] == 1:
                count += 1
            if puzzle[m][n] == 0 or m == N-1: # 0을 만나거나 마지막 열일 경우
                if count == K: # 단어가 들어갈 수 있는 자리면
                    result += 1
                if puzzle[m][n] == 0:
                    count = 0
                 
    print('#%d %d'%(test_case,result))
             