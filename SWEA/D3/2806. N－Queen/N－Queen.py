def is_Possible(x):
        global board
        for i in range(x):
            #직선 or 대각선 방향 검사
            if board[x] == board[i] or abs(board[i] - board[x]) == x- i:
                return False
        return True
     
def dfs(x):
        global ans, N, board
        if x == N:
            ans += 1
            return
        for i in range(N):
            board[x] = i
            if is_Possible(x):
                dfs(x+1)
                 
T = int(input())
for test_case in range(1, T + 1):               
    N = int(input())
    ans = 0
    board = [0] * N
    dfs(0)
    print("#{0} {1}".format(test_case, ans))