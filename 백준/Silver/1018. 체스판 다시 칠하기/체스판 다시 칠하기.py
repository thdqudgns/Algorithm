n, m = map(int, input().split())
board = []  # 입력 받은 전체 체스판 리스트
mini_board = []  # 8x8 체스판 리스트

for _ in range(n):
    board.append(input())  # 전체 체스판을 리스트에 저장

for row in range(n - 7):  # ex) 입력 받은 체스판의 가로 길이가 8이면 1번만 반복문을 돌면 된다.
    for column in range(m - 7):  # ex) 마찬가지로 입력 받은 체스판의 세로 길이가 8이면 1번만 반복문을 돌면 된다.
        white_start = 0
        black_start = 0
        for b in range(row, row + 8):
            for j in range(column, column + 8):
                if (b + j) % 2 == 0:  # 8x8 체스판을 B와 W로 번갈아가면서 검사
                    if board[b][j] != 'W':
                        white_start += 1
                    elif board[b][j] != 'B':
                        black_start += 1
                else:
                    if board[b][j] != 'B':
                        white_start += 1
                    elif board[b][j] != 'W':
                        black_start += 1
        mini_board.append(white_start)  # W로 시작했을 때
        mini_board.append(black_start)  # B로 시작했을 때

print(min(mini_board))   